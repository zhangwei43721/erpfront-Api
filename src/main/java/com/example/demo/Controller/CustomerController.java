package com.example.demo.Controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCust")
    public Map<String, Object> saveCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        customerService.save(customer);
        result.put("code", 200);
        return result;
    }

}
