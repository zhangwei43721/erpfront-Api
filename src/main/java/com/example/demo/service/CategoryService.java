package com.example.demo.service;

import com.example.demo.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.vo.TreeVo;

import java.util.List;

/**
* @author skyforever
* @description 针对表【t_category(商品分类表)】的数据库操作Service
* @createDate 2025-05-26 09:32:41
*/
public interface CategoryService extends IService<Category> {

    /*加载商品类目树*/
    List<TreeVo> queryCategoryListService();

}
