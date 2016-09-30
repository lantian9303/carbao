package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.domain.enums.SmsTemplateEnum;
import com.yeww.carbao.service.common.ISmsService;
import com.yeww.carbao.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


/**
 * Created by yeweiwei1 on 2016/9/7.
 */
@Service
public class SmsServiceImpl implements ISmsService {

    @Value("${sms_url}")
    private String sms_url;

    @Value("${sms_apikey}")
    private String sms_apikey;

    @Value("${sms_tag}")
    private String sms_tag;

    public String sendSns(String mobile, SmsTemplateEnum smsTemplateEnum, List<String> list) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String httpArg = null;
        String content = smsTemplateEnum.getTemplate();
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 1; i <= list.size(); i++) {
                System.out.println(content=content.replace("{" + i + "}", list.get(i - 1)));
            }
        }
        try {
            httpArg = "mobile=" + mobile + "&tag=" + sms_tag + "&content=" + URLEncoder.encode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String httpUrl = sms_url + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", sms_apikey);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            String returnstatus = (String) JsonUtil.toMap(result).get("returnstatus");
            if ("Success".equals(returnstatus)) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
