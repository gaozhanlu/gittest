package com.gzl.model.service.impl;

import com.gzl.model.dao.IRoleMenuDao;
import com.gzl.model.entity.RoleMenuEntity;
import com.gzl.model.service.IRoleMenuService;
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
public class RoleMenuServiceImpl  implements IRoleMenuService {

    @Autowired
    IRoleMenuDao roleMenuDao;

    @Override
    public RoleMenuEntity getRoleMenuById(String roleId){

        return  roleMenuDao.getRoleMenuById(roleId);
    }
}
