package com.tech.court.dao.primary;

import com.tech.court.entity.JudgeStatistics;
import com.tech.court.entity.JudgeStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JudgeStatisticsMapper {
    long countByExample(JudgeStatisticsExample example);

    int deleteByExample(JudgeStatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JudgeStatistics record);

    int insertSelective(JudgeStatistics record);

    List<JudgeStatistics> selectByExample(JudgeStatisticsExample example);

    JudgeStatistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JudgeStatistics record, @Param("example") JudgeStatisticsExample example);

    int updateByExample(@Param("record") JudgeStatistics record, @Param("example") JudgeStatisticsExample example);

    int updateByPrimaryKeySelective(JudgeStatistics record);

    int updateByPrimaryKey(JudgeStatistics record);
}