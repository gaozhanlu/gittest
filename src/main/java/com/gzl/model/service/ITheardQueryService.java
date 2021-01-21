package com.gzl.model.service;

import com.gzl.model.entity.MenuEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Author: gaozhanlu
 * @Date: Created in 16:49 2021/1/14
 * @Modified By:
 */
public interface ITheardQueryService {
    List getMaxResult() throws InterruptedException, ExecutionException;
}
