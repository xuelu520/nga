package makyu.nga.utils;

import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 * Created by -(^_^)- on 2016/5/25.
 */
public class StringUtil {

    /**
     * TODO
     * NGA接口返回的是gbk编码字符串，这里需要转成utf8
     * 由于转成utf8还是会乱码，就转成GBK不会乱码，方法名就不变
     * @param response String gbk
     * @return utf8字符串
     */
    public static String gbk2utf8(String response) {
        try {
            return new String(response.getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
