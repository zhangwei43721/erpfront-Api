package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.vo.TreeVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author skyforever
 * @description 针对表【t_category(商品分类表)】的数据库操作Service实现
 * @createDate 2025-05-26 09:32:41
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<TreeVo> queryCategoryListService() {
        //查询数据库获得所有商品类目
        List<Category> categrories = categoryMapper.selectList(null);
        return toListTreeVo(categrories, 0);
    }

    // 声明方法，递归遍历categories集合，将该集合转化为List<TreeVo>
    private List<TreeVo> toListTreeVo(List<Category> categories, Integer id) {
        List<TreeVo> result = new ArrayList<>();

        for (Category category : categories) {
            if (Objects.equals(category.getPid(), id)) {  // 使用Objects.equals()避免空指针异常
                TreeVo treeVo = new TreeVo();
                treeVo.setId(category.getId());
                treeVo.setLabel(category.getCateName());
                treeVo.setChildren(toListTreeVo(categories, category.getId()));
                result.add(treeVo);
            }
        }

        return result;
    }
}