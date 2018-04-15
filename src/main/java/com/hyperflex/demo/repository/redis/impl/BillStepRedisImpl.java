package com.hyperflex.demo.repository.redis.impl;

import com.hyperflex.demo.model.BillSteps;
import com.hyperflex.demo.repository.redis.BillStepRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("BillStepRedis")
public class BillStepRedisImpl implements BillStepRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public BillSteps queryUserBillStepInfo(String oldAccessToken) {
        ValueOperations<String, BillSteps> operations = redisTemplate.opsForValue();
        BillSteps billSteps = operations.get(oldAccessToken);
        if (billSteps == null) {
            return new BillSteps(oldAccessToken, "test");
        }
        billSteps.setOldAccessToken(oldAccessToken);
        return billSteps;
    }

    /**
     *
     * @param billSteps
     */
    @Override
    public void saveUserBillStepInfo(BillSteps billSteps) {
        deleteUserBillStepInfo(billSteps.getOldAccessToken());
        redisTemplate.opsForValue().set(billSteps.getNewAccessToken(), billSteps);
    }

    /**
     *
     * @param accessToken
     */
    @Override
    public void deleteUserBillStepInfo(String accessToken) {
        redisTemplate.delete(accessToken);
    }

}
