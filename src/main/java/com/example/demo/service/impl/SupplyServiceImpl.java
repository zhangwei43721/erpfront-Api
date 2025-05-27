package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Supply;
import com.example.demo.service.SupplyService;
import com.example.demo.mapper.SupplyMapper;
import org.springframework.stereotype.Service;

/**
* @author skyforever
* @description 针对表【t_supply(供货商表)】的数据库操作Service实现
* @createDate 2025-05-27 14:38:02
*/
@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply>
    implements SupplyService{

}




