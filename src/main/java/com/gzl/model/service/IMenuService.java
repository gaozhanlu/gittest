package com.gzl.model.service;


import com.gzl.model.entity.MenuEntity;

import java.util.List;

/**
 * @author gzl
 * @since 2020-11-28
 */
public interface IMenuService  {
    /*
     *获取菜单信息
     */
    public MenuEntity getMenuById(String menuId);

    public List<MenuEntity> getMenuByParentId(String parentId);

    List<MenuEntity> findByPage(int offset,int size);
}
