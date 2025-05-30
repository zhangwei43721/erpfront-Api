package com.example.demo.vo;

import lombok.Data;

@Data
public class ItemCond {

    private String itemNum;
    private String itemName;
    private Integer statue;
    private Integer pageNum = 1;
    private Integer pageSize = 3;
}
