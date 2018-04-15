package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.BillStepRemHandler;
import com.hyperflex.demo.service.bill.MenuHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chuntaojun
 */
@Component
@Service("MenuHandler")
public class MenuHandlerImpl implements MenuHandler {

    @Qualifier("BillStepRemember")
    @Autowired
    private BillStepRemHandler billStepRemHandler;

    /**
     *
     * @param taskQuery
     * @return
     */
    @Override
    public TaskResult execute(TaskQuery taskQuery){
        return ExcuteAdaper.execute(taskQuery, testAnswer(""));
    }

    /**
     * 返回当前步骤，需要利用redis来维持accessToken与steps的关系
     * @param
     * foodName 从mongodb中获取菜谱信息
     * @param
     * oldAccessToken 用户信息追踪
     * @param
     * newAccessToken
     * @return
     */
    private String getBillStep(String foodName, String oldAccessToken, String newAccessToken) {
        if (StringUtils.isNullOrEmpty(foodName)) {
            return billStepRemHandler.getBillFare(foodName).getNowStep();
        } else {
            return billStepRemHandler.updateBillStepInfo(oldAccessToken, newAccessToken).getNowStep();
        }
    }

    /**
     *
     * @return
     */
    protected String testAnswer(String foodName) {
        HashMap<String, List<String>> steps = new HashMap<>();
//        steps.put("纸杯戚风蛋糕", Arrays.asList(new String[]{"倒入玉米油，用手动打蛋器搅拌均匀，一定要使油完全融入进去。",
//                "倒入纸杯，烤箱预热160度，中层，上下火烤约30分钟。",
//                "先将三分之一蛋白倒入蛋黄糊中，切拌均匀，然后再将所有的蛋黄糊一起倒入蛋白中，切拌均匀。",
//                "加入牛奶搅拌均匀。",
//                "搅拌均匀入置一边。",
//                "筛入低粉。",
//                "蛋白分三次加入50g的糖粉，用电动打蛋器打发至干性发泡。",
//                "蛋黄加入40g糖粉搅拌均匀，一定要把糖完全融化掉。"}));
//        steps.put("荔枝烩虾仁", Arrays.asList(new String[]{
//                "预备芡汁，适量的调味鸡汁、鱼露、生粉和清水拌匀。",
//                "虾仁洗净，放入少许食盐腌制一会。",
//                "将荔枝洗净，去壳。",
//                "热油锅。",
//                "放入虾仁。",
//                "煸炒至虾仁变色，放入荔枝。",
//                "倒入芡汁，煸炒收汁，即可关火上碟。"}));
//        return steps.get("荔枝烩虾仁").get(0);
        return "那么是外卖呢还是亲自下厨呢";
    }

}
