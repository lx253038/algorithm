package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: lixin
 * @date: 2022/1/6 5:33 ÏÂÎç
 * @description:
 */
public class Test {


    public static void main(String[] args) {
        String paramValue = "{\n" +
                "    \"data\": {\n" +
                "        \"get_company_tags\": {\n" +
                "            \"calculatedTags\": [\n" +
                "                {\n" +
                "                    \"tid\": \"T000164\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"tid\": \"T000254\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"tid\": \"T000255\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"tid\": \"T000163\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(paramValue);

        List<JSONObject> jsonObjectList = JSONArray.parseArray(jsonObject.getJSONObject("data").getJSONObject("get_company_tags").getString("calculatedTags"), JSONObject.class);
    }
}
