package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import org.springframework.stereotype.Service;

/**
 * @author skyforever
 * @description 针对表【t_item(商品表)】的数据库操作Service实现
 * @createDate 2025-05-13 10:05:12
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
        implements ItemService {

}




