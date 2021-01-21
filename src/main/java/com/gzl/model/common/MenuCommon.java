package com.gzl.model.common;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gzl.model.entity.MenuEntity;


import java.util.ArrayList;
import java.util.List;

public class MenuCommon {

    public List<MenuEntity> getChild(String id, List<MenuEntity> rootMenu) {
        // 子菜单
        List<MenuEntity> childList = new ArrayList<>();
        for (MenuEntity menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(menu.getParentId())) {
                if (menu.getParentId().equals(id)) {
                    childList.add(menu);
                }
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (MenuEntity menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getMenuId()) ){
                // 递归
                menu.setChildMenu(getChild(menu.getMenuId(), rootMenu));
            }
        } // 递归退出条件

        if (childList.size() == 0) {
            return null;
        }

        return childList;

    }
}
