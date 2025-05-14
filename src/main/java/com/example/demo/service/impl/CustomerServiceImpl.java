package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_customer(客户表)】的数据库操作Service实现
* @createDate 2025-05-13 10:05:12
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    // 注入CustomerMapper
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        // 初始化分页对象
        Page page = new Page<>(pageNum, pageSize);
        System.out.println(page.getTotal());
        List list = customerMapper.selectList(page, null);
        System.out.println(page.getTotal());

        result.put("custlist", list);
        result.put("total", page.getTotal());
        return result;
    }
}




