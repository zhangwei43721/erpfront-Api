package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色信息表 (权限管理)
 *
 * @TableName t_roler
 */
@TableName(value = "t_roler")
@Data
public class Roler {
    /**
     * 角色ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String rname;

    /**
     * 角色描述
     */
    private String rdesc;
}