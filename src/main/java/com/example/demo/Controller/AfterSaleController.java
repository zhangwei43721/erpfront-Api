package com.example.demo.Controller;

import com.example.demo.pojo.AfterSales;
import com.example.demo.service.AfterSalesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
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

}