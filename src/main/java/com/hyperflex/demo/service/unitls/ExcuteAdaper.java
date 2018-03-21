package com.hyperflex.demo.service.unitls;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

import java.util.Map;
import java.util.stream.Collectors;

public class ExcuteAdaper {

    public static TaskResult execute(TaskQuery taskQuery, String reply) {
        TaskResult result = new TaskResult();
        Map<String, String> paramMap = taskQuery
                .getSlotEntities()
                .stream()
                .collect(Collectors
                        .toMap(SlotEntity::getIntentParameterName, SlotEntity::getStandardValue));
        result.setReply(reply);
        result.setExecuteCode(ExecuteCode.SUCCESS);
        result.setResultType(ResultType.RESULT);
        return result;
    }

}
