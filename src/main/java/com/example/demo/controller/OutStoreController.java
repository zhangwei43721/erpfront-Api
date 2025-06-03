package com.example.demo.controller;

import com.example.demo.pojo.OutStore;
import com.example.demo.service.OutStoreService;
import com.example.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class OutStoreController {
    @Autowired
    private OutStoreService outStoreService;

    /*处理商品信息出库请求*/
    @PostMapping("/doItemOutStore")
    public Map<String,Object> doItemOutStore(@RequestBody OutStore outStore){
        if (outStoreService.saveOutStoreService(outStore)){
            return R.success("商品出库成功");
        }else{
            return R.error("商品出库失败");
        }
    }
}

