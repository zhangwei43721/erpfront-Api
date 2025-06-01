package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.vo.ItemCond;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_item(商品信息表)】的数据库操作Service实现
 * @createDate 2025-05-27 15:55:07
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    /* public Map<String, Object> queryItemListService(Integer pageNum, Integer pageSize) {*/
    public Map<String, Object> queryItemListService(ItemCond itemCond) {

        /*Page<Object> page = PageHelper.startPage(pageNum, pageSize);*/
        Page<Object> page = PageHelper.startPage(itemCond.getPageNum(), itemCond.getPageSize());
        //查询数据库
        /*List<Item> items = itemMapper.queryItemListMapper();*/
        List<Item> items = itemMapper.queryItemListMapper(itemCond);

        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        result.put("total", page.getTotal());
        return result;
    }
}

