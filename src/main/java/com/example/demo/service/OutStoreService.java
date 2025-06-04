package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.OutStore;

import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_out_store(出库单)】的数据库操作Service
* @createDate 2025-06-03 11:52:56
*/
public interface OutStoreService extends IService<OutStore> {

    /*实现商品出库*/
    boolean saveOutStoreService(OutStore outStore);

    /*实现入库单列表分页查询*/
    Map<String,Object> queryOutStoreListMapper(Integer pageNum, Integer pageSize);
}
