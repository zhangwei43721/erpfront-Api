package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.util.R;
import com.example.demo.vo.TreeVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*处理加载商品类目树请求*/
    @GetMapping("/categoryList")
    public List<TreeVo> categoryList() {
        return categoryService.queryCategoryListService();
    }

    /*处理商品类目添加请求*/
    @PostMapping("/saveCategory")
    public Map<String, Object> saveCategory(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("添加商品类别成功");
    }

    /*处理商品分类回显的请求*/
    @GetMapping("/loadCategory/{id}")
    public Category loadCategory(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    /*处理商品类目更新更新请求*/
    @PostMapping("/updateCategory")
    public Map<String, Object> updateCategory(@RequestBody Category category) {
        categoryService.updateById(category);
        return R.success("更新商品类别成功");
    }

    /*处理商品类目删除请求*/
    @GetMapping("/deleteCategory/{id}")
    public Map<String, Object> deleteCategory(@PathVariable Integer id) {
        categoryService.removeById(id);
        return R.success("删除商品类别成功");
    }
}
