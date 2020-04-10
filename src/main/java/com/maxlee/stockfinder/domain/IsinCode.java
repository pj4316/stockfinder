package com.maxlee.stockfinder.domain;

public class IsinCode {
  private String code; // 삼성전자 KR4111Q70000

  public IsinCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
