package com.gzl.model.service.impl;


import com.gzl.model.dao.IRoleDao;
import com.gzl.model.entity.RoleEntity;
import com.gzl.model.service.IRoleService;
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
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;


    @Override
    public RoleEntity getRoleById(String roleId){
        return  roleDao.getRoleById(roleId);
    }

}
