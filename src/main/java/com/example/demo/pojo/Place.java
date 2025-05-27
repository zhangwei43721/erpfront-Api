package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产地表
 * @TableName t_place
 */
@TableName(value ="t_place")
@Data
public class Place {
    /**
     * 产地ID
     */
    @TableId(type = IdType.AUTO)
    private Integer placeId;

    /**
     * 产地名称
     */
    private String placeName;

    /**
     * 产地编号
     */
    private String placeNum;

    /**
     * 产地介绍
     */
    private String introduce;

    /**
     * 逻辑删除标记(0:可用  1:不可用)
     */
    private String isDelete;
}