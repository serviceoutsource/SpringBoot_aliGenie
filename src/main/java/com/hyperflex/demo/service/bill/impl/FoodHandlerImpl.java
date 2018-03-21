package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.FoodHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("FoodHandler")
public class FoodHandlerImpl implements FoodHandler {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        return null;
    }
}
