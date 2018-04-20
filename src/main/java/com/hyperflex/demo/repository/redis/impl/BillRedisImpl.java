package com.hyperflex.demo.repository.redis.impl;

import com.hyperflex.demo.model.BillSteps;
import com.hyperflex.demo.repository.redis.BillRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("BillRedis")
public class BillRedisImpl implements BillRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String queryUserBillName(String sessionId) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(sessionId);
    }

    @Override
    public void saveUserBillName(String foodName, String sessionId) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(sessionId, foodName);
    }

    @Override
    public BillSteps queryUserBillStepInfo(String sessionId) {
        ValueOperations<String, BillSteps> operations = redisTemplate.opsForValue();
        BillSteps billSteps = operations.get(sessionId);
        if (billSteps == null) {
            return new BillSteps(sessionId, "test");
        }
        billSteps.setOldAccessToken(sessionId);
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
     * @param sessionId
     */
    @Override
    public void deleteUserBillStepInfo(String sessionId) {
        redisTemplate.delete(sessionId);
    }

}
