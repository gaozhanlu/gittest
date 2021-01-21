package com.gzl.model;

import com.gzl.model.common.MenuCommon;
import com.gzl.model.dao.IMenuDao;
import com.gzl.model.entity.MenuEntity;
import com.gzl.model.entity.TreeMenuEntity;
import com.gzl.model.service.IMenuService;
import com.gzl.model.service.ITheardQueryService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    IMenuDao menuDao ;

    @Autowired
    ITheardQueryService iTheardQueryService;
    @Autowired
    IMenuService iMenuService;
    @Test
    public void testTheardQuery() throws ExecutionException, InterruptedException {
        /*int offset=0;
        int size=2;
        List<MenuEntity> page=new ArrayList<>();
        page=iMenuService.findByPage(offset,size);
        System.out.println(page);*/
        iTheardQueryService.getMaxResult();
        System.out.println(iTheardQueryService.getMaxResult());

    }

    @Test
    public void testQueryMenuList() {
        // 原始的数据
        List<MenuEntity> rootMenu = menuDao.getAllMenu();
        // 查看结果
        for (MenuEntity menu : rootMenu) {
            System.out.println(menu);
        }

        // 最后的结果
        List<MenuEntity> menuList = new ArrayList<MenuEntity>();
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            if (StringUtils.isBlank(rootMenu.get(i).getParentId())) {
                menuList.add(rootMenu.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuEntity menu : menuList) {
            menu.setChildMenu(getChild(menu.getMenuId(), rootMenu));
        }
        System.out.println(menuList.toString());

    }

    public List<MenuEntity> getChild(String id, List<MenuEntity> rootMenu) {
        // 子菜单
        List<MenuEntity> childList = new ArrayList<>();
        for (MenuEntity menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(menu.getParentId())) {
                if (menu.getParentId().equals(id)) {
                    childList.add(menu);
                }
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (MenuEntity menu : childList) {// 没有url子菜单还有子菜单
            if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(menu.getMenuId()) ){
                // 递归
                menu.setChildMenu(getChild(menu.getMenuId(), rootMenu));
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;

    }




}
