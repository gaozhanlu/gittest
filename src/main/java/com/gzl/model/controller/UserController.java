package com.gzl.model.controller;

import com.gzl.model.entity.UserEntity;
import com.gzl.model.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


/**
 * RestController=@ResponseBody+@Controller
 */
@Controller
@RequestMapping("user")
@Api(tags = "用户服务",value="用户表",description = "用户表操作接口")

public class UserController {

    @Autowired
    IUserService userService;

    //获取所有用户
    @ResponseBody
    @RequestMapping(path="/getAll",method=RequestMethod.GET)
    @ApiOperation(value = "获取用户列表",notes = "这是获取所有用户的方法")
    public List<UserEntity> getAll(Map map){
        return userService.getAll(map);
    }

    //删除用户
    @RequestMapping(value="/delById", method=RequestMethod.GET)
    @ApiOperation(value = "删除用户")
    public String delById(String userId){
        userService.delById(userId);
        return "success";//重定向功能
    }
    //保存用户
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存用户")
    public String save(@RequestBody UserEntity userEntity){
        System.out.println("用户注册"+userEntity.toString());
        userService.save(userEntity);
        return "success";
    }
    //根据id查询用户信息
    @RequestMapping(value = "/getUserById",method= {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "查询用户")
    public UserEntity getUserById(String userId){

        return  userService.getUserById(userId);
    }

    //根据id修改用户信息
    @RequestMapping(value = "/updateUserById",method =RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改用户")
    public String updateUserById(@RequestBody UserEntity userEntity){
       userService.updateUserById(userEntity);
        return "success";

    }

}
