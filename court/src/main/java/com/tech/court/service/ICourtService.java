package com.tech.court.service;

import com.tech.court.domain.CaseCountBo;
import com.tech.court.domain.CaseQuery;
import com.tech.court.domain.CourtLiveBo;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.entity.CourtCase;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ICourtService {
  List<CourtLiveBo> getCourtLives();

  List<JudgementStatistics> getJudgeGradeStatistics(Date startDate, Date endDate, String type);

  Map getJudgementSummary(Date startDate, Date endDate);

  Map getCourtLiveSummary();

  CaseCountBo countCase(Date startDate, Date endDate, String unit, String type);

  CaseCountBo countPerformance(Date startDate, Date endDate, String unit, String type);

  List<JudgementStatistics> getEnforceMethod(Date startDate, Date endDate);

  CaseCountBo countEnforceCase(Date startDate, Date endDate);

  Map getEnforceSummary(Date startDate, Date endDate);

  List<JudgementStatistics> getDepartment(Date startDate, Date endDate);

  List<CourtCase> queryCourtCase(CaseQuery caseQuery) throws Exception;

  List<JudgementStatistics> caseTypeStatistics(Date startDate, Date endDate);

  List<JudgementStatistics> getStatus(Date startDate, Date endDate);

  Map getPerformanceSummay(Date startDate, Date endDate);

  Map getDepartmentSummary(Date startDate, Date endDate);

  CaseCountBo countDepartmentCase(Date startDate, Date endDate);
}
