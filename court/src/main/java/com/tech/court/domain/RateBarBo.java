package com.tech.court.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateBarBo {
  private List<String> accpetNumber;

  private List<String> months;

  private String type;
}
