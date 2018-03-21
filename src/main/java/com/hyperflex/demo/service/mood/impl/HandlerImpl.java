package com.hyperflex.demo.service.mood.impl;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.mood.Handler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chuntaojun
 */
@Component
public class HandlerImpl implements Handler {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        TaskResult result = new TaskResult();
        System.out.println(taskQuery.toString());
        Map<String, String> paramMap = taskQuery
                .getSlotEntities()
                .stream()
                .collect(Collectors
                        .toMap(SlotEntity::getIntentParameterName, SlotEntity::getStandardValue));
        result.setReply("我，还，不，能，回，答，去，找，你，妈，妈，安，慰");
        result.setExecuteCode(ExecuteCode.SUCCESS);
        result.setResultType(ResultType.RESULT);
        return result;
    }
}
