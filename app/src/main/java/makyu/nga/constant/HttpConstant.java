package makyu.nga.constant;

import com.squareup.okhttp.OkHttpClient;

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
}
