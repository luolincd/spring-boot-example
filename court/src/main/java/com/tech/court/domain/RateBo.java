package com.tech.court.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateBo implements Comparable<RateBo> {
  private String dateUnit;

  private BigDecimal number;

  @Override
  public int compareTo(RateBo rateBo) {
    return rateBo.getNumber().multiply(new BigDecimal(100)).subtract(this.getNumber().multiply(new BigDecimal(100))).intValue();
  }
}
