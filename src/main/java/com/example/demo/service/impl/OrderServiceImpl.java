package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.SellResult;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     @Override
    public List<Map<String, Object>> querySellYearService() {
        List<Integer> integerList = orderMapper.querySellYearMapper();
        List<Map<String, Object>> list=new ArrayList<>();
        for(Integer year:integerList){
            Map<String, Object> result=new HashMap<>();
            result.put("year",year);
            result.put("label",year+"年");
            list.add(result);
        }
        return list;
    }

      @Override
    public Map<String, Object> queryYearMonthService(String year) {
        List<SellResult> sellResults = orderMapper.countSellMonthMapper(year);
        Map<String, Object> result=new HashMap<>();
        //创建封装月份数据集合
        List<String> mths=new ArrayList<>();
        //封装月份销售额数据集合
        List<Double> mnys=new ArrayList<>();
        for(int m=1;m<=12;m++){
            mths.add(m+"月");
            mnys.add(0.0);
        }
        for(SellResult sr:sellResults){
            System.out.println("sr====="+sr);
           if(sr!=null){
               System.out.println(sr.getMth()-1+"------"+sr.getMny());
               Integer mth = sr.getMth();
               mnys.set(mth-1,sr.getMny()); //如果某个月份存在数据，覆盖默认值0.0
           }

        }
        result.put("xdata",mths);
        result.put("ydata",mnys);
        return result;
    }
}




