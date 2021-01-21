package com.gzl.model.dao;


import com.gzl.model.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Mapper
public interface IMenuDao {
    /**
     * @Description:
     * @auther: gaozhanlu
     * @date: 2020/12/20 
     * @param: 
     * @return: 
     */
    public MenuEntity getMenuById(String menuId);

    public List<MenuEntity> getMenuByParentId(String parentId);

    public List<MenuEntity> getAllMenu();
    public List<MenuEntity> getMenuBynull();
    public List<MenuEntity> getMenuByMenuIdList(List<String> menuIdList);

    List<MenuEntity> findByPage(int offset,int size);


}
