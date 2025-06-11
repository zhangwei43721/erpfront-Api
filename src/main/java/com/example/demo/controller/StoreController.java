package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import com.example.demo.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
    public Map<String, Object> queryStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Store> page = new Page<>(pageNum, pageSize);
        List<Store> storeList = storeService.list(page);

        Map<String, Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("storeList", storeList);

        return result;
    }

    /*添加方法处理仓库信息的添加请求*/
    @PostMapping("/saveStore")
    public Map<String, Object> saveStore(@RequestBody Store store) {
        return storeService.save(store) ? R.success("保存仓库信息成功") : R.error("保存仓库信息失败");
    }

    /*处理仓库信息的修改请求*/
    @PostMapping("/updateStore")
    public Map<String, Object> updateStore(@RequestBody Store store) {
        return storeService.updateById(store) ? R.success("修改仓库信息成功") : R.error("修改仓库信息失败");
    }

    /*处理仓库信息的删除请求*/
    @PostMapping("/deleteStore/{id}")
    public Map<String, Object> deleteStore(@PathVariable Integer id) {
        return storeService.removeById(id) ? R.success("删除仓库信息成功") : R.error("删除仓库信息失败");
    }
}
