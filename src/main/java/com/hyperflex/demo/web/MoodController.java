package com.hyperflex.demo.web;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import com.hyperflex.demo.service.mood.MoodLightHandler;
import com.hyperflex.demo.service.mood.MoodMusicHandler;
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
public class MoodController {

    @Qualifier("MoodMusicHandler")
    @Autowired
    private MoodMusicHandler moodMusicHandler;

    @Qualifier("MoodLightHandler")
    @Autowired
    private MoodLightHandler moodLightHandler;

    /**
     *
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/smart_light", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> MoodAnalyzeSmartLight(@RequestBody String taskQuery) {
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);
        ResultModel<TaskResult> resultModel = new ResultModel<>();
        try {
            TaskResult result = moodMusicHandler.execute(query);
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(result);
            System.out.println(result.toString());
        } catch (Exception e) {
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
    @RequestMapping(value = "/smart_music", method = RequestMethod.POST)
    public @ResponseBody ResultModel<TaskResult> MoodAnalyzeSmartMusic(@RequestBody String taskQuery) {
        return null;
    }

}
