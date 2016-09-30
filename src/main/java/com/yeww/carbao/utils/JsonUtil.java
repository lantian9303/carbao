package com.yeww.carbao.utils;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class JsonUtil {


    public static Map<String, Object> toMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            return mapper.readValue(jsonString, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * root/sub/sub/nodekey
     *
     * @param jsonMap
     * @param url
     * @return
     */
    public static Object getNodeValue(Map<String, Object> jsonMap, String url) {
        if (jsonMap == null || jsonMap.size() == 0 || StringUtil.isEmpty(url)) {
            return null;
        }
        Object value = null;
        Map tem = jsonMap;
        String[] nodes = url.split("/");
        for (int i = 0; i < nodes.length; i++) {
            if (i == nodes.length - 1) {
                return tem.get(nodes[i]);
            } else {
                tem = (Map) tem.get(nodes[i]);
            }
        }
        return value;
    }
}
