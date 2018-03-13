package com.tech.court.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaseCountBo {
  private List<Long> accpetNumber;

  private List<Long> endNumber;

  private List<String> months;

  private String type;
}
