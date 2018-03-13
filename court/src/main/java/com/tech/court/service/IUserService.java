package com.tech.court.service;

import com.tech.court.domain.CaseCountBo;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.domain.RateBarBo;
import com.tech.court.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserService {

  String insert(User user);

  List<JudgementStatistics> countEducation();

  CaseCountBo countChiefjudge(Date startDate, Date endDate, String type);

  CaseCountBo countPerformance(Date startDate, Date endDate, String type);

  RateBarBo getRateBar(Date startDate, Date endDate, String type);
}
