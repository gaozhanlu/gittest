package com.gzl.model.dao;

import com.gzl.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IUserDao {

   /* @Select(select * form user where id="";)*/
    List<UserEntity> getAll(@Param("content") Map map);

   /* @Select()*/
    void delById(String userId);

    //保存用户
   /* @Insert()*/
    public void save(UserEntity userEntity);


    //根据id查询用户数据
    public UserEntity getUserById(String userId);

    public void updateUserById(UserEntity userEntity);
}
