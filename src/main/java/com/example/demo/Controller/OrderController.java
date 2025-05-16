package com.example.demo.Controller;

import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /* 处理分页查询请求 */
//    @GetMapping("/listOrder")
//    public Map<String, Object> listOrders(
//            @RequestParam(defaultValue = "1") Integer pageNum,
//            @RequestParam(defaultValue = "3") Integer pageSize) {
//        return orderService.queryOrderListService(pageNum, pageSize);
//    }
    @PostMapping("/listOrder")
    public Map<String,Object> listOrders(@RequestBody Order order){
        return orderService.queryOrderListService(order);
    }

    /* 添加订单 */
    @PostMapping("/saveOrder")
    public Map<String, Object> saveOrder(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();
        try {
            orderService.save(order);
            result.put("code", 200);
            result.put("message", "添加成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "添加失败");
        }
        return result;
    }

    /* 删除订单 */
    @DeleteMapping("/deleteOrder/{id}")
    public Map<String, Object> deleteOrder(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            orderService.removeById(id);
            result.put("code", 200);
            result.put("message", "删除成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    /* 修改订单 */
    @PutMapping("/updateOrder")
    public Map<String, Object> updateOrder(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();
        try {
            orderService.updateById(order);
            result.put("code", 200);
            result.put("message", "修改成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "修改失败");
        }
        return result;
    }
}