package com.tech.court.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.tech.court.dao.remote", sqlSessionTemplateRef = "remoteSqlSessionTemplate")
public class RemoteDateSourceConfig {

  @ConfigurationProperties(prefix = "remote.datasource.druid")
  @Bean(name = "remoteDatasource", initMethod = "init", destroyMethod = "close")
  public DruidDataSource remoteDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "remoteSqlSessionFactory")
  public SqlSessionFactory primaryTestSqlSessionFactory(@Qualifier("remoteDatasource")
      DataSource remoteDatasource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

    sessionFactory.setDataSource(remoteDatasource);
//        // 分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//        // 添加插件
//        // PageHelper是Interceptor接口的实现类
//        // 基于接口实现的多态
//        // 指向接口的引用（pageHelper）必须是实现了该接口的一个类的实例程序（implements Interceptor），在运行时，根据对象引用的实际类型来执行对应的方法。
//        // 也就是说，可以根据这个特性，对SpringBoot定制特殊功能。
//        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
//        MapperHelper mapperHelper = new MapperHelper();
//        //特殊配置
//        Config config = new Config();
//        //具体支持的参数看后面的文档
//        config.setIDENTITY("MYSQL");
//        config.setNotEmpty(false);
//        //设置配置
//        mapperHelper.setConfig(config);
//        // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
//        mapperHelper.registerMapper(MyMapper.class);
//        //配置完成后，执行下面的操作
//        mapperHelper.processConfiguration(sessionFactory.getObject().openSession().getConfiguration());

    //指定mapper xml目录
    sessionFactory
        .setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/remote/*.xml"));
//            sessionFactory.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
    return sessionFactory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(remoteDataSource());
  }

  @Bean(name = "remoteSqlSessionTemplate")
  public SqlSessionTemplate testSqlSessionTemplate(
      @Qualifier("remoteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
