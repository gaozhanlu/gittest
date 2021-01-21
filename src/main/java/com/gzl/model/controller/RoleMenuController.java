package com.gzl.model.controller;


import com.gzl.model.entity.RoleMenuEntity;
import com.gzl.model.service.IRoleMenuService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzl
 * @since 2020-11-27
 */
@Api(tags = "角色菜单服务",description = "用户表操作接口")
@RequestMapping(value = "rolemenu")
@RestController
public class RoleMenuController {

    @Resource
    private IRoleMenuService roleMenuService;
    @ApiOperation("查询")
    @PostMapping("getRoleMenuById")
    public RoleMenuEntity getRoleMenuById(String roleId) {
        return roleMenuService.getRoleMenuById(roleId);

    }





}
