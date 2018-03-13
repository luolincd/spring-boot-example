package com.tech.court.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.tech.court.domain.CaseCountBo;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.domain.StatisticsQuery;
import com.tech.court.service.ICourtService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("courts")
@Slf4j
public class CourtController {
  @Autowired
  private ICourtService courtService;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
  static SimpleDateFormat sdfDetail = new SimpleDateFormat("yyyy-MM-dd");

  @GetMapping(value = "/judgement-summary")
  public Map getJudgementSummary(StatisticsQuery statisticsQuery) throws ParseException {
    Date startDate = null;
    Date endDate = null;
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.getJudgementSummary(startDate, endDate);
  }

  @GetMapping(value = "/judgement-statistics")
  public List<JudgementStatistics> getJudgementStatistics(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.getJudgeGradeStatistics(startDate, endDate,
        statisticsQuery.getType());
  }

  @GetMapping(value = "/case-count")
  public CaseCountBo getCaseCount(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.countCase(startDate, endDate, statisticsQuery.getUnit(), statisticsQuery.getType());
  }

  @GetMapping(value = "/performance-count")
  public CaseCountBo getPerformanceCount(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.countPerformance(startDate, endDate, statisticsQuery.getUnit(), statisticsQuery.getType());
  }

  @GetMapping(value = "/performance-summary")
  public Map getPerformanceSummary(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.getPerformanceSummay(startDate, endDate);
  }

  @GetMapping(value = "/enforce-statistics")
  public List<JudgementStatistics> getEnforceStatistics(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.getEnforceMethod(startDate, endDate);
  }

  @GetMapping(value = "/enforce-case-count")
  public CaseCountBo getEnforceCaseCount(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.countEnforceCase(startDate, endDate);
  }

  @GetMapping(value = "/enforce-summary")
  public Map getEnforceSummary(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.getEnforceSummary(startDate, endDate);
  }

  @GetMapping(value = "/department-count")
  public List<JudgementStatistics> getDepartment(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.getDepartment(startDate, endDate);
  }

  @GetMapping(value = "/department-case")
  public CaseCountBo getDepartmentCase(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.countDepartmentCase(startDate, endDate);
  }

  @GetMapping(value = "/department-summary")
  public Map getDepartmentSummary(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdfDetail.parse(statisticsQuery.getStartDate());
      endDate = sdfDetail.parse(statisticsQuery.getEndDate());
    }
    return courtService.getDepartmentSummary(startDate, endDate);
  }

  @GetMapping(value = "/status-count")
  public List<JudgementStatistics> getStatus(StatisticsQuery statisticsQuery) throws ParseException {
    log.info("startDate:{},endDate:{}", statisticsQuery.getStartDate(), statisticsQuery.getEndDate());
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return courtService.getStatus(startDate, endDate);
  }
}
