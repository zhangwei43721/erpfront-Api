package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * @author skyforever
 * @description 针对表【t_store(仓库表)】的数据库操作Service实现
 * @createDate 2025-05-27 14:38:02
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
        implements StoreService {

}




