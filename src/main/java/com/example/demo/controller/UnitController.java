package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Unit;
import com.example.demo.service.UnitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    /*处理加载商品单位的列表*/
    @GetMapping("/unitList")
    public List<Unit> queryUnitList() {

        QueryWrapper<Unit> wrapper = new QueryWrapper<>();
        wrapper.select("unit_id", "unit_name");
        return unitService.list(wrapper);
    }
}