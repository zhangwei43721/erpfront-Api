package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 售后服务表
 * @TableName t_after_sales
 */
@TableName(value ="t_after_sales")
@Data
public class AfterSales {
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
     * 问题描述
     */
    private String question;

    /**
     * 状态
     */
    private String state;

    /**
     * 紧急程度
     */
    private String grade;

    /**
     * 级别
     */
    private Integer level;

    @TableField(exist = false)
    private String custName;
    @TableField(exist = false)
    private Integer pageNum=1;
    @TableField(exist = false)
    private Integer pageSize=3;
}