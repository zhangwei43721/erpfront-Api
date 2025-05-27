package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 仓库表
 * @TableName t_store
 */
@TableName(value ="t_store")
@Data
public class Store {
    /**
     * 仓库ID
     */
    @TableId(type = IdType.AUTO)
    private Integer storeId;

    /**
     * 仓库名称
     */
    private String storeName;

    /**
     * 仓库编号
     */
    private String storeNum;

    /**
     * 仓库地址
     */
    private String storeAddress;

    /**
     * 联系人
     */
    private String concat;

    /**
     * 联系电话
     */
    private String phone;
}