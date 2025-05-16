package com.example.demo.Controller;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;


    /*处理分页查询请求*/
    @GetMapping("/listOrder")
    public Map<String,Object> listOrders(@RequestParam(defaultValue = "1")Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return orderService.queryOrderListService(pageNum,pageSize);
    }
}