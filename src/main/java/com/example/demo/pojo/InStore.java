package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 入库单表(记录商品入库信息)
 * @TableName t_in_store
 */
@TableName(value ="t_in_store")
@Data
public class InStore {
    /**
     * 入库单ID
     */
    @TableId(type = IdType.AUTO)
    private Integer insId;

    /**
     * 仓库ID(关联仓库表)
     */
    private Integer storeId;

    /**
     * 商品ID(关联商品表)
     */
    private Integer productId;

    /**
     * 入库数量
     */
    private Integer inNum;

    /**
     * 创建人ID(关联用户表)
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 入库状态(0-未入库，1-已入库)
     */
    private String isIn;
}