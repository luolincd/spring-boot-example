package com.tech.court.domain;

import lombok.Data;

@Data
public class CaseQuery {
  private String startDate;

  private String endDate;

  private String type;

  private String user;

  private Integer pageNo;

  private Integer size;
}
