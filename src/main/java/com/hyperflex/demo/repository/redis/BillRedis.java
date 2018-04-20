package com.hyperflex.demo.repository.redis;

import com.hyperflex.demo.model.BillSteps;

/**
 * @author chuntaojun
 */
public interface BillRedis {

    /**
     *
     * @param sessionId
     * @return
     */
    String queryUserBillName(String sessionId);

    /**
     *
     * @param foodName
     * @param sessionId
     */
    void saveUserBillName(String foodName, String sessionId);

    /**
     *
     * @param sessionId
     * @return
     */
    BillSteps queryUserBillStepInfo(String sessionId);

    /**
     *
     * @param billSteps
     */
    void saveUserBillStepInfo(BillSteps billSteps);

    /**
     *
     * @param sessionId
     */
    void deleteUserBillStepInfo(String sessionId);

}
