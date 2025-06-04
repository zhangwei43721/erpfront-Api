package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dto.CountResult;
import com.example.demo.pojo.Customer;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_customer(客户表)】的数据库操作Mapper
 * @createDate 2025-05-13 10:05:12
 * @Entity com.example.demo.pojo.Customer
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /*实现客户地区分布统计*/
    List<CountResult> countCustomerAreaMapper();
}




