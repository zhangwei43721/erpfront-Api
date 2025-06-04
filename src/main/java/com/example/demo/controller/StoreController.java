package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    /*处理加载仓库选项的请求*/
    @GetMapping("/storeList")
    public List<Store> storeList() {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.select("store_id", "store_name");
        return storeService.list(wrapper);
    }
     /*处理仓库数据分页查询请求*/
    @GetMapping("/storePageList")
    public Map<String,Object> queryStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "10")Integer pageSize){
        Page<Store> page=new Page<>(pageNum,pageSize);
        List<Store> storeList = storeService.list(page);

        Map<String,Object> result=new HashMap<>();
        result.put("total",page.getTotal());
        result.put("storeList",storeList);

        return  result;
    }
}
