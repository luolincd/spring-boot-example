package com.tech.court.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.tech.court.dao.mybatis.CommonMapper;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * 数据源
 *
 * @author xwolf
 * @version 1.0.0
 * @since 1.8
 */
@Configuration
@MapperScan(basePackages = "com.tech.court.dao.primary", sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class DataSourceConfig {

  @ConfigurationProperties(prefix = "datasource.druid")
  @Bean(name = "datasource", initMethod = "init", destroyMethod = "close")
  @Primary
  public DruidDataSource getDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "primarySqlSessionFactory")
  @Primary
  public SqlSessionFactory primaryTestSqlSessionFactory(@Qualifier("datasource")
      DataSource datasource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

    sessionFactory.setDataSource(datasource);

    //指定mapper xml目录
    sessionFactory
        .setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/primary/*.xml"));
//            sessionFactory.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
    return sessionFactory.getObject();
  }

  @Bean
  @Primary
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(getDataSource());
  }

  @Bean(name = "primarySqlSessionTemplate")
  @Primary
  public SqlSessionTemplate testSqlSessionTemplate(
      @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  // 指定环境下dev 开启监控
  @Bean
  @Profile("dev")
  public FilterRegistrationBean druidFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new WebStatFilter());
    Map<String, String> intParams = new HashMap<>();
    intParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    registration.setName("DruidWebStatFilter");
    registration.setUrlPatterns(Lists.newArrayList("/*"));
    registration.setInitParameters(intParams);
    return registration;
  }

  //数据源监控
  @Bean
  @Profile("dev")
  public ServletRegistrationBean servletRegistrationBean() {
    ServletRegistrationBean registration = new ServletRegistrationBean();
    registration.setServlet(new StatViewServlet());
    registration.setName("druid");
    registration.setUrlMappings(Lists.newArrayList("/druid/*"));
    //自定义添加初始化参数
    Map<String, String> intParams = new HashMap<>();
    intParams.put("loginUsername", "druid");
    intParams.put("loginPassword", "druid");
    registration.setName("DruidWebStatFilter");
    registration.setInitParameters(intParams);
    return registration;
  }
}
