package com.example.demo.Controller;

import com.example.demo.pojo.AfterSales;
import com.example.demo.service.AfterSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class AfterSaleController {

    @Autowired
    private AfterSalesService afterSalesService;

    /*处理投诉信息分页查询请求*/
    @PostMapping("/listAfterSale")
    public Map<String,Object> listAfterSales(@RequestBody AfterSales afterSales){
        return afterSalesService.queryAfterSaleListService(afterSales);
    }

}