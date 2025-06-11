package com.example.demo.controller;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.AfterSales;
import com.example.demo.service.AfterSalesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AfterSaleController {

    private final AfterSalesService afterSalesService;

    public AfterSaleController(AfterSalesService afterSalesService) {
        this.afterSalesService = afterSalesService;
    }

    /*处理投诉信息分页查询请求*/
    @PostMapping("/listAfterSale")
    public Map<String, Object> listAfterSales(@RequestBody AfterSales afterSales) {
        return afterSalesService.queryAfterSaleListService(afterSales);
    }

    /*处理投诉问题类型统计请求*/
    @GetMapping("/countQuestionType")
    public List<CountResult> countQuestionType() {
        return afterSalesService.countQuestionTypeService();
    }

    /*处理投诉问题按照处理状态进行统计的请求*/
    @GetMapping("/countQuestionState")
    public List<CountResult> countQuestionState() {
        return afterSalesService.countQuestionStateService();
    }
}