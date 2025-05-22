package com.example.demo.Controller;

import com.example.demo.pojo.SellJh;
import com.example.demo.service.SellJhService;
import com.example.demo.util.ResponseUtil; // 引入工具类
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class SellJhController {

    @Autowired
    private SellJhService sellJhService;

    /*添加销售计划*/
    @PostMapping("/saveSellJh")
    public Map<String, Object> saveSellJh(@RequestBody SellJh sellJh) {
         sellJhService.save(sellJh);
         return ResponseUtil.success("添加成功");
    }

    /*处理销售计划分页查询请求*/
    @GetMapping("/sellJhList")
    public Map<String, Object> querySellJhList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return sellJhService.querySellJhListService(pageNum, pageSize);
    }

    /*删除销售计划*/
    @DeleteMapping("/deleteSellJh/{id}")
    public Map<String, Object> deleteSellJh(@PathVariable Integer id) {
         sellJhService.removeById(id);
         return ResponseUtil.success("删除成功");
    }

    /*修改销售计划*/
    @PutMapping("/updateSellJh")
    public Map<String, Object> updateSellJh(@RequestBody SellJh sellJh) {
         sellJhService.updateById(sellJh);
         return ResponseUtil.success("修改成功");
    }
}