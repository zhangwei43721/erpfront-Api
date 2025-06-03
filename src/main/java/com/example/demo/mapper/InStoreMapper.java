package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.InStore;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_in_store(入库单表(记录商品入库信息))】的数据库操作Mapper
 * @createDate 2025-05-30 11:05:01
 * @Entity com.example.demo.pojo.InStore
 */
public interface InStoreMapper extends BaseMapper<InStore> {

    /*完成入库单列表分页查询*/
    List<InStore> queryInStoreListMapper();
}




