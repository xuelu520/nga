package makyu.nga.http;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;

/**
 * Created by bb on 16/5/24.
 */
public class HttpCenter {
    public static void httpTest(String url, OnHttpResponseListener listener) {
        HttpHelper.get(url, listener);
    }

    public interface OnHttpResponseListener {
        void onResponse(JSONObject response);
        void onErrorResponse(VolleyError error);
    }
}
