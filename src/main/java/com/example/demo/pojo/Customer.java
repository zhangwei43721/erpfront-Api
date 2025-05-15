package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 客户表
 * @TableName t_customer
 */
@TableName(value ="t_customer")
@Data
public class Customer {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phone;

    /**
     * 客户类型
     */
    private String custType;

    /**
     * 等级
     */
    private Integer grade;

    /**
     * 历史总消费
     */
    private Double hisTotal;
}