package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 用户信息表 (系统用户)
 *
 * @TableName t_user
 */
@TableName(value = "t_user")
@Data
public class User {
    /**
     * 用户ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 用户密码
     */
    @JsonIgnore
    private String upwd;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 学历
     */
    private String edu;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 职位
     */
    private String title;

    //扩展属性保存用户角色id集合
    @TableField(exist = false)
    private Integer[] rids;
}