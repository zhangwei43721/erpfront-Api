package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.BuyList;

import java.util.List;

/**
* @author skyforever
* @description 针对表【buy_list(采购单表，记录商品采购信息)】的数据库操作Mapper
* @createDate 2025-05-29 11:53:57
* @Entity com.example.demo.pojo.BuyList
*/
public interface BuyListMapper extends BaseMapper<BuyList> {

    /*实现采购单列表分页查询*/
    List<BuyList> queryBuyListMapper();
}




