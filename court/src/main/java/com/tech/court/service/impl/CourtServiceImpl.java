package com.tech.court.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tech.court.config.PerformanceTypeEnum;
import com.tech.court.config.TypeEnum;
import com.tech.court.dao.primary.CourtCaseMapper;
import com.tech.court.dao.remote.CourtLiveMapper;
import com.tech.court.domain.BarData;
import com.tech.court.domain.CaseCountBo;
import com.tech.court.domain.CaseQuery;
import com.tech.court.domain.CourtLiveBo;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.domain.MutipleBarBo;
import com.tech.court.entity.CaseReport;
import com.tech.court.entity.CourtCase;
import com.tech.court.entity.CourtCaseExample;
import com.tech.court.entity.CourtLive;
import com.tech.court.entity.CourtLiveExample;
import com.tech.court.service.ICourtService;
import com.tech.court.util.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourtServiceImpl implements ICourtService {

  public static final List<String> ENFORCE_TYPE = Arrays.asList(new String[] {"执", "执恢"});
  @Autowired
  private CourtLiveMapper courtLiveMapper;

  @Autowired
  private CourtCaseMapper courtCaseMapper;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  @Autowired
  private CaseReportService caseReportService;

  public static final List<String> months = Arrays
      .asList(new String[] {"-01-31", "-02-31", "-03-31", "-04-31", "-05-31", "-06-31", "-07-31", "-08-31", "-09-31",
          "-10-31", "-11-31", "-12-31"});

  public static final List<String> quarters = Arrays.asList(new String[] {"-03-31", "-06-30", "-09-30", "-12-31"});

  @Override
  public Map getCourtLiveSummary() {
    Map summay = new HashMap();
    CourtLiveExample liveExample = new CourtLiveExample();
    liveExample.createCriteria().andKsrqEqualTo(sdf.format(new Date())).andKtlxEqualTo(1);
    long total = courtLiveMapper.countByExample(liveExample);
    summay.put("total", total);//今日庭审

    liveExample = new CourtLiveExample();
    liveExample.createCriteria().andKsrqEqualTo(sdf.format(new Date()))
        .andZtIn(Arrays.asList(new Integer[] {2, 5})).andKtlxEqualTo(1);
    long started = courtLiveMapper.countByExample(liveExample);
    summay.put("startedNumber", started);//已开庭

    //liveExample = new CourtLiveExample();
    //liveExample.createCriteria().andKsrqEqualTo(sdf.format(new Date())).andZtEqualTo(1).andKtlxEqualTo(1);
    summay.put("noStartedNumber", total - started);

    liveExample = new CourtLiveExample();
    liveExample.createCriteria().andKsrqEqualTo(sdf.format(new Date())).andKtlxEqualTo(1).andZtEqualTo(1);
    summay.put("scheduleNoStartedNumber", courtLiveMapper.countByExample(liveExample));

    return summay;
  }

  @Override
  public List<CourtLiveBo> getCourtLives() {
    List<String> courtRooms = Arrays.asList(
        new String[] {"34E227BC_26C0_116B_7F56_DCC49833896A", "5A6458D5_C995_C23F_9BEA_08DF7F40E0D5",
            "99788F03_ECC7_3A3C_7C0B_25E78C6FBCC7", "A583F7B7_4D3C_3B46_F5DB_4CF1E9173206",
            "AAB02344_64D6_8EBF_EA94_844C32136F68",
            "D324764B_5E0F_BF37_5BD3_6745F0D7FC16", "F62951B3_54E7_32B3_D4CA_CF5ABB137DEB",
            "F7E4C0E1_FCDD_6F97_E865_0A2ED01FA6E4"});
    final List<CourtLiveBo> courtLiveBos = new ArrayList<>();
    courtRooms.forEach(courtRoom -> {
      final CourtLiveExample liveExample = new CourtLiveExample();
      liveExample.createCriteria().andFtidEqualTo(courtRoom).andZtIn(Arrays.asList(new Integer[] {2, 5}));
      List<CourtLive> courtLive = courtLiveMapper.selectByExample(liveExample);
      if (!CollectionUtils.isEmpty(courtLive)) {
        courtLiveBos
            .add(
                new CourtLiveBo(courtLive.get(0).getFtmc(),
                    "http://150.35.116.20/cms/nosecure/livePlay.action?courtRoomUseId=" + courtLive.get(0).getFtsyid(),
                    courtLive.get(0).getAh() + courtLive.get(0).getAymc()));
      } else {
        final CourtLiveExample videoExample = new CourtLiveExample();
        videoExample.createCriteria().andFtidEqualTo(courtRoom).andZtEqualTo(3);
        videoExample.setOrderByClause("ksrq DESC limit 1");
        List<CourtLive> videos = courtLiveMapper.selectByExample(videoExample);
        courtLiveBos.add(
            new CourtLiveBo(videos.get(0).getFtmc(), null, null));
      }
    });
    return courtLiveBos;
  }

  @Override
  public List<JudgementStatistics> getJudgeGradeStatistics(Date startDate, Date endDate, String type) {
    if ("案件类型".equals(type)) {
      return caseTypeStatistics(startDate, endDate);
    }
    if (startDate == null || endDate == null) {
      Calendar calendar = Calendar.getInstance();
      Date date = new Date(System.currentTimeMillis());
      calendar.setTime(date);
      calendar.add(Calendar.YEAR, -1);
      endDate = new Date();
      startDate = calendar.getTime();
    }
    List<JudgementStatistics> judgeGradeStatistics = Lists.newArrayList();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndMethodEqualTo("判决").andAcceptDateBetween(startDate, endDate);
    long panJue = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("判决", panJue));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndMethodEqualTo("调解").andAcceptDateBetween(startDate, endDate);
    long tiaoJie = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("调解", tiaoJie));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndMethodIn(Arrays.asList(new String[] {"准予撤诉", "按撤诉处理"}))
        .andAcceptDateBetween(startDate, endDate);
    long cs = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("撤诉", cs));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndMethodEqualTo("驳回起诉").andAcceptDateBetween(startDate, endDate);
    long bohui = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("驳回起诉", bohui));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndMethodEqualTo("不予受理").andAcceptDateBetween(startDate, endDate);
    long noneUndertake = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("不予受理", noneUndertake));

    return judgeGradeStatistics;
  }

  @Override
  public List<JudgementStatistics> caseTypeStatistics(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      Calendar calendar = Calendar.getInstance();
      Date date = new Date(System.currentTimeMillis());
      calendar.setTime(date);
      calendar.add(Calendar.YEAR, -1);
      endDate = new Date();
      startDate = calendar.getTime();
    }
    List<JudgementStatistics> judgeGradeStatistics = Lists.newArrayList();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andTypeLike("%民%").andAcceptDateBetween(startDate, endDate);
    long mingS = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("民事", mingS));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andTypeLike("%刑%").andAcceptDateBetween(startDate, endDate);
    long xinS = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("刑事", xinS));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andTypeLike("%行%").andAcceptDateBetween(startDate, endDate);
    long xingZ = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("行政", xingZ));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andTypeLike("%赔%").andAcceptDateBetween(startDate, endDate);
    long peiC = courtCaseMapper.countByExample(courtCaseExample);
    judgeGradeStatistics.add(new JudgementStatistics("赔偿", peiC));

    return judgeGradeStatistics;
  }

  @Override
  public Map getJudgementSummary(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    Map result = Maps.newHashMap();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andStatusEqualTo("提档");
    long startNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("startNumber", startNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andStatusEqualTo("审理");
    result.put("oldNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateIsNotNull().andActualEndDateBetween(startDate, endDate);
    long endNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("endNumber", endNumber);

    long noneEndNumber = courtCaseMapper.countNoneEndCases(endDate);
    result.put("noneEndNumber", noneEndNumber);
    result.put("processedNumber", endNumber+noneEndNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate);
    long totalNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("totalNumber", totalNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
        .andActualEndDateBetween(startDate, endDate);
    result.put("endRate",
        new BigDecimal(endNumber)
            .divide(new BigDecimal(endNumber).add(new BigDecimal(noneEndNumber)), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andEndMethodEqualTo("判决");
    long judgeNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("judgeRate",
        new BigDecimal(judgeNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andEndMethodEqualTo("调解");
    long conciliation = courtCaseMapper.countByExample(courtCaseExample);
    result.put("conciliationRate",
        new BigDecimal(conciliation).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
        .andEndMethodIn(Arrays.asList(new String[] {"准予撤诉", "按撤诉处理"}));
    long dropNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("dropRate",
        new BigDecimal(dropNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andEndMethodEqualTo("驳回起诉");
    long rejectNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("rejectRate",
        new BigDecimal(rejectNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    result.put("startDate", sdf.format(startDate));
    result.put("endDate", sdf.format(endDate));
    return result;
  }

  @Override
  public Map getTotalJudgementSummary(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    Map result = Maps.newHashMap();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andStatusEqualTo("提档");
    long startNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("startNumber", startNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate).andStatusEqualTo("审理");
    result.put("oldNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateIsNotNull().andActualEndDateBetween(startDate, endDate);
    long endNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("endNumber", endNumber);

    long noneEndNumber = courtCaseMapper.countNoneEndCases(endDate);
    result.put("noneEndNumber", noneEndNumber);
    result.put("processedNumber", endNumber+noneEndNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate);
    long totalNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("totalNumber", totalNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
        .andActualEndDateBetween(startDate, endDate);
    result.put("endRate",
        new BigDecimal(endNumber)
            .divide(new BigDecimal(endNumber).add(new BigDecimal(noneEndNumber)), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));


    result.put("startDate", sdf.format(startDate));
    result.put("endDate", sdf.format(endDate));
    return result;
  }

  /**
   * 审判数据柱状图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  @Override
  public CaseCountBo countCase(Date startDate, Date endDate, String unit, String type) throws Exception {
    if (startDate == null || endDate == null) {
      startDate = getStartDate();
      endDate = new Date();
    }
    List<BarData> data = Lists.newArrayList();
    if ("1".equals(type) || StringUtils.isEmpty(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate);
      //data = queryCase(unit, courtCaseExample);
      data = caseReportService.queryJudgeReport(startDate, endDate, unit, type);
    } else if ("2".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate);
      //data = queryEndCase(unit, data, courtCaseExample);
      data = caseReportService.queryJudgeReport(startDate, endDate, unit, type);
    } else if ("3".equals(type)) {//未结案数，逻辑特殊
      data = caseReportService.queryJudgeReport(startDate, endDate, unit, type);
      /*Calendar calendar = Calendar.getInstance();
      calendar.setTime(startDate);
      int startYear = calendar.get(Calendar.YEAR);
      Calendar end = Calendar.getInstance();
      calendar.setTime(endDate);
      int endYear = calendar.get(Calendar.YEAR);
      boolean isCurrentYear = false;
      if (startYear == endYear) {
        isCurrentYear = true;
        endYear++;
      }
      if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
        for (int start = startYear; start < endYear; start++) {
          for (String month : months) {
            Date queryDate = sdf.parse(String.valueOf(start) + month);
            if (queryDate.getMonth() > endDate.getMonth() && isCurrentYear) {
              continue;
            }
            data.add(new BarData(String.valueOf(start).substring(2, 4) + "年" + month.substring(1, 3) + "月",
                courtCaseMapper.countNoneEndCases(queryDate), null));
          }
        }
      } else if ("quarter".equals(unit)) {
        for (int start = startYear; start < endYear; start++) {
          for (String month : quarters) {
            Date queryDate = sdf.parse(String.valueOf(start) + month);
            if (DateUtil.getSeason(queryDate) > DateUtil.getSeason(endDate) && isCurrentYear) {
              continue;
            }
            log.info("season:{},query data:{}", DateUtil.getSeason(queryDate), queryDate.toString());
            data.add(new BarData(String.valueOf(start).substring(2, 4) + "年" + DateUtil.getSeason(queryDate) + "季度",
                courtCaseMapper.countNoneEndCases(queryDate), null));
          }
        }
      } else if ("year".equals(unit)) {
        for (int start = startYear; start < endYear; start++) {
          Date queryDate = sdf.parse(String.valueOf(start) + "-12-31");
          data.add(new BarData(String.valueOf(start).substring(2, 4) + "年",
              courtCaseMapper.countNoneEndCases(queryDate), null));
        }
      }*/
    } else if ("4".equals(type)) {
      data = caseReportService.queryJudgeReport(startDate, endDate, unit, type);
      /*CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate);
      List<BarData> totalCases = queryCase(unit, courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andActualEndDateBetween(startDate, endDate);
      List<BarData> endCases = queryCase(unit, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        log.info("endNumber:{},totalNumber:{}", endCases.get(i).getNumber(), totalCases.get(i).getNumber());
        BigDecimal rate = new BigDecimal(endCases.get(i).getNumber())
            .divide(new BigDecimal(totalCases.get(i).getNumber()), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        data.add(new BarData(totalCases.get(i).getDateUnit(), rate.longValue(), rate.toString()));
      }
      List<String> accpetNumber = new ArrayList<>();
      List<String> months = new ArrayList<>();
      for (int i = 0; i < data.size(); i++) {
        months.add(data.get(i).getDateUnit());
        accpetNumber.add(data.get(i).getNumberText());
      }
      return new CaseCountBo(accpetNumber, null, months, TypeEnum.getName(Integer.parseInt(type)),
          convertToMutipleBar(startDate, endDate, unit, data));*/
    }
    List<String> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getNumberText());
    }
    return new CaseCountBo(accpetNumber, null, months, TypeEnum.getName(Integer.parseInt(type)),
        convertToMutipleBar(startDate, endDate, unit, data));
  }

  private List<BarData> queryEndCase(final String unit, List<BarData> data,
      final CourtCaseExample courtCaseExample) {
    if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
      data = courtCaseMapper
          .countEndCase(courtCaseExample);
    } else if ("quarter".equals(unit)) {
      data = courtCaseMapper
          .countQuarterEndCase(courtCaseExample);
    } else if ("year".equals(unit)) {
      data = courtCaseMapper
          .countYearEndCase(courtCaseExample);
    }
    return data;
  }

  private List<BarData> queryCase(final String unit,
      final CourtCaseExample courtCaseExample) {
    List<BarData> data = new ArrayList<>();
    if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
      data = courtCaseMapper
          .countAcceptCase(courtCaseExample);
    } else if ("quarter".equals(unit)) {
      data = courtCaseMapper
          .countQuarterAcceptCase(courtCaseExample);
    } else if ("year".equals(unit)) {
      data = courtCaseMapper
          .countYearAcceptCase(courtCaseExample);
    }
    return data;
  }

  private Date getStartDate() {
    final Date startDate;
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
    startDate = calendar.getTime();
    return startDate;
  }

  /**
   * 质效数据柱状图
   *
   * @param startDate
   * @param endDate
   * @param unit
   * @param type
   * @return
   */
  @Override
  public CaseCountBo countPerformance(Date startDate, Date endDate, String unit, String type) {
    if (startDate == null || endDate == null) {
      startDate = getStartDate();
      endDate = new Date();
    }
    List<BarData> data = Lists.newArrayList();
    if ("1".equals(type) || StringUtils.isEmpty(type)) {//平均审理天数
      /*CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate);
      if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
        data = courtCaseMapper
            .countJudgeDays(courtCaseExample);
      } else if ("quarter".equals(unit)) {
        data = courtCaseMapper
            .countQuarterJudgeDays(courtCaseExample);
      } else if ("year".equals(unit)) {
        data = courtCaseMapper
            .countYearJudgeDays(courtCaseExample);
      }*/
      data = caseReportService.queryPerformanceReport(startDate, endDate, unit, type);
    } else if ("2".equals(type)) {//执结率
      /*CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> totalCases = new ArrayList<>();
      totalCases = queryEndCase(unit, totalCases, courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andEndMethodIn(Arrays
              .asList(new String[] {"自动履行完毕", "强制执行完毕", "执行完毕"}))
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> endCases = new ArrayList<>();
      endCases = queryEndCase(unit, endCases, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        BigDecimal endNumber;
        if (i > endCases.size() - 1) {
          endNumber = new BigDecimal(0);
        } else {
          endNumber = new BigDecimal(endCases.get(i).getNumber());
        }
        BigDecimal rate = endNumber
            .divide(new BigDecimal(totalCases.get(i).getNumber()), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        data.add(new BarData(totalCases.get(i).getDateUnit(), rate.longValue(), rate.toString()));
      }*/
      data = caseReportService.queryPerformanceReport(startDate, endDate, unit, type);
    } else if ("3".equals(type)) {//法定审限内结案率 todo 无数据
      data = caseReportService.queryPerformanceReport(startDate, endDate, unit, type);
    } else if ("4".equals(type)) {//服判诉率 todo 无数据
      data = caseReportService.queryPerformanceReport(startDate, endDate, unit, type);
    }
    List<String> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      if (StringUtils.isEmpty(data.get(i).getNumberText())) {
        data.get(i).setNumberText(String.valueOf(data.get(i).getNumber()));
      }
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getNumberText());
    }
    return new CaseCountBo(accpetNumber, null, months, PerformanceTypeEnum.getName(Integer.parseInt(type))
        , convertToMutipleBar(startDate, endDate, unit, data));
  }

  /**
   * 转化普通柱状图未环比柱状图
   *
   * @param startDate
   * @param endDate
   * @param unit
   * @param data
   * @return
   */
  private List<MutipleBarBo> convertToMutipleBar(Date startDate, Date endDate, String unit,
      List<BarData> data) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    int startYear = calendar.get(Calendar.YEAR);
    Calendar end = Calendar.getInstance();
    calendar.setTime(endDate);
    int endYear = calendar.get(Calendar.YEAR);
    if (endYear - startYear <= 1) {
      return null;
    }
    Map<String, List<BarData>> monthToMonth = new LinkedHashMap<>();
    for (BarData barData : data) {
      if (StringUtils.isEmpty(barData.getNumberText())) {
        barData.setNumberText(String.valueOf(barData.getNumber()));
      }
      String month = "";
      if ("month".equals(unit) || StringUtils.isEmpty(unit)) {
        month = barData.getDateUnit().substring(3, barData.getDateUnit().indexOf("月"));
      } else if ("quarter".equals(unit)) {
        month = barData.getDateUnit().substring(3, 4);
      }
      if (monthToMonth.get(month) == null) {
        monthToMonth.put(month, new ArrayList());
      }
      monthToMonth.get(month).add(barData);
    }
    Iterator<String> iterator = monthToMonth.keySet().iterator();
    List<MutipleBarBo> mutipleBarBos = new ArrayList<>();
    while (iterator.hasNext()) {
      String key = iterator.next();
      mutipleBarBos.add(new MutipleBarBo(key, monthToMonth.get(key)));
    }
    Collections.sort(mutipleBarBos);
    return mutipleBarBos;
  }

  /**
   * 执行数据饼图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  public List<JudgementStatistics> getEnforceMethod(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndDateBetween(startDate, endDate)
        .andTypeEqualTo("执")
        .andEndMethodNotEqualTo("");
    return courtCaseMapper.countEndMethod(courtCaseExample);
  }

  /**
   * 执行数据柱状图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  @Override
  public CaseCountBo countEnforceCase(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
    List<BarData> accpectCase = caseReportService.queryEnforceReport(startDate, endDate, "registerNumber");
    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
    List<BarData> endCase = caseReportService.queryEnforceReport(startDate, endDate, "endNumber");
    List<String> accpetNumber = new ArrayList<>();
    List<Long> endNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < accpectCase.size(); i++) {
      months.add(accpectCase.get(i).getDateUnit());
      accpetNumber.add(String.valueOf(accpectCase.get(i).getNumber()));
      if (i > endCase.size() - 1) {
        endNumber.add(0l);
      } else {
        endNumber.add(endCase.get(i).getNumber());
      }
    }
    return new CaseCountBo(accpetNumber, endNumber, months, "", null);
  }

  /**
   * 执行统计数据
   *
   * @param startDate
   * @param endDate
   * @return
   */

  public Map getEnforceSummary(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    Map result = Maps.newHashMap();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
        .andActualEndDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
    Map amount = courtCaseMapper.sumEnforceAmount(courtCaseExample);

    result.put("registerAmount", amount.get("registerAmount"));
    result.put("endAmount", amount.get("endAmount"));
    result.put("actualAmount", amount.get("actualAmount"));
    result.put("abandonAmount", amount.get("abandonAmount"));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andEndMethodIn(Arrays
            .asList(new String[] {"自动履行完毕", "强制执行完毕", "执行完毕"})).andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    long endNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("endNumber", endNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    long totalNumber = courtCaseMapper.countByExample(courtCaseExample);
    BigDecimal endRate = new BigDecimal(endNumber).divide(new BigDecimal(totalNumber), 4, RoundingMode.HALF_UP)
        .setScale(4,
            BigDecimal.ROUND_HALF_UP);
    NumberFormat percent = NumberFormat.getPercentInstance();
    percent.setMaximumFractionDigits(2);
    result.put("endRate", percent.format(endRate.doubleValue()));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢", "执异", "执保"}));
    long enforeEndNumber = courtCaseMapper.countByExample(courtCaseExample);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢", "执异", "执保"}));
    long enforeNoneEndNumber = courtCaseMapper.countNoneEndCases(endDate);
    BigDecimal enforeEndRate = new BigDecimal(enforeEndNumber)
        .divide(new BigDecimal(enforeEndNumber).add(new BigDecimal(enforeNoneEndNumber)), 4, RoundingMode.HALF_UP)
        .setScale(4,
            BigDecimal.ROUND_HALF_UP);
    result.put("enforeEndRate", percent.format(enforeEndRate.doubleValue()));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    Map map = courtCaseMapper.getEnforceRate(courtCaseExample);
    result.put("actualAmountRate", map.get("actualAmountRate"));
    /*try {
      if (startDate.before(sdf.parse("2018-01-01"))) {
        result.put("actualAmountRate", map.get("actualAmountRate"));
      } else {
        result.put("actualAmountRate", "8.63");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }*/
    result.put("endAmountRate", map.get("endAmountRate"));

    result.put("startDate", sdf.format(startDate));
    result.put("endDate", sdf.format(endDate));
    return result;
  }

  /**
   * 部门数据饼图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  public List<JudgementStatistics> getDepartment(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate);
    return courtCaseMapper.countDepartment(courtCaseExample);
  }

  /**
   * 部门数据柱状图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  /*
  @Override
  public CaseCountBo countDepartmentCase(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate);
    List<BarData> accpectCase = courtCaseMapper
        .countAcceptCase(courtCaseExample);
    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndDateBetween(startDate, endDate);
    List<BarData> endCase = courtCaseMapper
        .countEndCase(courtCaseExample);
    List<Long> accpetNumber = new ArrayList<>();
    List<Long> endNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < accpectCase.size(); i++) {
      months.add(accpectCase.get(i).getDateUnit());
      accpetNumber.add(accpectCase.get(i).getNumber());
      if (i > endCase.size() - 1) {
        endNumber.add(0l);
      } else {
        endNumber.add(endCase.get(i).getNumber());
      }
    }
    return new CaseCountBo(accpetNumber, endNumber, months, "", null);
  }*/

  /**
   * 质效数据饼图
   *
   * @param startDate
   * @param endDate
   * @return
   */
  @Override
  public List<JudgementStatistics> getStatus(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      Calendar calendar = Calendar.getInstance();
      Date date = new Date(System.currentTimeMillis());
      calendar.setTime(date);
      calendar.add(Calendar.YEAR, -1);
      endDate = new Date();
      startDate = calendar.getTime();
    }
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate);
    return courtCaseMapper.countCaseStatus(courtCaseExample);
  }

  public List<CourtCase> queryCourtCase(CaseQuery caseQuery) throws Exception {

    CourtCaseExample courtCaseExample = new CourtCaseExample();
    CourtCaseExample.Criteria criteria = courtCaseExample.createCriteria();
    if (!StringUtils.isEmpty(caseQuery.getStartDate())) {
      criteria.andAcceptDateGreaterThan(sdf.parse(caseQuery.getStartDate()));
    }
    if (!StringUtils.isEmpty(caseQuery.getEndDate())) {
      criteria.andAcceptDateLessThan(sdf.parse(caseQuery.getEndDate()));
    }
    if (!StringUtils.isEmpty(caseQuery.getUser())) {
      criteria.andUndertakeUserEqualTo(caseQuery.getUser());
    }
    if (!StringUtils.isEmpty(caseQuery.getType())) {
      criteria.andTypeEqualTo(caseQuery.getType());
    }
    courtCaseExample.setLimit(caseQuery.getSize());
    courtCaseExample.setOffset(caseQuery.getPageNo() * caseQuery.getSize());
    return courtCaseMapper.selectByExample(courtCaseExample);
  }

  public Map getPerformanceSummay(Date startDate, Date endDate) {
    Map result = Maps.newHashMap();
    /*CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andCaseInvolvedEqualTo("涉枪");
    result.put("gunNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andCaseInvolvedEqualTo("涉毒");
    result.put("drugNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andProgramEqualTo("简易程序");
    result.put("simpleProgram", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andProgramEqualTo("普通程序");
    result.put("commonProgram", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andProgramEqualTo("小额诉讼程序");
    result.put("littleProgram", courtCaseMapper.countByExample(courtCaseExample));*/
    CaseReport caseReport=null;
    if (startDate == null || endDate == null) {
      caseReport=caseReportService.getYearReport(DateUtil.getYear(Calendar.getInstance().getTime()));
    }else{
      caseReport=caseReportService.getYearReport(DateUtil.getYear(startDate));
    }
    result.put("judgeDays",caseReport.getJudgeDays());
    result.put("enforceEndRate",caseReport.getEnforceEndRate());
    result.put("agreeRate",caseReport.getAgreeRate());
    result.put("limitEndRate",caseReport.getLimitEndRate());


    return result;
  }

  /**
   * 部门统计数据
   *
   * @param startDate
   * @param endDate
   * @return
   */
  public Map getDepartmentSummary(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    Map result = Maps.newHashMap();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andChiefJudgeNotEqualTo("");
    courtCaseExample.setLimit(5);
    List<BarData> cheifJudges = courtCaseMapper.countChiefJudge(courtCaseExample);
    result.put("chiefJudge1", cheifJudges.get(0));
    result.put("chiefJudge2", cheifJudges.get(1));
    result.put("chiefJudge3", cheifJudges.get(2));
    result.put("chiefJudge4", cheifJudges.get(3));
    result.put("chiefJudge5", cheifJudges.get(4));
    result.put("startDate", sdf.format(startDate));
    result.put("endDate", sdf.format(endDate));
    return result;
  }
}
