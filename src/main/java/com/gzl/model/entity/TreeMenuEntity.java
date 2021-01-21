package com.gzl.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class TreeMenuEntity {
    private String menuId;
    private String menuName;
    private String parentId;
    private String menuLevel;
    private List<TreeMenuEntity> childMenus;
}
