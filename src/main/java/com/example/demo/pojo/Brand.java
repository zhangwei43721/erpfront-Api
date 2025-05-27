package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 品牌表
 * @TableName t_brand
 */
@TableName(value ="t_brand")
@Data
public class Brand {
    /**
     * 品牌ID
     */
    @TableId(type = IdType.AUTO)
    private Integer brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌首字母
     */
    private String brandLeter;

    /**
     * 品牌描述
     */
    private String brandDesc;
}