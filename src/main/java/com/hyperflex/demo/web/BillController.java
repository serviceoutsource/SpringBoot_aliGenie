package com.hyperflex.demo.web;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import com.hyperflex.demo.service.bill.BillStepRemHandler;
import com.hyperflex.demo.service.bill.FoodAdviceHandler;
import com.hyperflex.demo.service.bill.MenuHandler;
import com.hyperflex.demo.service.bill.OrderFunHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author chuntaojun
 */
@Controller
@RequestMapping(value = "/aliGenie")
public class BillController {

    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    @Qualifier("MenuHandler")
    @Autowired
    private MenuHandler menuHandler;

    @Qualifier("FoodAdviceHandler")
    @Autowired
    private FoodAdviceHandler foodAdviceHandler;

    @Qualifier("BillStepRemember")
    @Autowired
    private BillStepRemHandler billStepRemHandler;

    @Qualifier("OrderFun")
    @Autowired
    private OrderFunHandler orderFunHandler;

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/order_bill", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> OrderBillResponse(String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(menuHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/recommend_bill", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> RecommendBillResponse(String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery.toString());
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(foodAdviceHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/bill_step", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> BillStepResponse(String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery.toString());
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(billStepRemHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

    @RequestMapping(value = "/order_fun", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> OrderFunResponse(String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery.toString());
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(orderFunHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

}
