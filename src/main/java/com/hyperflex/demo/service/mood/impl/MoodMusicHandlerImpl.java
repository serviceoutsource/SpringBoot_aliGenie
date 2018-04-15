package com.hyperflex.demo.service.mood.impl;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.mood.MoodMusicHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chuntaojun
 */
@Component
@Service("MoodMusicHandler")
public class MoodMusicHandlerImpl implements MoodMusicHandler {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        TaskResult result = new TaskResult();
        System.out.println(taskQuery.toString());
        Map<String, String> paramMap = taskQuery
                .getSlotEntities()
                .stream()
                .collect(Collectors
                        .toMap(SlotEntity::getIntentParameterName, SlotEntity::getStandardValue));
        result.setReply("好的 为您播放舒伯特小夜曲");
        result.setExecuteCode(ExecuteCode.SUCCESS);
        result.setResultType(ResultType.RESULT);
        return result;
    }
}
