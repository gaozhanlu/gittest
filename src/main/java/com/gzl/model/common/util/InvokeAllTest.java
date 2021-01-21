package com.gzl.model.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 17:09 2021/1/15
 * @Modified By:
 */
public class InvokeAllTest {
    public static void main(String[] args) throws Exception {
        List<Callable<Integer>> tasks = new ArrayList<>();
        for( int i = 0; i < 10; i++) {
            tasks.add(()->{
                Random random = new Random();
                int second = random.nextInt(10);
                Thread.sleep(second * 1000) ;
                return second;
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        for( int i = 0; i < futures.size(); i++) {
            System.out.println(futures.get(i).get());
        }
        executorService.shutdown();
    }
}