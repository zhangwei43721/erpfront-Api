package com.example.demo.vo;

import lombok.Data;

import java.util.List;
@Data
public class MenuVo {
    private Integer id;
    private Integer pid;
    private String label;
    private Integer component;
    private List<MenuVo> subMenu;
    private Integer sortOrder;
    private String iconName;
}