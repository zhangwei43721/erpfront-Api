package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Item;
import com.example.demo.vo.ItemCond;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_item(商品信息表)】的数据库操作Mapper
 * @createDate 2025-05-27 15:55:07
 * @Entity com.example.demo.pojo.Item
 */
public interface ItemMapper extends BaseMapper<Item> {

    /*实现商品信息分页查询*/
    List<Item> queryItemListMapper(ItemCond itemCond);
}




