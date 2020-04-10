package com.maxlee.stockfinder.infrastructure.model;

import com.maxlee.stockfinder.domain.StockInfo;

import java.time.LocalDate;

public class GetStockInfoRes {
  private String resultCode; // 결과 코드
  private String resultMsg; // 결과 메세지
  private Integer numOfRows; // 한 페이지 결과 수
  private Integer pageNo; // 페이지 번호
  private Integer totalCount; // 전체 결과 수
  private String apliDt; // 상장일자
  private String dlistDt; // 상장폐지일자
  private String isin; // 표준 코드
  private String korSecnNm; // 국문 종목명
  private Integer listTpcd; // 상장구분코드
  private String xpitDt; // 만료일자

  public StockInfo getStockInfo() {
    return new StockInfo(
        isin,
        korSecnNm,
        apliDt == null ? null : LocalDate.parse(apliDt),
        dlistDt == null ? null : LocalDate.parse(dlistDt),
        listTpcd,
        xpitDt == null ? null : LocalDate.parse(xpitDt));
  }
}
