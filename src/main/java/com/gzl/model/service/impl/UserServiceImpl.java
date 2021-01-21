package com.gzl.model.service.impl;
import com.gzl.model.dao.IUserDao;
import com.gzl.model.entity.UserEntity;
import com.gzl.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao IUserDao;
    @Override
    public List<UserEntity> getAll(Map map) {
        return IUserDao.getAll(map);
    }

    @Override
    public void delById(String userId) {

        IUserDao.delById(userId);
    }

    @Override
    public void save(UserEntity userEntity) {

        IUserDao.save(userEntity);
    }

    @Override
    public UserEntity getUserById(String userId) {

        return IUserDao.getUserById(userId);
    }

    @Override
    public void updateUserById(UserEntity userEntity) {

        IUserDao.updateUserById(userEntity);
    }
}
