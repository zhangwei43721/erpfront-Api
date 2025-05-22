package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.AfterSales;

import java.util.List;

/**
* @author skyforever
* @description 针对表【t_after_sales(售后服务表)】的数据库操作Mapper
* @createDate 2025-05-13 10:05:12
* @Entity com.example.demo.pojo.AfterSales
*/
public interface AfterSalesMapper extends BaseMapper<AfterSales> {

    /*实现售后数据多条件分页查询*/
    List<AfterSales> queryAfterSaleMapper(AfterSales afterSales);
}




