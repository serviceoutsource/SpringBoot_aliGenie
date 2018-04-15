package com.hyperflex.demo.service.bill;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

/**
 *
 * @author Gavin
 * @date 2018/3/1
 */
public interface FoodRecommendHandler {
    TaskResult execute(TaskQuery taskQuery);
}
