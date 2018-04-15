package com.hyperflex.demo.service.mood.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.mood.MoodLightHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("MoodLightHandler")
public class MoodLightHandlerImpl implements MoodLightHandler {

    /**
     *
     * @param taskQuery
     * @return
     */
    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        return ExcuteAdaper.execute(taskQuery, test(taskQuery));
    }

    private String test(TaskQuery taskQuery) {
        return null;
    }
}
