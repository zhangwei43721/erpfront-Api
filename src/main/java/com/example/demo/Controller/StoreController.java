package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StoreController {

    @Autowired
    private StoreService storeService;

    /*处理加载仓库选项的请求*/
    @GetMapping("/storeList")
    public List<Store> storeList(){
        QueryWrapper<Store> wrapper=new QueryWrapper<>();
        wrapper.select("store_id","store_name");
        return storeService.list(wrapper);
    }
}
