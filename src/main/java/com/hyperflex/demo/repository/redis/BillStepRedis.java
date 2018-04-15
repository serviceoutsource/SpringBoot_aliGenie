package com.hyperflex.demo.repository.redis;

import com.hyperflex.demo.model.BillSteps;

/**
 * @author chuntaojun
 */
public interface BillStepRedis {

    /**
     *
     * @param oldAccessToken
     * @return
     */
    BillSteps queryUserBillStepInfo(String oldAccessToken);

    /**
     *
     * @param billSteps
     */
    void saveUserBillStepInfo(BillSteps billSteps);

    /**
     *
     * @param oldAccessToken
     */
    void deleteUserBillStepInfo(String oldAccessToken);

}
