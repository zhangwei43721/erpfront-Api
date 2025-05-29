package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.*;
import com.example.demo.pojo.*;
import com.example.demo.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author skyforever
* @description 针对表【buy_list(采购单表，记录商品采购信息)】的数据库操作Service实现
* @createDate 2025-05-29 11:53:57
*/
@Service
public class BuyListServiceImpl extends ServiceImpl<BuyListMapper, BuyList>
    implements BuyListService{


    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private SupplyMapper supplyMapper;
    @Autowired
    private PlaceMapper placeMapper;
    @Override
    public Map<String, Object> queryAutoDataBuyService(Integer id) {
        Map<String, Object> result=new HashMap<>();
        //查询商品信息
        Item item = itemMapper.selectById(id);
        result.put("id",item.getId());
        result.put("itemName",item.getItemName());
        //查询仓库信息
        Integer storeId = item.getStoreId();
        Store store = storeMapper.selectById(storeId);
        result.put("storeId",store.getStoreId());
        result.put("storeName",store.getStoreName());
        //查询供应商信息
        Integer supplyId = item.getSupplyId();
        Supply supply = supplyMapper.selectById(supplyId);
        result.put("supplyId",supply.getSupplyId());
        result.put("supplyName",supply.getSupplyName());
        //查询产地信息
        Integer placeId = item.getPlaceId();
        Place place = placeMapper.selectById(placeId);
        result.put("placeId",place.getPlaceId());
        result.put("placeName",place.getPlaceName());


        return result;
    }
}




