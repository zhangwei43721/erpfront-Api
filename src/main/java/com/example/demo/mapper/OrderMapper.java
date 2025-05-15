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

    List<HisData> queryCountHisDataMapper();
}




