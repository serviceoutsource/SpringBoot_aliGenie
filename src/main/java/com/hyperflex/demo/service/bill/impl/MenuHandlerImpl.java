package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.repository.redis.BillRedis;
import com.hyperflex.demo.service.bill.BillStepRemHandler;
import com.hyperflex.demo.service.bill.MenuHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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

    @Qualifier("BillRedis")
    @Autowired
    private BillRedis billRedis;

    /**
     *
     * @param taskQuery
     * @return
     */
    @Override
    public TaskResult execute(TaskQuery taskQuery, HttpSession session){
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        return ExcuteAdaper.execute(taskQuery, getFoodName(slotEntities, session.getId()));
    }


    /**
     *
     * @return
     */
    protected String getFoodName(List<SlotEntity> slotEntities, String sessionId) {
        String foodName = slotEntities.get(0).getOriginalValue();
        billRedis.saveUserBillName(foodName, sessionId);
        return "那么是外卖呢还是亲自下厨呢";
    }

}
