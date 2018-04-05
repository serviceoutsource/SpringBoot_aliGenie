package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.OrderFunHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import com.hyperflex.demo.service.unitls.OrderFunEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chuntaojun
 */
@Component
@Service("OrderFun")
public class OrderFunHandlerImpl implements OrderFunHandler {

    /**
     *
     * @param taskQuery
     * @return
     */
    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        return ExcuteAdaper.execute(taskQuery, testAnswer(taskQuery));
    }

    public String testAnswer(TaskQuery taskQuery) {
        if (taskQuery.getSlotEntities().get(0).getSlotValue().equalsIgnoreCase(OrderFunEnum.ORDER_TYPE_2) ||
                taskQuery.getSlotEntities().get(1).getSlotValue().equalsIgnoreCase(OrderFunEnum.ORDER_TYPE_2)) {
            return "那我就开始报菜谱咯:食材有：清水、虾仁、食盐、生粉、橄榄油、鱼露、荔枝";
        }
        else {
            return "好的，这就为您下单，预计在半小时后到达";
        }
    }
}
