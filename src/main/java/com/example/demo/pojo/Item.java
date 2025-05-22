package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品表
 *
 * @TableName t_item
 */
@TableName(value = "t_item")
@Data
public class Item {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 价格
     */
    private Double price;

    /**
     * 生产日期
     */
    private Date itemDate;

    /**
     * 促销标题
     */
    private String hotTitle;

    /**
     * 生产厂家
     */
    private String facturer;

    /**
     * 库存
     */
    private Integer store;
}