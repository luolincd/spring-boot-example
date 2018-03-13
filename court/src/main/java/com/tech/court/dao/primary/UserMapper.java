package com.tech.court.dao.primary;

import org.apache.ibatis.annotations.Param;

import com.tech.court.domain.JudgementStatistics;
import com.tech.court.entity.User;
import com.tech.court.entity.UserExample;

import java.util.List;

public interface UserMapper {
  List<JudgementStatistics> countEducation(UserExample example);

  long countByExample(UserExample example);

  int deleteByExample(UserExample example);

  int insert(User record);

  int insertSelective(User record);

  List<User> selectByExample(UserExample example);

  int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

  int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}