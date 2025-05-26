package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品分类表
 * @TableName t_category
 */
@TableName(value ="t_category")
@Data
public class Category {
    /**
     * ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * ISBN 编号
     */
    private String isbn;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 父分类ID
     */
    private Integer pid;
}