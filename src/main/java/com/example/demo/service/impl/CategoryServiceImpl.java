package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<TreeVo> queryCategoryListService() {
        //查询数据库获得所有商品类目
        List<Category> categrories = categoryMapper.selectList(null);
        return toListTreeVo(categrories, 0);
    }

    // 声明方法，递归遍历categories集合，将该集合转化为List<TreeVo>
    private List<TreeVo> toListTreeVo(List<Category> categories, Integer id) {
        List<TreeVo> result = new ArrayList<>();
        System.out.println("转换开始 - 当前父ID: " + id + ", 总记录数: " + categories.size());

        for (Category category : categories) {
            System.out.println("处理节点: " + category.getCateName() + ", PID: " + (category.getPid() != null ? category.getPid().toString() : "null") + ", 当前ID: " + category.getId());

            if (Objects.equals(category.getPid(), id)) {  // 使用Objects.equals()避免空指针异常
                System.out.println("匹配到子节点: " + category.getCateName() + ", PID: " + id);
                TreeVo treeVo = new TreeVo();
                treeVo.setId(category.getId());
                treeVo.setLabel(category.getCateName());
                treeVo.setChildren(toListTreeVo(categories, category.getId()));
                result.add(treeVo);
            } else {
                System.out.println("未匹配节点: " + category.getCateName() + ", PID: " + category.getPid() + ", 需要: " + id);
            }
        }

        System.out.println("转换结束 - 结果数量: " + result.size() + ", 父ID: " + id);
        return result;
    }
}