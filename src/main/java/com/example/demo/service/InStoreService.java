package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.BuyList;
import com.example.demo.pojo.InStore;

/**
 * @author skyforever
 * @description 针对表【t_in_store(入库单表(记录商品入库信息))】的数据库操作Service
 * @createDate 2025-05-30 11:05:01
 */
public interface InStoreService extends IService<InStore> {

    /*实现采购采购信息入库*/
    void saveBuyOrderInStoreService(BuyList buyList);
}
