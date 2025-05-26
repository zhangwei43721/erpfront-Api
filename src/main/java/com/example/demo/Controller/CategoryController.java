package com.example.demo.Controller;

import com.example.demo.service.CategoryService;
import com.example.demo.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*处理加载商品类目树请求*/
    @GetMapping("/categoryList")
    public List<TreeVo> categoryList(){
        return categoryService.queryCategoryListService();
    }
}
