package com.hyperflex.demo.web;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import com.hyperflex.demo.service.bill.*;
import com.hyperflex.demo.service.unitls.ExcuteAdaper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Qualifier("FoodRecommendHandler")
    @Autowired
    private FoodRecommendHandler foodRecommendHandler;

    @Qualifier("BillStepRemember")
    @Autowired
    private BillStepRemHandler billStepRemHandler;

    @Qualifier("OrderFun")
    @Autowired
    private OrderFunHandler orderFunHandler;

    @Qualifier("FoodAdviceHandler")
    @Autowired
    private FoodAdviceHandler foodAdviceHandler;

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/order_bill", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> OrderBillResponse(@RequestBody String taskQuery) {
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
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/recommend_bill", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> RecommendBillResponse(@RequestBody String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(foodRecommendHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/bill_step", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> BillStepResponse(@RequestBody String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(billStepRemHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/order_fun", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> OrderFunResponse(@RequestBody String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(orderFunHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

    @RequestMapping(value = "/cook_ask", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> CookAskResponse(@RequestBody String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(foodAdviceHandler.execute(MetaFormat.parseToQuery(taskQuery)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

    @RequestMapping(value = "/food_metrial_recommend", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody ResultModel<TaskResult> FoodMaterialResponse(@RequestBody String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        logger.info("TaskQuery:{}", taskQuery);
        try {
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(ExcuteAdaper.execute(MetaFormat.parseToQuery(taskQuery), "小依推荐您尝试下 小鸡炖蘑菇 白切鸡 或者 黄焖鸡"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        logger.info("resultModel:{}", resultModel.getReturnCode() + "," + resultModel.getReturnErrorSolution() + "," +
                resultModel.getReturnMessage() + "," + resultModel.getReturnValue().toString());
        return resultModel;
    }

}
