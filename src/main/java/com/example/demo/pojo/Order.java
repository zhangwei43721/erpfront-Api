package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
public class Order {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 客户ID
     */
    private Integer custId;

    /**
     * 商品ID
     */
    private Integer itemId;

    /**
     * 下单时间
     */
    private Date orderDate;

    /**
     * 状态
     */
    private String state;

    /**
     * 支付方式
     */
    private String pay;

    /**
     * 支付金额
     */
    private Double payMoney;
}