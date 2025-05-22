package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 *
 * @TableName t_order
 */
@TableName(value = "t_order")
@Data
public class Order implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @TableField(exist = false)
    private Integer num;

    @TableField(exist = false)
    private String custName;

    @TableField(exist = false)
    private String itemName;

    @TableField(exist = false)
    private Integer pageNum = 1;

    @TableField(exist = false)
    private Integer pageSize = 3;
}