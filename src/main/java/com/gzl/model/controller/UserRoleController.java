package com.gzl.model.controller;


import com.gzl.model.entity.UserRoleEntity;
import com.gzl.model.service.IUserRoleService;
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
@Api(tags = "用户角色服务")
@RequestMapping("userrole")
@RestController

public class UserRoleController {

    @Resource
    private IUserRoleService userRoleService;


    @ApiOperation("查询")
    @PostMapping("/getUserRoleById")
    public UserRoleEntity getUserRoleById(String userId) {
        return userRoleService.getUserRoleById(userId);
    }

}
