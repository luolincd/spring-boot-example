package com.tech.court.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.tech.court.config.PerformanceTypeEnum;
import com.tech.court.config.TypeEnum;
import com.tech.court.dao.primary.CourtCaseMapper;
import com.tech.court.dao.primary.JudgeStatisticsMapper;
import com.tech.court.dao.primary.UserMapper;
import com.tech.court.domain.BarData;
import com.tech.court.domain.JudgementStatistics;
import com.tech.court.domain.RateBarBo;
import com.tech.court.domain.RateBo;
import com.tech.court.entity.CourtCaseExample;
import com.tech.court.entity.JudgeStatistics;
import com.tech.court.entity.JudgeStatisticsExample;
import com.tech.court.entity.User;
import com.tech.court.entity.UserExample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private CourtCaseMapper courtCaseMapper;

  @Autowired
  private JudgeStatisticsMapper judgeStatisticsMapper;

  String[] judges = {"白勇", "毕军", "曾巍", "冯毅", "何鲲", "何立标", "何晓萍", "李陈", "李冠臣", "李俊", "林兵", "刘高举", "刘杰", "刘绍松", "罗彪",
      "马伯良", "任帅", "宋金全", "宋兴", "唐伟民", "唐晓岚",
      "王映", "向建新", "胥勋成", "徐堂富", "杨清明", "姚亮", "袁华林", "袁小艳", "翟苓君", "张丽娟", "张扬", "赵锋", "赵晓娟", "赵晓银", "赵燕君", "赵勇"};

  String[] judges_18 = {"白勇", "曾巍", "冯毅", "何鲲", "何立标", "何晓萍", "李陈", "李冠臣", "李俊", "林兵", "刘高举", "刘杰", "刘绍松", "罗彪",
      "马伯良", "任帅", "宋金全", "宋兴", "唐伟民", "唐晓岚",
      "王映", "向建新", "胥勋成", "徐堂富", "杨清明", "姚亮", "袁华林", "袁小艳", "翟苓君", "张丽娟", "张扬", "赵锋", "赵晓娟", "赵晓银", "赵燕君", "赵勇"};

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 新增用户
   *
   * @param user 用户信息
   * @return
   */
  public String insert(User user) {
    int resultInt = userMapper.insert(user);
    JSONObject result = new JSONObject();
    if (resultInt > 0) {
      result.put("success", true);
      result.put("msg", "成功");
    } else {
      result.put("success", false);
      result.put("msg", "失败");
    }
    return result.toJSONString();
  }

  public List<JudgementStatistics> countEducation() {
    UserExample example = new UserExample();
    example.createCriteria().andStatusEqualTo(true);
    return userMapper.countEducation(example);
  }

  private List<String> getChiefJudgeNames() {
    UserExample example = new UserExample();
    example.createCriteria().andStatusEqualTo(true).andJudgeGradeLike("%法官%");
    List<User> users = userMapper.selectByExample(example);
    List<String> names = new ArrayList<>();
    users.stream().forEach(user -> {
      //log.info("chiefjudge:{}", user.getName());
      names.add(user.getName());
    });
    return names;
  }

  /**
   * 员额法官柱状图
   *
   * @param startDate
   * @param endDate
   * @param type
   * @return
   */
  public RateBarBo countChiefjudge(Date startDate, Date endDate, String type) throws Exception {
    if (startDate == null || endDate == null) {
      startDate = getStartDate();
      endDate = new Date();
    }
    List<BarData> data = Lists.newArrayList();
    if ("1".equals(type) || StringUtils.isEmpty(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)));
      data = courtCaseMapper.countChiefJudge(courtCaseExample);
    } else if ("2".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)));
      data = courtCaseMapper.countChiefJudge(courtCaseExample);
    } else if ("3".equals(type)) {
      data = courtCaseMapper.countJudgeNoneEndCases(endDate);
    } else if ("4".equals(type)) {
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)));
      List<BarData> totalCases = courtCaseMapper.countChiefJudge(courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andRegisterDateBetween(startDate, endDate)
          .andActualEndDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)));
      List<BarData> endCases = courtCaseMapper.countChiefJudge(courtCaseExample);
      Map<String, Long> endCaseMap = endCases.stream()
          .collect(Collectors.toMap(BarData::getDateUnit, BarData::getNumber));
      List<RateBo> rateBos = new ArrayList<>();
      for (int i = 0; i < totalCases.size(); i++) {
        BigDecimal endNumber = new BigDecimal(0);
        if (endCaseMap.get(totalCases.get(i).getDateUnit()) != null) {
          endNumber = new BigDecimal(endCaseMap.get(totalCases.get(i).getDateUnit()));
        }
        BigDecimal rate = endNumber.divide(new BigDecimal(totalCases.get(i).getNumber()), 4, RoundingMode.HALF_UP)
            .setScale(4,
                BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        rateBos.add(new RateBo(totalCases.get(i).getDateUnit(), rate));
        Collections.sort(rateBos);
      }
      List<String> rates = new ArrayList<>();
      List<String> months = new ArrayList<>();
      rateBos.forEach(rateBo -> {
        rates.add(rateBo.getNumber().toString());
        months.add(rateBo.getDateUnit());
      });
      return new RateBarBo(rates, months, TypeEnum.getName(Integer.parseInt(type)));
    }
    List<String> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getNumber().toString());
    }
    return new RateBarBo(accpetNumber, months, TypeEnum.getName(Integer.parseInt(type)));
  }

  private Date getStartDate() {
    final Date startDate;
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
    startDate = calendar.getTime();
    return startDate;
  }

  /**
   * 员额质效柱状图
   *
   * @param startDate
   * @param endDate
   * @param type
   * @return
   */
  public RateBarBo countPerformance(Date startDate, Date endDate, String type) throws Exception {
    if (startDate == null || endDate == null) {
      startDate = getStartDate();
      endDate = new Date();
    }
    List<BarData> data = Lists.newArrayList();
    List<String> names = getChiefJudgeNames();
    if ("1".equals(type) || StringUtils.isEmpty(type)) {//平均审理天数
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)));
      data = courtCaseMapper.countJudgeDaysByUndertakeUser(courtCaseExample);
    } else if ("2".equals(type)) {//执结率
      CourtCaseExample courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate))).andTypeIn(Arrays.asList(new String[] {"执", "执恢"}));
      List<BarData> totalCases = courtCaseMapper.countChiefJudge(courtCaseExample);
      courtCaseExample = new CourtCaseExample();
      courtCaseExample.createCriteria().andActualEndDateBetween(startDate, endDate)
          .andUndertakeUserIn(Arrays.asList(getJudeges(startDate)))
          .andTypeIn(Arrays.asList(new String[] {"执", "执恢"}))
          .andEndMethodIn(Arrays
              .asList(new String[] {"驳回申请", "强制执行完毕", "销案", "执行完毕"}));
      List<BarData> endCases = courtCaseMapper.countChiefJudge(courtCaseExample);
      Map<String, Long> endCaseMap = endCases.stream()
          .collect(Collectors.toMap(BarData::getDateUnit, BarData::getNumber));
      List<RateBo> rateBos = new ArrayList<>();
      for (int i = 0; i < totalCases.size(); i++) {
        BigDecimal endNumber = new BigDecimal(0);
        if (endCaseMap.get(totalCases.get(i).getDateUnit()) != null) {
          endNumber = new BigDecimal(endCaseMap.get(totalCases.get(i).getDateUnit()));
        }
        BigDecimal rate = endNumber.divide(new BigDecimal(totalCases.get(i).getNumber()), 4, RoundingMode.HALF_UP)
            .setScale(4,
                BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        rateBos.add(new RateBo(totalCases.get(i).getDateUnit(), rate));
        Collections.sort(rateBos);
      }
      List<String> rates = new ArrayList<>();
      List<String> months = new ArrayList<>();
      rateBos.forEach(rateBo -> {
        rates.add(rateBo.getNumber().toString());
        months.add(rateBo.getDateUnit());
      });
      return new RateBarBo(rates, months, PerformanceTypeEnum.getName(Integer.parseInt(type)));
    } else if ("3".equals(type)) {//法定审限内结案率 todo 无数据
      return getEndRateBar(startDate, endDate, type);
    } else if ("4".equals(type)) {//服判诉率 todo 无数据
      return getAgreeRateBar(startDate, endDate, type);
    }
    List<String> accpetNumber = new ArrayList<>();
    List<String> months = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      months.add(data.get(i).getDateUnit());
      accpetNumber.add(data.get(i).getDecimalNumber().setScale(2, RoundingMode.HALF_UP).toString());
    }
    return new RateBarBo(accpetNumber, months, PerformanceTypeEnum.getName(Integer.parseInt(type)));
  }

  public RateBarBo getEndRateBar(Date startDate, Date endDate, String type) {
    JudgeStatisticsExample judgeStatisticsExample = new JudgeStatisticsExample();
    judgeStatisticsExample.createCriteria().andNameNotEqualTo("全院");
    judgeStatisticsExample.setOrderByClause("end_rate desc");
    List<JudgeStatistics> judgementStatistics = judgeStatisticsMapper.selectByExample(judgeStatisticsExample);
    List<String> rate = new ArrayList<>();
    List<String> months = new ArrayList<>();
    judgementStatistics.forEach(judgeStatistics -> {
      rate.add(judgeStatistics.getEndRate().toString());
      months.add(judgeStatistics.getName());
    });
    return new RateBarBo(rate, months, PerformanceTypeEnum.getName(Integer.parseInt(type)));
  }

  public RateBarBo getAgreeRateBar(Date startDate, Date endDate, String type) {
    JudgeStatisticsExample judgeStatisticsExample = new JudgeStatisticsExample();
    judgeStatisticsExample.createCriteria().andNameNotEqualTo("全院");
    judgeStatisticsExample.setOrderByClause("agree_rate desc");
    List<JudgeStatistics> judgementStatistics = judgeStatisticsMapper.selectByExample(judgeStatisticsExample);
    List<String> rate = new ArrayList<>();
    List<String> months = new ArrayList<>();
    judgementStatistics.forEach(judgeStatistics -> {
      rate.add(judgeStatistics.getAgreeRate().toString());
      months.add(judgeStatistics.getName());
    });
    return new RateBarBo(rate, months, PerformanceTypeEnum.getName(Integer.parseInt(type)));
  }

  private String[] getJudeges(Date startDate) throws Exception {
    if (startDate.before(sdf.parse("2018-01-01"))) {
      return judges;
    } else {
      return judges_18;
    }
  }
}
