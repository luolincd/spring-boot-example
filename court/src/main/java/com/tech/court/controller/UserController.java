package com.tech.court.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.tech.court.domain.CaseCountBo;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.domain.RateBarBo;
import com.tech.court.domain.StatisticsQuery;
import com.tech.court.service.impl.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

  @GetMapping(value = "/education-count")
  public List<JudgementStatistics> getUserEducationCount() throws ParseException {
    return userServiceImpl.countEducation();
  }

  @GetMapping(value = "/chiefjudge-case")
  public RateBarBo getChiefJudgeCase(StatisticsQuery statisticsQuery) throws Exception {
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return userServiceImpl.countChiefjudge(startDate, endDate, statisticsQuery.getType());
  }

  @GetMapping(value = "/performance-case")
  public RateBarBo getChiefJudgePerformance(StatisticsQuery statisticsQuery) throws Exception {
    Date startDate = null;
    Date endDate = null;
    if (!StringUtils.isEmpty(statisticsQuery.getStartDate()) && !StringUtils.isEmpty(statisticsQuery.getEndDate())) {
      startDate = sdf.parse(statisticsQuery.getStartDate());
      endDate = sdf.parse(statisticsQuery.getEndDate());
    }
    return userServiceImpl.countPerformance(startDate, endDate, statisticsQuery.getType());
  }
}
