package com.tech.court.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourtLiveBo {
  private String courtRoomName;

  private String liveUrl;

  private String caseName;
}
