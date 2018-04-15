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
        String test_1 = "纸杯戚风蛋糕 彩虹轻乳酪蛋糕";
        String test_2 = "香辣带鱼 灵芝炖老鸭 土豆干锅片";
        String test_3 = "蒜蓉金针菇 糖醋里脊 咖喱鸡肉";
        String test_4 = "香煎豆腐 糯米丸子 红烧牛肉豆腐";
        String test_5 = "熊掌豆腐 清炒莴笋丝";
        map.put(0, test_1);
        map.put(1, test_2);
        map.put(2, test_3);
        map.put(3, test_4);
        map.put(4, test_5);
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
        map.remove(item);
        return t;
    }

}
