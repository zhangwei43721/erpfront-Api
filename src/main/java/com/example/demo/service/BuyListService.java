package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.BuyList;

import java.util.Map;

/**
* @author skyforever
* @description 针对表【buy_list(采购单表，记录商品采购信息)】的数据库操作Service
* @createDate 2025-05-29 11:53:57
*/
public interface BuyListService extends IService<BuyList> {
    /*处理采购单需要自动带入的数据*/
    Map<String,Object> queryAutoDataBuyService(Integer id);

    /*实现采购单分页查询*/
    Map<String,Object> queryBuyListService(Integer pageNum,Integer pageSize);
}
