package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_order(订单表)】的数据库操作Service实现
 * @createDate 2025-05-13 10:05:12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Map<String, Object> queryOrderListService(Order order) {

        //指定分页参数
        Page<Object> page = PageHelper.startPage(order.getPageNum(), order.getPageSize());
        //查询数据库
        List<Order> orderList = orderMapper.queryOrderListMapper(order);

        Map<String, Object> result = new HashMap<>();
        result.put("orderList", orderList);
        result.put("total", page.getTotal());

        return result;
    }
}




