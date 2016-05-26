package makyu.nga.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 * Created by -(^_^)- on 2016/5/25.
 */
public class StringUtil {
    private static final String TAG = StringUtil.class.getSimpleName();
    public static final String  NGA_START = "get_var_store=";
    public static final int  NGA_START_INDEX = 14;


    /**
     * TODO
     * NGA接口返回的是gbk编码字符串，这里需要转成utf8
     * 由于转成utf8还是会乱码，就转成GBK不会乱码，方法名就不变
     * @param response String gbk
     * @return utf8字符串
     */
    private static String gbk2utf8(String response) {
        try {
            return new String(response.getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * NGA接口返回的 jsonp 字符串 转换为 JSON对象
     * 内部对象可以用 getJSONObject(String key)
     * @param jsonp String NGA接口返回的jsonp数据
     * @return jsonObject JSONObject
     */
    public static JSONObject jsonp2json(String jsonp) {
        JSONObject jsonObject = null;
        jsonp = gbk2utf8(jsonp);
        if(!jsonp.equals("")) {
            String dataString = jsonp.substring(jsonp.indexOf(NGA_START) + NGA_START_INDEX);
            try {
                jsonObject = (JSONObject) JSONArray.parse(dataString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}
