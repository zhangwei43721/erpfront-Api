package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.SellJh;

import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_sell_jh(销售计划表)】的数据库操作Service
* @createDate 2025-05-13 10:05:12
*/
public interface SellJhService extends IService<SellJh> {

    /*定义分页查询方法*/
    public Map<String,Object> querySellJhListService(Integer pageNum, Integer pageSize);

}
