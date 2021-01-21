package com.gzl.model.service.impl;

import com.gzl.model.common.util.ThreadQuery;
import com.gzl.model.entity.MenuEntity;
import com.gzl.model.service.ITheardQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 16:40 2021/1/14
 * @Modified By:
 */
@Service
public class TheardQueryService implements ITheardQueryService {
    @Override
    public List getMaxResult() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();//开始时间
        List<List> result = new ArrayList<>();//返回结果
        //查询数据库总数量
        int count =12;//sqlHadle.count(table);
        int size =2;//一次查询多少条
        //需要查询的次数
        int times = count / size;
        if (count % size != 0) {
            times = times + 1;
        }
        //开始页数  连接的是orcle的数据库  封装的分页方式  我的是从1开始
        int offset = 0;
        //Callable用于产生结果
        List<Callable<List>> tasks = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            offset = i*size;
            Callable<List> qfe = new ThreadQuery(offset,size);  //这个是啥玩意
            tasks.add(qfe);
        }
        //定义固定长度的线程池  防止线程过多
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //Future用于获取结果
        List<Future<List>> futures=executorService.invokeAll(tasks);
        //处理线程返回结果
        System.out.println(futures.toString());

        if(futures!=null&&futures.size()>0){
            for (Future<List> future:futures){
                result.addAll(future.get());
            }
        }
        executorService.shutdown();//关闭线程池
        long end = System.currentTimeMillis();
        System.out.println("线程查询数据用时:"+(end-start)+"ms");
        return result;

    }
}


