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
import com.tech.court.entity.CourtCase;
import com.tech.court.entity.CourtCaseExample;
import com.tech.court.entity.CourtLive;
import com.tech.court.entity.CourtLiveExample;
import com.tech.court.service.ICourtService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourtServiceImpl implements ICourtService {

  public static final List<String> ENFORCE_TYPE = Arrays.asList(new String[] {"执", "执恢", "执保", "执异"});
  @Autowired
  private CourtLiveMapper courtLiveMapper;

  @Autowired
  private CourtCaseMapper courtCaseMapper;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andStatusEqualTo("提档");
    long startNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("startNumber", startNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andStatusEqualTo("审理");
    result.put("oldNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andStatusIn(Arrays.asList(new String[] {"结案", "归档", "中止"}));
    long endNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("endNumber", endNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andStatusIn(Arrays.asList(new String[] {"审理", "提档", "移送"}));
    result.put("noneEndNumber", courtCaseMapper.countByExample(courtCaseExample));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate);
    long totalNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("totalNumber", totalNumber);
    result.put("endRate",
        new BigDecimal(endNumber).divide(new BigDecimal(totalNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andEndMethodEqualTo("判决");
    long judgeNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("judgeRate",
        new BigDecimal(judgeNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andEndMethodEqualTo("调解");
    long conciliation = courtCaseMapper.countByExample(courtCaseExample);
    result.put("conciliationRate",
        new BigDecimal(conciliation).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andEndMethodIn(Arrays.asList(new String[] {"准予撤诉", "按撤诉处理"}));
    long dropNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("dropRate",
        new BigDecimal(dropNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate).andEndMethodEqualTo("驳回起诉");
    long rejectNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("rejectRate",
        new BigDecimal(rejectNumber).divide(new BigDecimal(endNumber), 4, RoundingMode.HALF_UP)
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
  public CaseCountBo countCase(Date startDate, Date endDate, String unit, String type) {
    if (startDate == null || endDate == null) {
      startDate = getStartDate();
      endDate = new Date();
    }
    List<BarData> data = Lists.newArrayList();
    if ("1".equals(type) || StringUtils.isEmpty(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate);
      data = queryCase(unit, courtCaseExample);
    } else if ("2".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate);
      data = queryEndCase(unit, data, courtCaseExample);
    } else if ("3".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andStatusNotIn(Arrays.asList(new String[] {"归档", "结案", "中止"}));
      data = queryCase(unit, courtCaseExample);
    } else if ("4".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate);
      List<BarData> totalCases = queryCase(unit, courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andActualEndDateBetween(startDate, endDate)
          .andStatusIn(Arrays.asList(new String[] {"归档", "结案", "中止"}));
      List<BarData> endCases = queryCase(unit, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        log.info("endNumber:{},totalNumber:{}", endCases.get(i).getNumber(), totalCases.get(i).getNumber());
        Long rate = new BigDecimal(endCases.get(i).getNumber())
            .divide(new BigDecimal(totalCases.get(i).getNumber()), 2, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).longValue();
        data.add(new BarData(totalCases.get(i).getDateUnit(), rate));
      }
    }
    List<Long> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getNumber());
    }
    return new CaseCountBo(accpetNumber, null, months, TypeEnum.getName(Integer.parseInt(type)));
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
      CourtCaseExample courtCaseExample = new CourtCaseExample();
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
      }
    } else if ("2".equals(type)) {//执结率
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> totalCases = queryCase(unit, courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andEndMethodIn(Arrays
              .asList(new String[] {"驳回申请", "强制执行完毕", "销案", "执行完毕"}))
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> endCases = queryCase(unit, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        BigDecimal endNumber;
        if (i > endCases.size() - 1) {
          endNumber = new BigDecimal(0);
        } else {
          endNumber = new BigDecimal(endCases.get(i).getNumber());
        }
        Long rate = endNumber
            .divide(new BigDecimal(totalCases.get(i).getNumber()), 2, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100)).longValue();
        data.add(new BarData(totalCases.get(i).getDateUnit(), rate));
      }
    } else if ("3".equals(type)) {//法定审限内结案率 todo 无数据
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> totalCases = queryCase(unit, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        long num = 90 + (int) (Math.random() * 10);
        data.add(new BarData(totalCases.get(i).getDateUnit(), num)); //mock data
      }
    } else if ("4".equals(type)) {//服判诉率 todo 无数据
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> totalCases = queryCase(unit, courtCaseExample);
      for (int i = 0; i < totalCases.size(); i++) {
        long num = 70 + (int) (Math.random() * 20);
        data.add(new BarData(totalCases.get(i).getDateUnit(), num)); //mock data
      }
    }
    List<Long> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getNumber());
    }
    return new CaseCountBo(accpetNumber, null, months, PerformanceTypeEnum.getName(Integer.parseInt(type)));
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
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
    List<BarData> accpectCase = courtCaseMapper
        .countAcceptCase(courtCaseExample);
    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andEndDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
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
    return new CaseCountBo(accpetNumber, endNumber, months, "");
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
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andTypeIn(ENFORCE_TYPE);
    Map amount = courtCaseMapper.sumEnforceAmount(courtCaseExample);

    result.put("registerAmount", amount.get("registerAmount"));
    result.put("endAmount", amount.get("endAmount"));
    result.put("actualAmount", amount.get("actualAmount"));
    result.put("abandonAmount", amount.get("abandonAmount"));

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andEndMethodIn(Arrays
            .asList(new String[] {"驳回申请", "强制执行完毕", "销案", "执行完毕"})).andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    long endNumber = courtCaseMapper.countByExample(courtCaseExample);
    result.put("endNumber", endNumber);

    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    long totalNumber = courtCaseMapper.countByExample(courtCaseExample);
    BigDecimal endRate = new BigDecimal(endNumber).divide(new BigDecimal(totalNumber), 4, RoundingMode.HALF_UP)
        .setScale(4,
            BigDecimal.ROUND_HALF_UP);
    NumberFormat percent = NumberFormat.getPercentInstance();
    percent.setMaximumFractionDigits(2);
    result.put("endRate", percent.format(endRate.doubleValue()));
    courtCaseExample = new CourtCaseExample();
    courtCaseExample.createCriteria().andAcceptDateBetween(startDate, endDate)
        .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
    Map map = courtCaseMapper.getEnforceRate(courtCaseExample);
    try {
      if (startDate.before(sdf.parse("2018-01-01"))) {
        result.put("actualAmountRate", map.get("actualAmountRate"));
      } else {
        result.put("actualAmountRate", "8.63");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
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
    return new CaseCountBo(accpetNumber, endNumber, months, "");
  }

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
    if (startDate == null || endDate == null) {
      endDate = new Date();
      startDate = getStartDate();
    }
    Map result = Maps.newHashMap();
    CourtCaseExample courtCaseExample = new CourtCaseExample();
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
    result.put("littleProgram", courtCaseMapper.countByExample(courtCaseExample));

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
