package com.gzl.model.dao;


import com.gzl.model.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Mapper
public interface IUserRoleDao {
    public UserRoleEntity getUserRoleById(String userId);

}
