package com.example.demo.Controller;

import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import com.example.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /* 处理分页查询请求 */
    @PostMapping("/listOrder")
    public Map<String, Object> listOrders(@RequestBody Order order) {
        return orderService.queryOrderListService(order);
    }

    /* 添加订单 */
    @PostMapping("/saveOrder")
    public Map<String, Object> saveOrder(@RequestBody Order order) {
        orderService.save(order);
        return ResponseUtil.success("添加成功");
    }

    /* 删除订单 */
    @DeleteMapping("/deleteOrder/{id}")
    public Map<String, Object> deleteOrder(@PathVariable Integer id) {
        boolean removed = orderService.removeById(id);
        if (removed) {
            return ResponseUtil.success("删除成功");
        } else {
            return ResponseUtil.error(400, "删除失败");
        }
    }

    /* 修改订单 */
    @PutMapping("/updateOrder")
    public Map<String, Object> updateOrder(@RequestBody Order order) {
        boolean updated = orderService.updateById(order);
        if (updated) {
            return ResponseUtil.success("修改成功");
        } else {
            return ResponseUtil.error(400, "修改失败");
        }
    }
}