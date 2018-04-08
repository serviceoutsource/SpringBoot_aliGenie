package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.FoodAdviceHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("FoodAdviceHandler")
public class FoodAdviceHandlerImpl implements FoodAdviceHandler {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        return ExcuteAdaper.execute(taskQuery, testAnswer());
    }

    private String testAnswer() {
        return "可以放一些蚝油";
    }
}
