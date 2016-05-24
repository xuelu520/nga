package makyu.nga.http;

import com.android.volley.VolleyError;

/**
 * Created by bb on 16/5/24.
 */
public class HttpCenter {
    public static void httpTest(String url, OnHttpResponseListener listener) {
        HttpHelper.get(url, listener);
    }

    public interface OnHttpResponseListener {
        void onResponse(String response);
        void onErrorResponse(VolleyError error);
    }
}
