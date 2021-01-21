package com.gzl.model.controller;


import com.gzl.model.entity.RoleEntity;
import com.gzl.model.service.IRoleService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author gzl
 * @since 2020-11-27
 */
@Api(tags = "角色服务")
@RequestMapping("role")
@RestController
public class RoleController {

    @Resource
    private IRoleService roleService;
    @ApiOperation("查询")
    @PostMapping("getRoleById")
    public RoleEntity getRoleById(String roleId) {
        return roleService.getRoleById(roleId);
    }

}
