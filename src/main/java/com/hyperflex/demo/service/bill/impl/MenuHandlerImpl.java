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
        return null;
    }

}
