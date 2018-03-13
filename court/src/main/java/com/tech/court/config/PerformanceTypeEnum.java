package com.tech.court.config;

public enum PerformanceTypeEnum {
  ACCEPT(1, "平均审理天数"),
  END(2, "实际执结率"),
  NOTEND(3, "法定审执限内结案率"),
  ENDRATE(4, "服判息诉率");

  private final int type;
  private final String name;

  PerformanceTypeEnum(final int type, final String name) {
    this.type = type;
    this.name = name;
  }

  public static String getName(final int type) {
    for (final PerformanceTypeEnum typeEnum : PerformanceTypeEnum.values()) {
      if (typeEnum.type == type) {
        return typeEnum.name;
      }
    }
    return "";
  }

}
