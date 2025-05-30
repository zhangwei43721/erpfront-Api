package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.BuyListMapper;
import com.example.demo.mapper.InStoreMapper;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.pojo.BuyList;
import com.example.demo.pojo.InStore;
import com.example.demo.pojo.Item;
import com.example.demo.service.InStoreService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author skyforever
 * @description 针对表【t_in_store(入库单表(记录商品入库信息))】的数据库操作Service实现
 * @createDate 2025-05-30 11:05:01
 */
@Service
public class InStoreServiceImpl extends ServiceImpl<InStoreMapper, InStore>
        implements InStoreService {
    private final BuyListMapper buyListMapper;
    private final ItemMapper itemMapper;
    private final InStoreMapper inStoreMapper;

    public InStoreServiceImpl(BuyListMapper buyListMapper, ItemMapper itemMapper, InStoreMapper inStoreMapper) {
        this.buyListMapper = buyListMapper;
        this.itemMapper = itemMapper;
        this.inStoreMapper = inStoreMapper;
    }

    @Override
    public void saveBuyOrderInStoreService(BuyList buyList) {
        //获得商品id
        Integer productId = buyList.getProductId();
        //通过商品id获得商品的库存
        Item goods = itemMapper.selectById(productId);

        Item item = new Item();
        item.setId(productId);
        item.setStore(goods.getStore() - buyList.getFactBuyNum());
        //跟新商品库存
        itemMapper.updateById(item);


        //获得采购单id
        Integer buyId = buyList.getBuyId();
        //更新采购单状态
        BuyList bl = new BuyList();
        bl.setBuyId(buyId);
        bl.setIsIn("1");
        buyListMapper.updateById(bl);

        //查询记录形成入库单
        InStore inStore = new InStore();
        inStore.setStoreId(buyList.getStoreId());
        inStore.setProductId(buyList.getProductId());
        inStore.setInNum(buyList.getFactBuyNum());
        inStore.setCreateBy(1009);
        inStore.setCreateTime(new Date());
        inStore.setIsIn("1");
        inStoreMapper.insert(inStore);
    }
}




