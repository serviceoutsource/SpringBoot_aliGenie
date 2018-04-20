package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.model.LabelDO;
import com.hyperflex.demo.repository.mysql.LabelMapper;
import com.hyperflex.demo.service.bill.UserInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chuntaojun
 */
@Component
@Service("UserInfoHandler")
public class UserInfoHandlerImpl implements UserInfoHandler {

    @Autowired
    private LabelMapper labelMapper;

    private static final String[] ANSWERS = {"好的 说下你的口味吧", "好的 我收到了 还有吗", "", "", ""};
    private static Integer LABELS = 0;
    private static LabelDO labelDO;

    static {
        labelDO = new LabelDO();
    }

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        TaskResult result = new TaskResult();
        Map<String, String> paramMap = taskQuery
                .getSlotEntities()
                .stream()
                .collect(Collectors
                        .toMap(SlotEntity::getIntentParameterName, SlotEntity::getStandardValue));
        result.setReply(inforCollect(paramMap, ""));
        result.setExecuteCode(ExecuteCode.SUCCESS);
        result.setResultType(ResultType.RESULT);
        return result;
    }

    private String inforCollect(Map<String, String> paramMap, String accessToken) {
        if (LABELS == 4) {
            LABELS = 0;
            labelMapper.insert(labelDO);
            return ANSWERS[5];
        }
        if (LABELS == 0) {
            labelDO.setUser_id(accessToken);
            labelDO.setTaste_label(paramMap.get(""));
            LABELS += 1;
        }
        return ANSWERS[LABELS];
    }

}
