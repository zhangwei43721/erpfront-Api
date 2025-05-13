package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 前端菜单表
 * @TableName t_menu
 */
@TableName(value ="t_menu")
@Data
public class Menu {
    /**
     * ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 导航名称
     */
    private String label;

    /**
     * 子id
     */
    private Integer component;

    /**
     * 父id
     */
    private Integer pid;
}