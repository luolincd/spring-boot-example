package com.tech.court.config;

public enum TypeEnum {
  ACCEPT(1, "收案数"),
  END(2, "结案数"),
  NOTEND(3, "未结案数"),
  ENDRATE(4, "结案率");

  private final int type;
  private final String name;

  TypeEnum(final int type, final String name) {
    this.type = type;
    this.name = name;
  }

  public static String getName(final int type) {
    for (final TypeEnum typeEnum : TypeEnum.values()) {
      if (typeEnum.type == type) {
        return typeEnum.name;
      }
    }
    return "";
  }

}
