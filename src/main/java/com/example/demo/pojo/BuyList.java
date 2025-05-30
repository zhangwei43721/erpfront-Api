package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 采购单表，记录商品采购信息
 * @TableName buy_list
 */
@TableName(value ="t_buy_list")
@Data
public class BuyList {
    public BuyList() {}

    /**
     * 采购单ID
     */
    @TableId(type = IdType.AUTO)
    private Integer buyId;

    /**
     * 产品ID，关联产品表
     */
    private Integer productId;

    /**
     * 仓库ID，关联仓库表
     */
    private Integer storeId;

    /**
     * 计划采购数量
     */
    private Integer buyNum;

    /**
     * 实际采购数量
     */
    private Integer factBuyNum;

    /**
     * 采购时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buyTime;

    /**
     * 供应商ID，关联供应商表
     */
    private Integer supplyId;

    /**
     * 采购地点ID，关联地点表
     */
    private Integer placeId;

    /**
     * 采购人姓名
     */
    private String buyUser;

    /**
     * 采购人联系电话
     */
    private String phone;

    /**
     * 是否入库：0-否，1-是
     */
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private String itemName;
    @TableField(exist = false)
    private String storeName;
}