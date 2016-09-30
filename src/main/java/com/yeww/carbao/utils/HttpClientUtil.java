package com.yeww.carbao.utils;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/7.
 */
public class HttpClientUtil {

    private static final Logger Logs = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String get(final String url, Map<String, Object> paramMap) {
        if (url == null || url.trim().equals("") || CollectionUtils.isEmpty(paramMap)) {
            return null;
        }
        HttpClient client = new HttpClient();
        StringBuilder sb = new StringBuilder();
        InputStream ins = null;
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        List<NameValuePair> queryParamsList = new ArrayList<NameValuePair>(paramMap.size());
        NameValuePair[] arr = new NameValuePair[paramMap.size()];
        try {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                NameValuePair pair = new NameValuePair();
                pair.setName(entry.getKey());
                pair.setValue(entry.getValue().toString());
                queryParamsList.add(pair);
            }
            for (int i = 0; i < paramMap.size(); i++) {
                arr[i] = queryParamsList.get(i);
            }
            method.setQueryString(arr);
            int statusCode = client.executeMethod(method);
            if (statusCode == HttpStatus.SC_OK) {
                ins = method.getResponseBodyAsStream();
                byte[] b = new byte[1024];
                int r_len = 0;
                while ((r_len = ins.read(b)) > 0) {
                    sb.append(new String(b, 0, r_len, method
                            .getResponseCharSet()));
                }
            } else {
                Logs.info("Response Code: " + statusCode);
            }
            Logs.info("Response msg: " + sb.toString());
            return sb.toString();
        } catch (IOException e) {
            Logs.error("http请求失败", e);
        } finally {
            method.releaseConnection();
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    Logs.error("关闭连接失败", e);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("key", "96a0da853364603cfb54f30f572cbe79");
        paramMap.put("cityname", "南京");
        HttpClientUtil.get("http://op.juhe.cn/onebox/weather/query", paramMap);
    }
}
