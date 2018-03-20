package com.tech.court.domain;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaseCountBo {
  private List<String> accpetNumber;

  private List<Long> endNumber;

  private List<String> months;

  private String type;

  private List<MutipleBarBo> mutipleBar;
}
