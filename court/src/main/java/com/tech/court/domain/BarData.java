package com.tech.court.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarData {
  private String dateUnit;

  private Long number;

  private String numberText;

  public BarData(String dateUnit, Long number) {
    this.dateUnit = dateUnit;
    this.number = number;
  }
}
