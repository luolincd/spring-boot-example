package com.tech.court.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarData {
  private String dateUnit;

  private Long number;

  private String numberText;

  private BigDecimal decimalNumber;

  public BarData(String dateUnit, Long number) {
    this.dateUnit = dateUnit;
    this.number = number;
  }

  public BarData(String dateUnit, String numberText) {
    this.dateUnit = dateUnit;
    this.numberText = numberText;
  }

  public BarData(String dateUnit, BigDecimal decimalNumber) {
    this.dateUnit = dateUnit;
    this.decimalNumber = decimalNumber;
  }

  public BarData(String dateUnit, Long number, String numberText) {
    this.dateUnit = dateUnit;
    this.number = number;
    this.numberText = numberText;
  }
}
