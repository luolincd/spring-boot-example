package com.tech.court.dao.remote;

import org.apache.ibatis.annotations.Param;

import com.tech.court.dao.mybatis.CommonMapper;
import com.tech.court.entity.CourtLive;
import com.tech.court.entity.CourtLiveExample;

import java.util.List;

public interface CourtLiveMapper  {
  long countByExample(CourtLiveExample example);

  int deleteByExample(CourtLiveExample example);

  int deleteByPrimaryKey(String ftsyid);

  int insert(CourtLive record);

  int insertSelective(CourtLive record);

  List<CourtLive> selectByExample(CourtLiveExample example);

  CourtLive selectByPrimaryKey(String ftsyid);

  int updateByExampleSelective(@Param("record") CourtLive record, @Param("example") CourtLiveExample example);

  int updateByExample(@Param("record") CourtLive record, @Param("example") CourtLiveExample example);

  int updateByPrimaryKeySelective(CourtLive record);

  int updateByPrimaryKey(CourtLive record);
}