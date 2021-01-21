package com.gzl.model.service.impl;


import com.gzl.model.dao.IUserRoleDao;
import com.gzl.model.entity.UserRoleEntity;
import com.gzl.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    IUserRoleDao userRoleDao;
    @Override
    public UserRoleEntity getUserRoleById(String userId){
        return userRoleDao.getUserRoleById(userId);
    }
}
