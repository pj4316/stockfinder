package com.maxlee.stockfinder.infrastructure.model;

public class GetStockInfoReq {
  private String serviceKey;
  private Integer pageNo;
  private Integer numOfRows;
  private String isin;

  public GetStockInfoReq(String serviceKey, Integer pageNo, Integer numOfRows, String isin) {
    this.serviceKey = serviceKey;
    this.pageNo = pageNo;
    this.numOfRows = numOfRows;
    this.isin = isin;
  }
}
