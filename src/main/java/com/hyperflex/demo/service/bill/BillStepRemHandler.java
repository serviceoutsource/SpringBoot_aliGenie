package com.hyperflex.demo.service.bill;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.model.BillSteps;

/**
 * @author chuntaojun
 */
public interface BillStepRemHandler {

    /**
     *
     * @param taskQuery
     * @return
     */
    TaskResult execute(TaskQuery taskQuery);

    /**
     *
     * @param foodName
     * @return
     */
    BillSteps getBillFare(String foodName);

    /**
     *
     * @param oldAccessToken
     * @param newAccessToken
     * @return
     */
    BillSteps updateBillStepInfo(String oldAccessToken, String newAccessToken);

}
