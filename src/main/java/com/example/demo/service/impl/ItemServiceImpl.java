package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author skyforever
* @description 针对表【t_item(商品信息表)】的数据库操作Service实现
* @createDate 2025-05-27 15:55:07
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
    
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemListService(Integer pageNum, Integer pageSize) {
        Page<Item> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        Page<Item> resultPage = itemMapper.selectPage(page, wrapper);
        
        return resultPage.getRecords();
    }
}

