package com.example.demo.service;

import com.example.demo.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_customer(客户表)】的数据库操作Service
* @createDate 2025-05-13 10:05:12
*/
public interface CustomerService extends IService<Customer> {
    /**
     * 查询客户列表，并支持分页
     *
     * @param pageNum  当前页码
     * @param pageSize 每页显示数量
     * @return 包含客户列表和总数的结果Map
     */
    Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize);

    /*查询所有客户Id和姓名*/
    public List<Customer> queryCustIdNameListService();
}
