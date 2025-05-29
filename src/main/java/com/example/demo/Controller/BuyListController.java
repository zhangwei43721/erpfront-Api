package com.example.demo.Controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.service.BuyListService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class BuyListController {

    @Autowired
    private BuyListService buyListService;

    /*处理采购信息需要自动带入数据的请求*/
    @GetMapping("/buyAutoInfo/{id}")
    public Map<String,Object> buyAutoInfo(@PathVariable Integer id){
        return buyListService.queryAutoDataBuyService(id);
    }
    /*保存采购信息*/
    @PostMapping("/saveBuy")
    public Map<String,Object> saveBuy(@RequestBody BuyList buyList){
        return buyListService.save(buyList)? ResponseUtil.success("保存成功"):ResponseUtil.error("保存失败");
    }
}
