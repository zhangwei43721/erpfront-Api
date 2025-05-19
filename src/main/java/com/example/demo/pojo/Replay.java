package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 用户反馈/评价表
 * @TableName t_replay
 */
@TableName(value ="t_replay")
@Data
public class Replay {
    /**
     * 反馈/评价ID (主键)
     */
    @TableId
    private Integer id;

    /**
     * 反馈或评价内容
     */
    private String content;

    /**
     * 反馈或评价日期时间
     */
    private Date redate;

    /**
     * 评分 (如：1-5分)
     */
    private Integer score;
}