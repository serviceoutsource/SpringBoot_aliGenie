package com.hyperflex.demo.web;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import com.hyperflex.demo.service.bill.UserInfoHandler;
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
public class UserInfoController {

    @Qualifier("UserInfoHandler")
    @Autowired
    private UserInfoHandler userInfoHandler;

    @RequestMapping(value = {"/user_label", "/user_info"}, method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> UserLabelResponse(String taskQuery) {
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        try {
            TaskResult result = userInfoHandler.execute(MetaFormat.parseToQuery(taskQuery));
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(result);
        } catch (Exception e) {
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

}
