package com.example.demo.controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.pojo.InStore;
import com.example.demo.service.InStoreService;
import com.example.demo.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class InStoreController {
    private final InStoreService inStoreService;

    public InStoreController(InStoreService inStoreService) {
        this.inStoreService = inStoreService;
    }

    /*处理采购单入库请求*/
    @PostMapping("/buyInStore")
    public Map<String, Object> buyInStore(@RequestBody BuyList buyList) {
        inStoreService.saveBuyOrderInStoreService(buyList);
        return R.success("入库成功");
    }
     /*处理入库单列表分页查询请求*/
    @GetMapping("/queryInList")
    public Map<String,Object> queryInStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "10") Integer pageSize){
        return inStoreService.queryInStoreListService(pageNum,pageSize);
    }

    /*处理入库单删除请求*/
    @PostMapping("/deleteInList/{id}")
    public Map<String, Object> deleteInList(@PathVariable Integer id) {
        return inStoreService.removeById(id) ? R.success("删除成功") : R.error("删除失败");
    }
     /*处理入库单修改请求*/
    @PostMapping("/updateInList")
     public Map<String, Object> updateInList(@RequestBody InStore inStore) {
         return inStoreService.updateById(inStore) ? R.success("修改成功") : R.error("修改失败");
    }
     /*处理入库单确认请求*/
    @PostMapping("/updateInStore/{id}")
    public Map<String,Object> updateInStore(@PathVariable Integer id){
        InStore inStore=new InStore();
            inStore.setInsId(id);
            inStore.setIsIn("0");
            return inStoreService.updateById(inStore)? R.success("确认成功"): R.error("确认失败");
    }

}

