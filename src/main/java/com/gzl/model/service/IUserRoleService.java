package com.gzl.model.service;

import com.gzl.model.entity.UserRoleEntity;

/**
 * @author gzl
 * @since 2020-11-28
 */
public interface IUserRoleService{

    public UserRoleEntity getUserRoleById(String userId);
}
