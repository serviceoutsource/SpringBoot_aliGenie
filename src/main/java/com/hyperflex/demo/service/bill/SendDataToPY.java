package com.hyperflex.demo.service.bill;

import java.util.Map;

/**
 * @author chuntaojun
 */
public interface SendDataToPY {

    /**
     *
     * @param paramMap
     * @return
     */
    String ConnectPY(Map<String, String> paramMap);

}
