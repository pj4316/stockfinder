package com.maxlee.stockfinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping("getStockInfoOfDate")
    public String getStockInfoOfDate(@RequestParam("stockItem") String stockItem) {
        // TODO : naver finance api를 통한 특정 회사의 일별 주가 데이터 얻어오기
        // hello world
        return stockItem;
    }
}
