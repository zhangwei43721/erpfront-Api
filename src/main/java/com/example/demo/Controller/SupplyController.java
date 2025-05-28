package com.example.demo.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Supply;
import com.example.demo.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    /*加载供应商下拉列表框数据*/
    @GetMapping("/supplyList")
    public List<Supply> querySupplyList() {
        QueryWrapper<Supply> wrapper = new QueryWrapper<>();
        wrapper.select("supply_id", "supply_name");
        return supplyService.list(wrapper);
    }
}
