package com.example.demo.controller;

import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.CodeUtils;
import com.example.demo.util.R;
import com.example.demo.vo.ItemCond;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class itemController {

    private final ItemService itemService;

    public itemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /*处理产生商品编码的请求*/
    @GetMapping("/getCode")
    public String toItemCode() {
        return CodeUtils.toItemCode();
    }

    /*添加商品信息*/
    @PostMapping("/saveItem")
    public Map<String, Object> saveItem(@RequestBody Item item) {
        itemService.save(item);
        return R.success("添加商品成功");
    }

    /*处理商品信息分页查询请求*/
    @PostMapping("/itemList")
    public Map<String, Object> itemList(@RequestBody ItemCond itemCond) {
        return itemService.queryItemListService(itemCond);
    }

    /*删除商品信息*/
    @DeleteMapping("/deleteItem/{id}")
    public Map<String, Object> deleteItem(@PathVariable Integer id) {
        boolean removed = itemService.removeById(id);
        if (removed) {
            return R.success("删除成功");
        } else {
            return R.error(400, "删除失败");
        }
    }

    /*修改商品信息*/
    @PutMapping("/updateItem")
    public Map<String, Object> updateItem(@RequestBody Item item) {
        boolean updated = itemService.updateById(item);
        if (updated) {
            return R.success("修改成功");
        } else {
            return R.error(400, "修改失败");
        }
    }

    /*处理商量的下架请求*/
    @GetMapping("/downItem/{id}")
    public Map<String, Object> downItem(@PathVariable Integer id) {
        Item item = new Item();
        item.setId(id);
        item.setStatue(1); // 1表示已下架状态
        boolean updated = itemService.updateById(item);
        if (updated) {
            return R.success("商品下架成功");
        } else {
            return R.error(400, "操作失败，请重试");
        }
    }

    /*处理商品上架请求*/
    @GetMapping("/upItem/{id}")
    public Map<String, Object> upItem(@PathVariable Integer id) {
        Item item = new Item();
        item.setId(id);
        item.setStatue(0); // 0表示已上架状态
        boolean updated = itemService.updateById(item);
        if (updated) {
            return R.success("商品上架成功");
        } else {
            return R.error(400, "操作失败，请重试");
        }
    }

}