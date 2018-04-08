package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.model.BillSteps;
import com.hyperflex.demo.repository.mongo.FoodBookMongo;
import com.hyperflex.demo.repository.redis.BillStepRedis;
import com.hyperflex.demo.service.bill.BillStepRemHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
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
@Service("BillStepRemember")
public class BillStepRemHandlerImpl implements BillStepRemHandler {

    private static Integer STEPS = 0;

    private static final String ACCESSTOKEN = "";

    @Qualifier(value = "BillStepRedis")
    @Autowired
    private BillStepRedis billStepRedis;

    @Qualifier("FoodBookMongo")
    @Autowired
    private FoodBookMongo foodBookMongo;

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        return ExcuteAdaper.execute(taskQuery, getSteps(slotEntities.get(0).getOriginalValue(), slotEntities.get(0).getOriginalValue()));
    }

    /**
     *
     * @param foodName
     * @return
     */
    @Override
    public BillSteps getBillFare(String foodName) {
        BillSteps billSteps = new BillSteps();
        List<String> steps = foodBookMongo.queryBillFare(foodName).getBillSteps();
        billSteps.setBillStepLists(steps);
        billSteps.setPreStep("");
        billSteps.setNowStep(steps.get(0));
        billSteps.setAftStep(steps.get(1));
        billSteps.setAfter(1);
        return billSteps;
    }

    /**
     *
     * @param oldAccessToken
     * @param newAccessToken
     * @return
     */
    @Override
    public BillSteps updateBillStepInfo(String oldAccessToken, String newAccessToken) {
        BillSteps billSteps = billStepRedis.queryUserBillStepInfo(oldAccessToken);
        billSteps.setOldAccessToken(oldAccessToken);billSteps.setNewAccessToken(newAccessToken);
        billSteps.setPreStep(billSteps.getBillStepLists().get(billSteps.getAfter() - 1));
        billSteps.setNowStep((billSteps.getBillStepLists().get(billSteps.getAfter())));
        billSteps.setAftStep(billSteps.getBillStepLists().get(billSteps.getAfter() + 1));
        billSteps.setAfter(billSteps.getAfter() + 1);
        billStepRedis.saveUserBillStepInfo(billSteps);
        return billSteps;
    }

    protected String getSteps(String foodName, String slotValue) {
        System.out.println(foodName + ", " + slotValue);
        return testAnswer(foodName, 1);
    }

    /**
     *
     * @return
     */
    protected String testAnswer(String foodName, Integer soltValue) {
        HashMap<String, List<String>> steps = new HashMap<>();
        steps.put("纸杯戚风蛋糕", Arrays.asList(new String[]{
                "倒入玉米油，用手动打蛋器搅拌均匀，一定要使油完全融入进去。",
                "倒入纸杯，烤箱预热160度，中层，上下火烤约30分钟。",
                "先将三分之一蛋白倒入蛋黄糊中，切拌均匀，然后再将所有的蛋黄糊一起倒入蛋白中，切拌均匀。",
                "加入牛奶搅拌均匀。",
                "搅拌均匀入置一边。",
                "筛入低粉。",
                "蛋白分三次加入50g的糖粉，用电动打蛋器打发至干性发泡。",
                "蛋黄加入40g糖粉搅拌均匀，一定要把糖完全融化掉。"}));
        steps.put("荔枝烩虾仁", Arrays.asList(new String[]{
                "预备芡汁适量的调味鸡汁鱼露生粉和清水拌匀",
                "虾仁洗净，放入少许食盐腌制一会。",
                "将荔枝洗净，去壳。",
                "热油锅。",
                "放入虾仁。",
                "煸炒至虾仁变色，放入荔枝。",
                "倒入芡汁，煸炒收汁，即可关火上碟。"}));
        String a =  steps.get("荔枝烩虾仁").get(STEPS);
        STEPS += 1;
        return a;
    }
}
