package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 出库单
 *
 * @TableName t_out_store
 */
@TableName(value = "t_out_store")
@Data
public class OutStore {
    /**
     * 出库单ID，主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer outsId;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 仓库ID
     */
    private Integer storeId;

    /**
     * 理货ID
     */
    private Integer tallyId;

    /**
     * 出库单价
     */
    private BigDecimal outPrice;

    /**
     * 出库数量
     */
    private Integer outNum;

    /**
     * 创建人ID
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 是否出库：0 否，1 是
     */
    private String isOut;

    @TableField(exist = false)
    private String itemName;

    @TableField(exist = false)
    private String storeName;

}