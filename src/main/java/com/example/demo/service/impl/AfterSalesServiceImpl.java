package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.AfterSalesMapper;
import com.example.demo.pojo.AfterSales;
import com.example.demo.service.AfterSalesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author skyforever
 * @description 针对表【t_after_sales(售后服务表)】的数据库操作Service实现
 * @createDate 2025-05-13 10:05:12
 */
@Service
public class AfterSalesServiceImpl extends ServiceImpl<AfterSalesMapper, AfterSales>
        implements AfterSalesService {
    private final AfterSalesMapper afterSalesMapper;

    public AfterSalesServiceImpl(AfterSalesMapper afterSalesMapper) {
        this.afterSalesMapper = afterSalesMapper;
    }

    @Override
    public Map<String, Object> queryAfterSaleListService(AfterSales afterSales) {
        //指定分页查询参数
        Page<Object> page = PageHelper.startPage(afterSales.getPageNum(), afterSales.getPageSize());
        //查询数据库
        List<AfterSales> afterSalesList = afterSalesMapper.queryAfterSaleMapper(afterSales);

        Map<String, Object> result = new HashMap<>();
        result.put("afterSalesList", afterSalesList);
        result.put("total", page.getTotal());
        return result;
    }

}




