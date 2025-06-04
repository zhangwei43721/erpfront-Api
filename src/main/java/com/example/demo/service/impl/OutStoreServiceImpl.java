package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.mapper.OutStoreMapper;
import com.example.demo.pojo.Item;
import com.example.demo.pojo.OutStore;
import com.example.demo.service.OutStoreService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_out_store(出库单)】的数据库操作Service实现
* @createDate 2025-06-03 11:52:56
*/
@Service
public class OutStoreServiceImpl extends ServiceImpl<OutStoreMapper, OutStore>
    implements OutStoreService{

    private final ItemMapper itemMapper;
    private final OutStoreMapper outStoreMapper;

    public OutStoreServiceImpl(ItemMapper itemMapper, OutStoreMapper outStoreMapper) {
        this.itemMapper = itemMapper;
        this.outStoreMapper = outStoreMapper;
    }

    @Transactional
    @Override
    public boolean saveOutStoreService(OutStore outStore) {

        //根据商品查询对应商品的库存
        Item product = itemMapper.selectById(outStore.getProductId());

        Item item =new Item();
        item.setId(outStore.getProductId());
        item.setStore(product.getStore()-outStore.getOutNum());
        //实现商品信息的更新
        itemMapper.updateById(item);

        outStore.setIsOut("0");
        outStore.setCreateTime(new Date());
        outStore.setCreateBy(101010);
        outStore.setOutPrice(BigDecimal.valueOf(product.getSellPrice()));
        outStore.setStoreId(product.getStoreId());
        outStore.setProductId(product.getId());

        //实现出库单信息的保存
        outStoreMapper.insert(outStore);

        return false;
    }

    @Override
    public Map<String, Object> queryOutStoreListMapper(Integer pageNum, Integer pageSize) {
        //创建Map
        Map<String,Object> result=new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);

        //查询数据库
        List<OutStore> outStoreList = outStoreMapper.queryOutStorListeMapper();

        result.put("total",page.getTotal());
        result.put("outStoreList",outStoreList);
        return result;
    }
}




