package com.gzl.model.common.util;

import com.gzl.model.entity.MenuEntity;
import com.gzl.model.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 16:35 2021/1/14
 * @Modified By:
 */
public class ThreadQuery implements Callable<List> {

    @Autowired
    IMenuService iMenuService;

    private int offset;//当前页数
    private int size;//每页查询多少条
    private List<MenuEntity> page;//每次分页查出来的数据

    public ThreadQuery(int offset, int size) {
        this.offset=offset;
        this.size=size;
    }
    @Override
    public List<MenuEntity> call() throws Exception {
        //通过service查询得到对应结果
        List<MenuEntity>  list  =new ArrayList<>(); //myService.queryBySex(sex,bindex,num);
        //调用分页查询的接口
        list=iMenuService.findByPage(offset,size);
        return list;
    }
}
