package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dto.HisData;
import com.example.demo.pojo.Order;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_order(订单表)】的数据库操作Mapper
 * @createDate 2025-05-13 10:05:12
 * @Entity com.example.demo.pojo.Order
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 查询订单数量历史数据,方便对每个客户的消费金额进行统计
     *
     * @return List<HisData>
     */
    List<HisData> queryCountHisDataMapper();

    /*实现订单数据动态多条件分页查询
     * order:封装动态where条件
     * */
    List<Order> queryOrderListMapper(Order order);
}




