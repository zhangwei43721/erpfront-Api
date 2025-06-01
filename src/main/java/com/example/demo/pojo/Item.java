package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.handler.ListStringJsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品信息表
 *
 * @TableName t_item
 */
@TableName(value = "t_item")
@Data
public class Item implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 商品ID，主键，自动递增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商品编号
     */
    private String itemNum;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * 商品类型ID
     */
    private Integer typeId;
    /**
     * 库存数量
     */
    private Integer store;
    /**
     * 品牌ID
     */
    private Integer brandId;
    /**
     * 门店ID
     */
    private Integer storeId;
    /**
     * 供应商ID
     */
    private Integer supplyId;
    /**
     * 产地ID
     */
    private Integer placeId;
    /**
     * 单位ID
     */
    private Integer unitId;
    /**
     * 进货价格
     */
    private Double price;
    /**
     * 销售价格
     */
    private Double sellPrice;
    /**
     * 会员价格
     */
    private Double vipPrice;
    /**
     * 商品描述
     */
    private String itemDesc;
    /**
     * 生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date itemDate;
    /**
     * 到期日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 促销标题
     */
    private String hotTitle;
    /**
     * 制造商
     */
    private String facturer;
    /**
     * 商品状态
     */
    private Integer statue;
    /**
     * 商品图片路径
     */
    @JsonProperty("imgs")
    @TableField(typeHandler = ListStringJsonTypeHandler.class)
    private List<String> imgs;
    /**
     * 创建者
     */
    private String createBy;
    //扩展属性封装名称
    @TableField(exist = false)
    private String brandName;
    @TableField(exist = false)
    private String placeName;
    @TableField(exist = false)
    private String supplyName;
    @TableField(exist = false)
    private String unitName;
    @TableField(exist = false)
    private String cateName;
    @TableField(exist = false)
    private String storeName;
}