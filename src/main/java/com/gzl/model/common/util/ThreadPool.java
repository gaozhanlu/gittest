package com.gzl.model.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 16:30 2021/1/15
 * @Modified By:
 */
public class ThreadPool {
    public static void main(String[] args){
        //提供指定线程数量
        ExecutorService service= Executors.newFixedThreadPool(10);
        //设置线程池的属性
        System.out.println(service.getClass());
        service.execute(new NumberThread()); //适合适用于Runnable接口
        //service.submit();//适合适用于callable接口
        service.execute(new NumberThread1());
        service.shutdown();

    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i%2==0){
                System.out.println("线程1"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i%2==0){
                System.out.println("线程2"+i);
            }
        }
    }
}
