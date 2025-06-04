package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ReplayMapper;
import com.example.demo.pojo.Replay;
import com.example.demo.service.ReplayService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author skyforever
 * @description 针对表【t_replay(用户反馈/评价表)】的数据库操作Service实现
 * @createDate 2025-05-19 11:19:49
 */
@Service
public class ReplayServiceImpl extends ServiceImpl<ReplayMapper, Replay>
        implements ReplayService {

    private final ReplayMapper replayMapper;

    public ReplayServiceImpl(ReplayMapper replayMapper) {
        this.replayMapper = replayMapper;
    }

    @Override
    public Map<String, Object> queryReplayListService(Integer id
            , Integer pageNum, Integer pageSize) {

        Page<Replay> page = new Page<>(pageNum, pageSize);
        //封装whrer条件
        QueryWrapper<Replay> wrapper
                = new QueryWrapper<>();
        wrapper.eq("ques_id", id); //where ques_id=?
        //指定分页参数
        List<Replay> replayList = replayMapper.selectList(page, wrapper);

        Map<String, Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("replayList", replayList);

        return result;
    }

    @Override
    public void saveReplayWithLogic(Replay replay) {
        replay.setRedate(new Date());
        replay.setScore(ThreadLocalRandom.current().nextInt(1, 6));
        this.save(replay);
    }
}




