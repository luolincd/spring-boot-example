package com.tech.court.domain;

import lombok.Data;

@Data
public class StatisticsQuery {

  private String startDate;

  private String endDate;

  //统计类型
  private String type;

  //统计单位
  private String unit;
}
