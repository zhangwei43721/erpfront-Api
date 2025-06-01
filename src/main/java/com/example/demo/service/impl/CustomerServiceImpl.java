package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.HisData;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final CustomerMapper customerMapper;

    private final OrderMapper orderMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper, OrderMapper orderMapper) {
        this.customerMapper = customerMapper;
        this.orderMapper = orderMapper;
    }

    @Transactional
    @Override
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("==================");

        // 将客户历史消费信息更新到客户信息表
        List<HisData> hisDatas = orderMapper.queryCountHisDataMapper();
        for (HisData hisData : hisDatas) {
            Customer cust = new Customer();
            cust.setId(Math.toIntExact(hisData.getCustId()));
            cust.setHisTotal(hisData.getHisTotal());
            customerMapper.updateById(cust);
        }

        // 创建封装分页查询参数的 Page 对象
        Page page = new Page(pageNum, pageSize);
        System.out.println(page.getTotal());
        List list = customerMapper.selectList(page, null);
        System.out.println(page.getTotal());

        result.put("custlist", list);
        result.put("total", page.getTotal());
        return result;
    }

    @Override
    public List<Customer> queryCustIdNameListService() {
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        //指定列的投影，指定select id,cust_name
        wrapper.select("id", "cust_name");
        return customerMapper.selectList(wrapper);
    }
}




