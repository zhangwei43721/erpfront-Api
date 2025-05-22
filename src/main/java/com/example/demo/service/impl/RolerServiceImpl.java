package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Roler;
import com.example.demo.service.RolerService;
import com.example.demo.mapper.RolerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_roler(角色信息表 (权限管理))】的数据库操作Service实现
* @createDate 2025-05-22 09:43:40
*/
@Service
public class RolerServiceImpl extends ServiceImpl<RolerMapper, Roler>
    implements RolerService{

    @Autowired
    private RolerMapper rolerMapper;
    @Override
    public Map<String, Object> queryRolePageListService(Integer pageNum, Integer pageSize) {

        //指定分页查询参数
        Page<Roler> page=new Page<>(pageNum,pageSize);
        List<Roler> rolerList = rolerMapper.selectList(page, null);

        Map<String, Object> result=new HashMap<>();
        result.put("total",page.getTotal());
        result.put("rolerList",rolerList);
        return result;
    }
}




