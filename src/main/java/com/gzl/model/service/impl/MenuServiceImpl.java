package com.gzl.model.service.impl;


import com.gzl.model.common.util.RedisUtil;
import com.gzl.model.dao.IMenuDao;
import com.gzl.model.entity.MenuEntity;
import com.gzl.model.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2020-11-28
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuDao ImenuDao;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public MenuEntity getMenuById(String menuId) {
        return ImenuDao.getMenuById(menuId);
    }

    @Override
    public List<MenuEntity> getMenuByParentId(String parentId) {
        List<MenuEntity> menu=new ArrayList<>();
        menu=ImenuDao.getMenuByParentId(parentId);
        redisUtil.set(parentId,menu.toArray());
        return menu;
    }

    @Override
    public List<MenuEntity> findByPage(int offset, int size) {
        return ImenuDao.findByPage(offset,size);
    }


}
