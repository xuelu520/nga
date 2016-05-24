package makyu.nga.http;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bb on 16/5/24.
 * 底层干活的类,不应该暴露出去
 */
class HttpHelper {
    private static final String TAG = HttpHelper.class.getSimpleName();

    public static void get(String url, final HttpCenter.OnHttpResponseListener listener) {
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        if (listener != null) {
                            listener.onResponse(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                        if (listener != null) {
                            listener.onErrorResponse(error);
                        }
                    }
                });
        RequestQueueSingleton.get().add(stringRequest);
    }

    /**
     * volley 发送简单 POST(非上传)请求
     * @param url String 请求地址
     * @param params HashMap<String, String> POST 数据
     */
    public static void post(String url, final HashMap<String, String> params, final HttpCenter.OnHttpResponseListener listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "response -> " + response);
                        if (listener != null) {
                            listener.onResponse(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                        if (listener != null) {
                            listener.onErrorResponse(error);
                        }
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            
        };
        RequestQueueSingleton.get().add(stringRequest);
    }
}
