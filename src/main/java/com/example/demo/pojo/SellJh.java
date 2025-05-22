package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 销售计划表
 *
 * @TableName t_sell_jh
 */
@TableName(value = "t_sell_jh")
@Data
public class SellJh implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 客户ID
     */
    private Integer custid;
    /**
     * 渠道ID
     */
    private Integer channelId;
    /**
     * 金额
     */
    private Double money;
    /**
     * 当前步骤
     */
    private String nowStep;
    /**
     * 员工ID
     */
    private Integer empId;
    @TableField(exist = false)
    //扩展属性，封装客户名字
    private String custName;

}