package com.hyperflex.demo.service.bill.impl;

import com.alibaba.da.coin.ide.spi.meta.SlotEntity;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.hyperflex.demo.service.bill.OrderFunHandler;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import com.hyperflex.demo.service.unitls.OrderFunEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return ExcuteAdaper.execute(taskQuery, choseOrderType(taskQuery));
    }

    public String choseOrderType(TaskQuery taskQuery) {
        Map<String, Object> taskMap = OrderType(taskQuery.getSlotEntities());
        if (taskMap.get("order_type").equals(OrderFunEnum.ORDER_TYPE_2)) {
            return "那我就开始报菜谱咯食材有虾仁食盐生粉橄榄油鱼露荔枝";
        }
        else {
            return "好的这就为您下单预计在半小时后到达";
        }
    }

    private Map<String, Object> OrderType(List<SlotEntity> slotEntities) {
        Map<String, Object> resultMap = new HashMap<>();
        SlotEntity slotEntity;
        boolean b_1, b_2;
        slotEntity = slotEntities.get(0);
        b_1 = (slotEntity != null);
        b_2 = (OrderFunEnum.TAKE_OUT.equals(slotEntity.getOriginalValue()) || OrderFunEnum.TAKE_OUT.equals(slotEntity.getOriginalValue()));
        if (b_1 && b_2) {
            resultMap.put("order_type", OrderFunEnum.ORDER_TYPE_1);
        }
        else {
            resultMap.put("order_type", OrderFunEnum.ORDER_TYPE_2);
        }
        return resultMap;
    }
}
