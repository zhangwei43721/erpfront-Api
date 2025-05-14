package com.example.demo.Controller;

import com.example.demo.pojo.SellJh;
import com.example.demo.service.SellJhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class SellJhController {

    @Autowired
    private SellJhService sellJhService;

    /*添加销售计划*/
    @PostMapping("/saveSellJh")
    public Map<String, Object> saveSellJh(@RequestBody SellJh sellJh) {
        Map<String, Object> result = new HashMap<>();
        try {
            sellJhService.save(sellJh);
            result.put("code", 200);
            result.put("message", "添加成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "添加失败");
        }
        return result;
    }

//    /*处理销售计划分页查询请求*/
//    @GetMapping("/listSellJh")
//    public Map<String, Object> querySellJhList(
//            @RequestParam(defaultValue = "1") Integer pageNum,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//        return sellJhService.querySellJhListService(pageNum, pageSize);
//    }

    /*删除销售计划*/
    @DeleteMapping("/deleteSellJh/{id}")
    public Map<String, Object> deleteSellJh(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            sellJhService.removeById(id);
            result.put("code", 200);
            result.put("message", "删除成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    /*修改销售计划*/
    @PutMapping("/updateSellJh")
    public Map<String, Object> updateSellJh(@RequestBody SellJh sellJh) {
        Map<String, Object> result = new HashMap<>();
        try {
            sellJhService.updateById(sellJh);
            result.put("code", 200);
            result.put("message", "修改成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "修改失败");
        }
        return result;
    }
}