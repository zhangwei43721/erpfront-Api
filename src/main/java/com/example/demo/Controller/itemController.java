package com.example.demo.Controller;

import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class itemController {

    @Autowired
    private ItemService itemService;

    /*添加商品信息*/
    @PostMapping("/saveItem")
    public Map<String, Object> saveItem(@RequestBody Item item) {
        itemService.save(item);
        return ResponseUtil.success("添加商品成功");
    }

    /*处理商品信息分页查询请求*/
    @GetMapping("/listItems")
    public List<Item> queryItemList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return itemService.queryItemListService(pageNum, pageSize);
    }

    /*删除商品信息*/
    @DeleteMapping("/deleteItem/{id}")
    public Map<String, Object> deleteItem(@PathVariable Integer id) {
        boolean removed = itemService.removeById(id);
        if (removed) {
            return ResponseUtil.success("删除成功");
        } else {
            return ResponseUtil.error(400, "删除失败");
        }
    }

    /*修改商品信息*/
    @PutMapping("/updateItem")
    public Map<String, Object> updateItem(@RequestBody Item item) {
        boolean updated = itemService.updateById(item);
        if (updated) {
            return ResponseUtil.success("修改成功");
        } else {
            return ResponseUtil.error(400, "修改失败");
        }
    }

}