package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.OutStore;

import java.util.List;

/**
* @author skyforever
* @description 针对表【t_out_store(出库单)】的数据库操作Mapper
* @createDate 2025-06-03 11:52:56
* @Entity com.example.demo.pojo.OutStore
*/
public interface OutStoreMapper extends BaseMapper<OutStore> {

        /*实现入库单信息分页查询*/
        List<OutStore> queryOutStorListeMapper();
}




