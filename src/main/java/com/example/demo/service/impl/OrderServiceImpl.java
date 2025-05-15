package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author skyforever
* @description 针对表【t_order(订单表)】的数据库操作Service实现
* @createDate 2025-05-13 10:05:12
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




