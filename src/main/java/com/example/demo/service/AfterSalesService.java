package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.CountResult;
import com.example.demo.pojo.AfterSales;

import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_after_sales(售后服务表)】的数据库操作Service
 * @createDate 2025-05-13 10:05:12
 */
public interface AfterSalesService extends IService<AfterSales> {
    /*实现客户投诉信息分页查询*/
    Map<String, Object> queryAfterSaleListService(AfterSales afterSales);

    /*实现投诉按照类型统计*/
    List<CountResult> countQuestionTypeService();

    /*实现投诉按照处理状态统计*/
    List<CountResult> countQuestionStateService();

}
