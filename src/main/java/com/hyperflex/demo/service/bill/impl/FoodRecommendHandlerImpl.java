package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.FoodRecommendHandler;
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
@Service("FoodRecommendHandler")
public class FoodRecommendHandlerImpl implements FoodRecommendHandler {

    private static final String START_STRING = "要不要试一试";
    private static HashMap<Integer, String> map = new HashMap<>();


    @Qualifier("GetRecommend")
    @Autowired
    private SendDataToPY sendDataToPY;

    static {
        String test_1 = "芦荟炒虾仁 或者 素菜水饺";
        String test_2 = "香辣带鱼 或者 灵芝炖老鸭 或者 土豆干锅片";
        String test_3 = "蒜蓉金针菇 或者 糖醋里脊 或者 咖喱鸡肉";
        String test_4 = "香煎豆腐 或者 糯米丸子 或者 红烧牛肉豆腐";
        String test_5 = "熊掌豆腐 或者 清炒莴笋丝";
        String test_6 = "荔枝烩虾仁 或者 红烧茄子 或者 纸杯戚风蛋糕";
        map.put(0, test_1);
        map.put(1, test_2);
        map.put(2, test_3);
        map.put(3, test_4);
        map.put(4, test_5);
        map.put(5, test_6);
    }

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
        int item = (int)(Math.random() * map.size());
        String t = map.get(item);
        return t;
    }

}
