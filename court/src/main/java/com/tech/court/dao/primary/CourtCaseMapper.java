package com.tech.court.dao.primary;

import com.tech.court.domain.BarData;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.entity.CourtCase;
import com.tech.court.entity.CourtCaseExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourtCaseMapper {
    Long countNoneEndCases(@Param("queryDate") Date queryDate);

    List<BarData> countJudgeNoneEndCases(@Param("queryDate") Date queryDate);

    List<BarData> countAcceptCase(CourtCaseExample example);

    List<BarData> countQuarterAcceptCase(CourtCaseExample example);

    List<BarData> countYearAcceptCase(CourtCaseExample example);

    List<BarData> countEndCase(CourtCaseExample example);

    List<BarData> countQuarterEndCase(CourtCaseExample example);

    List<BarData> countYearEndCase(CourtCaseExample example);

    List<BarData> countJudgeDays(CourtCaseExample example);

    List<BarData> countQuarterJudgeDays(CourtCaseExample example);

    List<BarData> countYearJudgeDays(CourtCaseExample example);

    List<JudgementStatistics> countEndMethod(CourtCaseExample example);

    List<JudgementStatistics> countDepartment(CourtCaseExample example);

    List<JudgementStatistics> countCaseType(CourtCaseExample example);

    List<JudgementStatistics> countCaseStatus(CourtCaseExample example);

    List<BarData> countChiefJudge(CourtCaseExample example);

    List<BarData> countJudgeDaysByUndertakeUser(CourtCaseExample example);

    Map getEnforceRate(CourtCaseExample example);

    Map sumEnforceAmount(CourtCaseExample example);

    long countByExample(CourtCaseExample example);

    int deleteByExample(CourtCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourtCase record);

    int insertSelective(CourtCase record);

    List<CourtCase> selectByExample(CourtCaseExample example);

    CourtCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourtCase record, @Param("example") CourtCaseExample example);

    int updateByExample(@Param("record") CourtCase record, @Param("example") CourtCaseExample example);

    int updateByPrimaryKeySelective(CourtCase record);

    int updateByPrimaryKey(CourtCase record);
}