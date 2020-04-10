package com.maxlee.stockfinder.controller;

import com.maxlee.stockfinder.domain.IsinCode;
import com.maxlee.stockfinder.domain.StockInfo;
import com.maxlee.stockfinder.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping("getStockInfo")
    public StockInfo getStockInfo(@RequestParam("isin") String isin) {
        // TODO : naver finance api를 통한 특정 회사의 일별 주가 데이터 얻어오기
        return stockService.getStockInfo(new IsinCode(isin));
    }
}
