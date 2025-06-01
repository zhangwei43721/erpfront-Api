package com.example.demo.controller;

import com.example.demo.pojo.Replay;
import com.example.demo.service.ReplayService;
import com.example.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ReplayController {


    private final ReplayService replayService;

    public ReplayController(ReplayService replayService) {
        this.replayService = replayService;
    }


    /*定义方法处理投诉回复的请求*/
    @PostMapping("/saveReplay")
    public Map<String, Object> saveReplay(@RequestBody Replay replay) {
        replayService.saveReplayWithLogic(replay);
        return ResponseUtil.success("处理投诉回复成功......");
    }

    /*处理回复列表分页查询请求*/
    @GetMapping("/listReplay")
    public Map<String, Object> listReplay(Integer id
            , @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        return replayService.queryReplayListService(id, pageNum, pageSize);
    }
}
