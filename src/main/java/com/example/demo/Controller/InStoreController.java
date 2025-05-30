package com.example.demo.Controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.service.InStoreService;
import com.example.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class InStoreController {
    private final InStoreService inStoreService;

    public InStoreController(InStoreService inStoreService) {
        this.inStoreService = inStoreService;
    }

    /*处理采购单入库请求*/
    @PostMapping("/buyInStore")
    public Map<String, Object> buyInStore(@RequestBody BuyList buyList) {
        inStoreService.saveBuyOrderInStoreService(buyList);
        return ResponseUtil.success("入库成功");
    }
}

