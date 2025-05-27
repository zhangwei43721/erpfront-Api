package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 供货商表
 * @TableName t_supply
 */
@TableName(value ="t_supply")
@Data
public class Supply {
    /**
     * 供应商ID
     */
    @TableId(type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 供应商编号
     */
    private String supplyNum;

    /**
     * 供应商名称
     */
    private String supplyName;

    /**
     * 供应商介绍
     */
    private String supplyIntroduce;

    /**
     * 联系人
     */
    private String concat;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 供应商地址
     */
    private String address;

    /**
     * 逻辑删除标记(0:可用  1:不可用)
     */
    private String isDelete;
}