package com.gzl.model.common.util;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 16:53 2021/1/15
 * @Modified By:
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        ExecutorService service= Executors.newFixedThreadPool(100);
        ArrayList<Callable<Object>> list=new ArrayList<Callable<Object>>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return null;
                }
            });
        }
        service.invokeAll(list);
        System.out.println("可以汇总计算了！");
        service.shutdown();
    }
}
