package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Brand;
import com.example.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brandList")
    public List<Brand> queryBrandList(){
        QueryWrapper<Brand> wrapper=new QueryWrapper<>();
        wrapper.select("brand_id","brand_name");
        return brandService.list(wrapper);
    }
}
