package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Order;

import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_order(订单表)】的数据库操作Service
 * @createDate 2025-05-13 10:05:12
 */
public interface OrderService extends IService<Order> {

    /*处理订单数据动态多条件分页查询*/
    Map<String, Object> queryOrderListService(Order order);

}
