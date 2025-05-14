package com.example.demo.Controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*添加客户信息*/
    @PostMapping("/saveCust")
    public Map<String, Object> saveCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        customerService.save(customer);
        result.put("code", 200);
        return result;
    }
    /*处理客户信息分页查询请求*/
    @GetMapping("/listCust")
    public Map<String, Object> queryCustList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return customerService.queryCustListService(pageNum, pageSize);
    }

    /*删除客户信息*/
    @DeleteMapping("/deleteCust/{id}")
    public Map<String, Object> deleteCustomer(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            customerService.removeById(id);
            result.put("code", 200);
            result.put("message", "删除成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        return result;
    }

    /*修改客户信息*/
    @PutMapping("/updateCust")
    public Map<String, Object> updateCustomer(@RequestBody Customer customer) {
        Map<String, Object> result = new HashMap<>();
        try {
            customerService.updateById(customer);
            result.put("code", 200);
            result.put("message", "修改成功");
        } catch (Exception e) {
            result.put("code", 400);
            result.put("message", "修改失败");
        }
        return result;
    }

}
