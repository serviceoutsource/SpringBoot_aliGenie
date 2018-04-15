package com.hyperflex.demo.service.bill;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

/**
 * @author chuntaojun
 */
public interface FoodAdviceHandler {

    /**
     *
     * @param taskQuery
     * @return
     */
    TaskResult execute(TaskQuery taskQuery);

}
