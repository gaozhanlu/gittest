package com.gzl.model.dao;


import com.gzl.model.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Mapper
public interface IRoleMenuDao {

    public RoleMenuEntity getRoleMenuById(String roleId);



}
