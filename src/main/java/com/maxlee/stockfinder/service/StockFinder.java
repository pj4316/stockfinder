package com.maxlee.stockfinder.service;

import com.maxlee.stockfinder.domain.IsinCode;
import com.maxlee.stockfinder.domain.StockInfo;

public interface StockFinder {
  StockInfo getStockInfo(IsinCode code);
}
