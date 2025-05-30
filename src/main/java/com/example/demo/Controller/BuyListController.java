package com.example.demo.Controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.service.BuyListService;
import com.example.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
public class BuyListController {

    private final BuyListService buyListService;

    public BuyListController(BuyListService buyListService) {
        this.buyListService = buyListService;
    }

    /*处理采购信息需要自动带入数据的请求*/
    @GetMapping("/buyAutoInfo/{id}")
    public Map<String,Object> buyAutoInfo(@PathVariable Integer id){
        return buyListService.queryAutoDataBuyService(id);
    }
    /*保存采购信息*/
    @PostMapping("/saveBuy")
    public Map<String,Object> saveBuy(@RequestBody BuyList buyList){
        buyList.setBuyTime(new Date());
        buyList.setIsIn("0");
        buyList.setFactBuyNum(0);
        return buyListService.save(buyList)? ResponseUtil.success("保存成功"):ResponseUtil.error("保存失败");
    }
    /*处理采购单分页查询请求*/
    @GetMapping("/queryBuyList")
    public Map<String,Object> queryBuyList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return buyListService.queryBuyListService(pageNum,pageSize);
    }
    /*处理采购单修改请求*/
    @PostMapping("/updateBuyList")
    public Map<String,Object> updateBuyList(@RequestBody BuyList buyList){
        return buyListService.updateById(buyList)? ResponseUtil.success("修改成功"):ResponseUtil.error("修改失败");
    }
    /*处理采购单删除请求*/
    @PostMapping("/deleteBuy/{id}")
    public Map<String,Object> deleteBuy(@PathVariable Integer id){
        return buyListService.removeById(id)? ResponseUtil.success("删除成功"):ResponseUtil.error("删除失败");
    }
}
