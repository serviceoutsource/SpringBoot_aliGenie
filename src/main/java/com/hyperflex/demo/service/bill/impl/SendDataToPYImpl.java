package com.hyperflex.demo.service.bill.impl;

import com.hyperflex.demo.service.bill.SendDataToPY;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author chuntaojun
 */
@Component
@Service("GetRecommend")
public class SendDataToPYImpl implements SendDataToPY {

    private static final String ERROR_MSG = "推进服务器出现了一些问题";
    private static final String RECOMMEND_URL = "http://115.159.3.213:8000/hyperflex/recipe_recommended";

    /**
     *
     * @param paramMap
     * @return
     */
    @Override
    public String ConnectPY(Map<String, String> paramMap) {
        try {
            URL realUrl = new URL(RECOMMEND_URL);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.connect();
            connection.setDoOutput(true);
            postDataToPY(connection, paramMap);
            return getRecommendResult(connection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ERROR_MSG;
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR_MSG;
        }
    }

    /**
     *
     * @param connection
     * @param paramMap
     * @throws IOException
     */
    private void postDataToPY(HttpURLConnection connection, Map<String, String> paramMap) throws IOException {
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print('&');
        for(Map.Entry<String, String> paris : paramMap.entrySet()){
            String name=paris.getKey().toString();
            String value=paris.getValue().toString();
            out.print(name);
            out.print('=');
            out.print(URLEncoder.encode(value,"UTF-8"));
        }
    }

    /**
     *
     * @param connection
     * @return
     * @throws IOException
     */
    private String getRecommendResult(HttpURLConnection connection) throws IOException {
        StringBuffer context = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String tempLine;
        while ((tempLine = br.readLine()) != null) {
            context.append(tempLine);
        }
        return context.toString();
    }

}
