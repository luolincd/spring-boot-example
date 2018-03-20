package com.tech.court.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MutipleBarBo implements Comparable<MutipleBarBo> {
  private String columLabel;

  private List<BarData> barData;

  @Override
  public int compareTo(MutipleBarBo mutipleBarBo) {
    int month;
    if (this.columLabel.startsWith("0")) {
      month = Integer.parseInt(this.columLabel.substring(1, 2));
    } else {
      month = Integer.parseInt(this.columLabel);
    }
    int month2;
    if (mutipleBarBo.getColumLabel().startsWith("0")) {
      month2 = Integer.parseInt(mutipleBarBo.getColumLabel().substring(1, 2));
    } else {
      month2 = Integer.parseInt(mutipleBarBo.getColumLabel());
    }
    if (month > month2) {
      return 1;
    }
    return -1;
  }
}
