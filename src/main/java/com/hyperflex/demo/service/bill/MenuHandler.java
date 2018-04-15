package com.hyperflex.demo.service.bill;


import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

/**
 *
 * @author Gavin
 * @date 2018/2/27
 */
public interface MenuHandler {
    TaskResult execute(TaskQuery taskQuery);
}
