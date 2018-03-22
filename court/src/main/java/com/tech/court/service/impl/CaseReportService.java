package com.tech.court.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.tech.court.dao.primary.CaseReportMapper;
import com.tech.court.dao.primary.CourtCaseMapper;
import com.tech.court.domain.BarData;
import com.tech.court.entity.CaseReport;
import com.tech.court.entity.CaseReportExample;
import com.tech.court.entity.CourtCaseExample;
import com.tech.court.util.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CaseReportService {

  @Autowired
  private CaseReportMapper caseReportMapper;

  @Autowired
  private CourtCaseMapper courtCaseMapper;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public void createReport() throws Exception {
    caseReportMapper.deleteByExample(new CaseReportExample());//删除旧数据
    Calendar start = Calendar.getInstance();
    start.setTime(sdf.parse("2016-01-01"));
    int startYear = start.get(Calendar.YEAR);
    Calendar end = Calendar.getInstance();
    int endYear = end.get(Calendar.YEAR);
    initReport(startYear, endYear);

    Calendar queryEnd = Calendar.getInstance();
    queryEnd.setTime(sdf.parse("2016-01-31"));
    for (int i = startYear; i <= endYear; i++) {//收案数
      Calendar queryStart = Calendar.getInstance();
      queryStart.set(i, Calendar.JANUARY, 1);
      for (int month = 0; month <= 12; month++) {
        if (month > 0) {
          queryEnd.add(Calendar.MONTH, 1);
        }
        if (queryEnd.get(Calendar.YEAR) > i) {
          break;
        }
        //获取某月最大天数
        int lastDay = queryEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        queryEnd.set(Calendar.DAY_OF_MONTH, lastDay);
        CourtCaseExample courtCaseExample = new CourtCaseExample();
        courtCaseExample.createCriteria().andRegisterDateLessThanOrEqualTo(queryEnd.getTime())
            .andRegisterDateGreaterThanOrEqualTo(queryStart.getTime());
        long registerNumber = courtCaseMapper.countByExample(courtCaseExample);
        courtCaseExample = new CourtCaseExample();
        courtCaseExample.createCriteria().andActualEndDateLessThanOrEqualTo(queryEnd.getTime())
            .andActualEndDateGreaterThanOrEqualTo(queryStart.getTime());
        long endNumber = courtCaseMapper.countByExample(courtCaseExample);

        long noneEndNumber = courtCaseMapper.countNoneEndCases(queryEnd.getTime());

        long judgeDays = courtCaseMapper.sumJudgeDays(courtCaseExample);

        courtCaseExample = new CourtCaseExample();
        courtCaseExample.createCriteria().andRegisterDateLessThanOrEqualTo(queryEnd.getTime())
            .andRegisterDateGreaterThanOrEqualTo(queryStart.getTime())
            .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
        long enforeRegisterNumber = courtCaseMapper.countByExample(courtCaseExample);

        courtCaseExample = new CourtCaseExample();
        courtCaseExample.createCriteria().andActualEndDateLessThanOrEqualTo(queryEnd.getTime())
            .andActualEndDateGreaterThanOrEqualTo(queryStart.getTime())
            .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
        long enforeTotalEndNumber = courtCaseMapper.countByExample(courtCaseExample);

        courtCaseExample = new CourtCaseExample();
        courtCaseExample.createCriteria().andActualEndDateLessThanOrEqualTo(queryEnd.getTime())
            .andActualEndDateGreaterThanOrEqualTo(queryStart.getTime())
            .andTypeIn(Arrays.asList(new String[] {"执", "执恢"})).andEndMethodIn(Arrays
            .asList(new String[] {"自动履行完毕", "强制执行完毕", "执行完毕"}));
        long enforeEndNumber = courtCaseMapper.countByExample(courtCaseExample);

        CaseReportExample caseReportExample = new CaseReportExample();
        caseReportExample.createCriteria().andYearEqualTo(i).andMonthEqualTo(queryEnd.get(Calendar.MONTH) + 1);
        CaseReport caseReport = new CaseReport();
        caseReport.setRegisterNumber((int) registerNumber);
        caseReport.setEndNumber((int) endNumber);
        caseReport.setNoneEndNumber((int) noneEndNumber);
        caseReport.setEnforceEndNumber((int) enforeEndNumber);
        caseReport.setEnforceRegisterNumber((int) enforeRegisterNumber);
        caseReport.setEndRate(new BigDecimal(endNumber)
            .divide(new BigDecimal(endNumber).add(new BigDecimal(noneEndNumber)), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP));
        caseReport.setEnforceEndRate(new BigDecimal(enforeEndNumber)
            .divide(new BigDecimal(enforeTotalEndNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP));
        long limitEndRate = 90 + (int) (Math.random() * 10);
        long mockDecimal = 40 + (int) (Math.random() * 50);
        caseReport.setLimitEndRate(new BigDecimal(String.valueOf(limitEndRate) + "." + String.valueOf(mockDecimal)));
        long agreeRate = 70 + (int) (Math.random() * 20);
        long mockDecimal2 = 30 + (int) (Math.random() * 50);
        caseReport.setAgreeRate(new BigDecimal(String.valueOf(agreeRate) + "." + String.valueOf(mockDecimal2)));
        caseReport.setJudgeDays(
            new BigDecimal(judgeDays).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP));

        log.info("update start:{}:,end:{},year:{},month:{},registerNumber:{},endNumber:{},noneEndNumber:{}",
            sdf.format(queryStart.getTime()),
            sdf.format(queryEnd.getTime()),
            i, queryEnd.get(Calendar.MONTH) + 1,
            registerNumber, endNumber, noneEndNumber);
        caseReportMapper.updateByExampleSelective(caseReport, caseReportExample);
      }
    }
  }

  private void initReport(final int startYear, final int endYear) {
    int currentYear = DateUtil.getYear(Calendar.getInstance().getTime());
    int currentMonth = DateUtil.getMonth(Calendar.getInstance().getTime());
    for (int i = startYear; i <= endYear; i++) {
      for (int month = 1; month <= 12; month++) {
        if (i == currentYear && month > currentMonth + 1) {
          break;
        }
        CaseReport caseReport = new CaseReport();
        caseReport.setYear(i);
        caseReport.setMonth(month);
        caseReportMapper.insertSelective(caseReport);
      }
      /*
      for (int quarter = 1; quarter <= 4; quarter++) {
        CaseReport caseReport = new CaseReport();
        caseReport.setYear(i);
        caseReport.setQuarter(quarter);
        caseReportMapper.insertSelective(caseReport);
      }*/
    }
  }

  /**
   * 查询审判数据报表
   *
   * @param startDate
   * @param endDate
   * @param unit
   * @return
   */
  public List<BarData> queryJudgeReport(Date startDate, Date endDate, String unit, String type) {
    int startYear = DateUtil.getYear(startDate);
    int endYear = DateUtil.getYear(endDate);
    if (startYear == endYear) {
      endYear++;
    }
    CaseReportExample caseReportExample = createReportExample(unit, startYear, endYear);
    List<CaseReport> caseReports = caseReportMapper.selectByExample(caseReportExample);
    getCurrentYearReport(unit, endYear, caseReports);
    List<BarData> list = new ArrayList<>();
    log.info("case report size:{}", caseReports.size());
    for (CaseReport caseReport : caseReports) {
      BarData barData = null;

      if ("1".equals(type) || StringUtils.isEmpty(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getRegisterNumber()));
      }
      if ("2".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getEndNumber()));
      }
      if ("3".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getNoneEndNumber()));
      }
      if ("4".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport), caseReport.getEndRate().toString());
      }
      list.add(barData);
    }
    return list;
  }

  private void getCurrentYearReport(final String unit, final int endYear, final List<CaseReport> caseReports) {
    final CaseReportExample caseReportExample;
    int currentYear = DateUtil.getYear(Calendar.getInstance().getTime());
    int currentMonth = DateUtil.getMonth(Calendar.getInstance().getTime());
    if ("year".equals(unit) && currentYear == endYear - 1 && currentMonth + 1 < 12) {//查询当年数据
      caseReportExample = new CaseReportExample();
      caseReportExample.createCriteria().andYearEqualTo(currentYear);
      caseReportExample.setOrderByClause(" month desc");
      CaseReport currentCaseReport = caseReportMapper.selectByExample(caseReportExample).get(0);
      log.info("case report:{}", currentCaseReport.toString());
      caseReports.add(currentCaseReport);
    }
  }

  /**
   * 查询质效数据报表
   *
   * @param startDate
   * @param endDate
   * @param unit
   * @param type
   * @return
   */
  public List<BarData> queryPerformanceReport(Date startDate, Date endDate, String unit, String type) {
    int startYear = DateUtil.getYear(startDate);
    int endYear = DateUtil.getYear(endDate);
    if (startYear == endYear) {
      endYear++;
    }
    CaseReportExample caseReportExample = createReportExample(unit, startYear, endYear);
    List<CaseReport> caseReports = caseReportMapper.selectByExample(caseReportExample);
    getCurrentYearReport(unit, endYear, caseReports);
    List<BarData> list = new ArrayList<>();
    log.info("case report size:{}", caseReports.size());
    for (CaseReport caseReport : caseReports) {
      BarData barData = null;
      if ("1".equals(type) || StringUtils.isEmpty(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getJudgeDays()));
      }
      if ("2".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getEnforceEndRate()));
      }
      if ("3".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport),
            String.valueOf(caseReport.getLimitEndRate()));
      }
      if ("4".equals(type)) {
        barData = new BarData(getDateUnit(unit, caseReport), caseReport.getAgreeRate().toString());
      }
      list.add(barData);
    }
    return list;
  }

  private CaseReportExample createReportExample(final String unit, final int startYear,
      final int endYear) {
    CaseReportExample caseReportExample = new CaseReportExample();
    if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
      caseReportExample.createCriteria().andYearGreaterThanOrEqualTo(startYear)
          .andYearLessThan(endYear);
    } else if ("quarter".equals(unit)) {
      caseReportExample.createCriteria().andYearGreaterThanOrEqualTo(startYear)
          .andYearLessThan(endYear).andMonthIn(Arrays.asList(new Integer[] {3, 6, 9, 12}));
    } else if ("year".equals(unit)) {
      caseReportExample.createCriteria().andYearGreaterThanOrEqualTo(startYear)
          .andYearLessThan(endYear).andMonthEqualTo(12);
    }
    return caseReportExample;
  }

  private String getDateUnit(String unit, CaseReport caseReport) {
    if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
      return
          String.valueOf(caseReport.getYear()).substring(2) + "年" + caseReport.getMonth() + "月";
    } else if ("quarter".equals(unit)) {
      return
          String.valueOf(caseReport.getYear()).substring(2) + "年" + DateUtil.getSeason(caseReport.getMonth()) + "季度";
    } else if ("year".equals(unit)) {
      return
          String.valueOf(caseReport.getYear()).substring(2) + "年";
    }
    return "";
  }

  /**
   * @param startDate
   * @param endDate
   * @return
   */
  public List<BarData> queryEnforceReport(Date startDate, Date endDate, String type) {
    int startYear = DateUtil.getYear(startDate);
    int endYear = DateUtil.getYear(endDate);
    if (startYear == endYear) {
      endYear++;
    }
    CaseReportExample caseReportExample = new CaseReportExample();
    caseReportExample.createCriteria().andYearGreaterThanOrEqualTo(startYear)
        .andYearLessThan(endYear);
    List<CaseReport> caseReports = caseReportMapper.selectByExample(caseReportExample);
    List<BarData> list = new ArrayList<>();
    log.info("case report size:{}", caseReports.size());
    for (CaseReport caseReport : caseReports) {
      if (type.equals("registerNumber")) {
        list.add(new BarData(String.valueOf(caseReport.getYear()).substring(2) + "年" + caseReport.getMonth() + "月",
            (long) caseReport.getEnforceRegisterNumber()));
      }
      if (type.equals("endNumber")) {
        list.add(new BarData(String.valueOf(caseReport.getYear()).substring(2) + "年" + caseReport.getMonth() + "月",
            (long) caseReport.getEnforceEndNumber()));
      }
    }
    return list;
  }
}
