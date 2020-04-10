package com.maxlee.stockfinder.domain;

import java.time.LocalDate;

public class StockInfo extends DomainEntity {
  private String isin; // 표준 코드
  private String name; // 국문 종목명
  private LocalDate issuedAt; // 상장일자
  private LocalDate deletedAt; // 상장폐지일자
  private Integer listTpCode; // 상장구분코드
  private LocalDate expiredAt; // 만료일자

  public StockInfo(
      String isin,
      String name,
      LocalDate issuedAt,
      LocalDate deletedAt,
      Integer listTpCode,
      LocalDate expiredAt) {
    this.isin = isin;
    this.name = name;
    this.issuedAt = issuedAt;
    this.deletedAt = deletedAt;
    this.listTpCode = listTpCode;
    this.expiredAt = expiredAt;
  }

  @Override
  public String toString() {
    return "StockInfo: isin="+isin +", name=" + name + ", issuedAt=" + issuedAt;
  }
}
