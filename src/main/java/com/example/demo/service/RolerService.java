package com.example.demo.service;

import com.example.demo.pojo.Roler;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author skyforever
* @description 针对表【t_roler(角色信息表 (权限管理))】的数据库操作Service
* @createDate 2025-05-22 09:43:40
*/
public interface RolerService extends IService<Roler> {

    public Map<String,Object> queryRolePageListService(Integer pageNum, Integer pageSize);

}
