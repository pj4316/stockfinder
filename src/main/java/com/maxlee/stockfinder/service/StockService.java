package com.maxlee.stockfinder.service;

import com.maxlee.stockfinder.domain.IsinCode;
import com.maxlee.stockfinder.domain.StockInfo;
import com.maxlee.stockfinder.infrastructure.StockFinderOpenApi;
import org.springframework.stereotype.Service;

@Service
public class StockService {
  public StockInfo getStockInfo(IsinCode isinCode) {
    StockFinder stockFinder = new StockFinderOpenApi();
    return stockFinder.getStockInfo(isinCode);
  }
}
