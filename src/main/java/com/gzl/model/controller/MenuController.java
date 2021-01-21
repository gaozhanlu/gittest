package com.gzl.model.controller;


import com.gzl.model.dao.IMenuDao;
import com.gzl.model.entity.MenuEntity;
import com.gzl.model.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzl
 * @since 2020-11-27
 */
@Api(tags = "菜单服务")
@RequestMapping("menu")
@RestController

public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "/getMenuById",method= RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询菜单信息")
    public MenuEntity getMenuById(String menuId){
        return  menuService.getMenuById(menuId);
    }

    @RequestMapping(value = "/getMenuByParentId",method= RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询子菜单信息")
    public List<MenuEntity> getMenuByParentId(String parentId){
        return  menuService.getMenuByParentId(parentId);
    }

    @Autowired
    IMenuDao menuDao;
    @ApiOperation("查询")
    @PostMapping("getRoleMenuById")
    public List getMenuByunll() {
        List<MenuEntity> menuEntityList=menuDao.getMenuBynull();

        System.out.println(menuEntityList.toString());
        List<String> menuIdList=menuEntityList.stream().map(e->e.getMenuId()).collect(Collectors.toList());
        System.out.println("分格符============");
        System.out.println(menuIdList.toString());

        List<MenuEntity> TwoMenu=menuDao.getMenuByMenuIdList(menuIdList);

        return TwoMenu;
    }

}
