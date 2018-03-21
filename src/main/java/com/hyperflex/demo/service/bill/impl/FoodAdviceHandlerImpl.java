package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.FoodAdviceHandler;
import com.hyperflex.demo.service.bill.SendDataToPY;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuntaojun
 */
@Component
@Service("FoodAdviceHandler")
public class FoodAdviceHandlerImpl implements FoodAdviceHandler {

    private static final String START_STRING = "要不要试一试";

    @Qualifier("GetRecommend")
    @Autowired
    private SendDataToPY sendDataToPY;

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        return ExcuteAdaper.execute(taskQuery, testAnswer());
    }

    /**
     * query 改为对应的sql操作
     *
     * @param accessToken
     * @return
     */
    private String setReply(String accessToken) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("isNewUser", (accessToken).toString());
        paramMap.put("accessToken", accessToken);
        return sendDataToPY.ConnectPY(paramMap);
    }

    /**
     *
     * @return
     */
    protected String testAnswer() {
        String[] test = new String[]{"纸杯戚风蛋糕",
                "荔枝烩虾仁",
                "彩虹轻乳酪蛋糕",
                "香辣带鱼",
                "灵芝炖老鸭",
                "红枣蜂蜜戚风"};
        return test[(int) (Math.random() * test.length)];
    }

}
