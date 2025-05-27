package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Place;
import com.example.demo.service.PlaceService;
import com.example.demo.mapper.PlaceMapper;
import org.springframework.stereotype.Service;

/**
* @author skyforever
* @description 针对表【t_place(产地表)】的数据库操作Service实现
* @createDate 2025-05-27 14:38:02
*/
@Service
public class PlaceServiceImpl extends ServiceImpl<PlaceMapper, Place>
    implements PlaceService{

}




