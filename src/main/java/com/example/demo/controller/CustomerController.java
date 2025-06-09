package com.example.demo.controller;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin // 如果全局配置了，可以移除
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*添加客户信息*/
    @PostMapping("/saveCust")
    public Map<String, Object> saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return R.success("添加客户成功");
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
        boolean removed = customerService.removeById(id);
        if (removed) {
            return R.success("删除成功");
        } else {
            return R.error(400, "删除失败");
        }
    }

    /*修改客户信息*/
    @PutMapping("/updateCust")
    public Map<String, Object> updateCustomer(@RequestBody Customer customer) {
        boolean updated = customerService.updateById(customer);
        if (updated) {
            return R.success("修改成功");
        } else {
            return R.error(400, "修改失败");
        }
    }

    /*处理加载所有客户列表请求*/
    @GetMapping("/listAllCust")
    public List<Customer> listAllCust() {
        return customerService.queryCustIdNameListService();
    }

    /*处理客户地区分布统计请求*/
    @GetMapping("/countCust")
    public List<CountResult> countCust() {
        return customerService.countCustService();
    }
}