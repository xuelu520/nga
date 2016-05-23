package makyu.nga.constant;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by bb on 16/5/23.
 */
public class HttpConstant {
    private static HttpConstant mInstance;
    private OkHttpClient mOkHttpClient;

    /**
     * 构造方法
     */
    private HttpConstant() {
        mOkHttpClient = new OkHttpClient();
        //设置cookie可用
        mOkHttpClient.setCookieHandler(new CookieManager(
                null,
                CookiePolicy.ACCEPT_ORIGINAL_SERVER));

    }

    /**
     * 获取 HttpConstant 实例
     * @return HttpConstant mInstance
     */
    private static HttpConstant getInstance() {
        if(mInstance == null) {
            synchronized (HttpConstant.class) {
                if(mInstance == null) {
                    mInstance = new HttpConstant();
                }
            }
        }
        return mInstance;
    }

    /**
     * 同步 GET 请求,返回 Response 类型数据
     * @param url String
     * @return Response
     * @throws IOException
     */
    private Response _get(String url) throws IOException {
        final Request request = new Request.Builder().url(url).build();
        Response execute = mOkHttpClient.newCall(request).execute();
        return execute;
    }

    /**
     * 同步 GET 请求,返回字符串
     * @param url String
     * @return string
     * @throws IOException
     */
    private String _getAsString(String url) throws IOException {
        return _get(url).body().string();
    }

    /**
     * 对外 GET 请求,返回 Response 类型数据
     * @param url String
     * @return Response
     * @throws IOException
     */
    public static Response get(String url) throws IOException {
        return getInstance()._get(url);
    }

    /**
     * 对外 GET 请求,返回字符串
     * @param url String
     * @return String
     * @throws IOException
     */
    public static String getAsString(String url) throws IOException {
        return getInstance()._getAsString(url);
    }
}
