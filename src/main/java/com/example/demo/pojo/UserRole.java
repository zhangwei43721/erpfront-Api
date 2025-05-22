package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色关联表 (分配用户角色)
 * @TableName t_user_role
 */
@TableName(value ="t_user_role")
@Data
public class UserRole {
    /**
     * 关联ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID (关联t_user.id)
     */
    private Integer uid;

    /**
     * 角色ID (关联t_roler.id)
     */
    private Integer rid;
}