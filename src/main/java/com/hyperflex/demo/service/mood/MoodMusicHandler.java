package com.hyperflex.demo.service.mood;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

/**
 * @author chuntaojun
 */
public interface MoodMusicHandler {

    /**
     *
     * @param taskQuery
     * @return
     */
    TaskResult execute(TaskQuery taskQuery);

}
