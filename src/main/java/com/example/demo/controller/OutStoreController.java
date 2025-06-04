package com.example.demo.controller;

import com.example.demo.pojo.OutStore;
import com.example.demo.service.OutStoreService;
import com.example.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class OutStoreController {
    @Autowired
    private OutStoreService outStoreService;

    /*处理商品信息出库请求*/
    @PostMapping("/doItemOutStore")
    public Map<String, Object> doItemOutStore(@RequestBody OutStore outStore) {
        if (outStoreService.saveOutStoreService(outStore)) {
            return R.success("商品出库成功");
        } else {
            return R.error("商品出库失败");
        }
    }

    /*处理出库单分页查询请求*/
    @GetMapping("/outStoreList")
    public Map<String, Object> outStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "3") Integer pageSize) {
        return outStoreService.queryOutStoreListMapper(pageNum, pageSize);
    }

    /*处理出库单确认请求*/
    @GetMapping("/updateOutStore")
    public Map<String, Object> updateOutStore(Integer id) {
        OutStore os = new OutStore();
        os.setOutsId(id);
        os.setIsOut("1");
        if (outStoreService.updateById(os)) {
            return R.success("确认成功");
        } else {
            return R.error("确认失败");
        }
    }


}

