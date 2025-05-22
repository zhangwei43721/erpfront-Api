package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.AfterSales;

import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_after_sales(售后服务表)】的数据库操作Service
 * @createDate 2025-05-13 10:05:12
 */
public interface AfterSalesService extends IService<AfterSales> {
    /*实现客户投诉信息分页查询*/
    Map<String, Object> queryAfterSaleListService(AfterSales afterSales);


}
