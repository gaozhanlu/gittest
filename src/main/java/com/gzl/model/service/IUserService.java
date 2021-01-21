package com.gzl.model.service;

import com.gzl.model.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<UserEntity> getAll(Map map);

    void delById(String userId);

    //保存用户
    public void save(UserEntity userEntity);

    //根据id查询用户数据
    public UserEntity getUserById(String userId);

    //根据id修改用户数据
    public void updateUserById(@RequestBody UserEntity userEntity);
}
