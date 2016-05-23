package makyu.nga.constant;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bb on 16/5/23.
 */
public class HttpConstant{
    RequestQueue mQueue;
    public static final String TAG = "HttpConstant";

    //帖子列表
    public String TieziUrl = "http://bbs.nga.cn/thread.php?fid=335&lite=js";
    //帖子回复列表
    public String replyUrl = "http://bbs.nga.cn/read.php?tid=6726209&lite=js";

    public HttpConstant(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    /**
     * volley 发送 GET请求
     * @param url String 请求地址
     */
    public void get(String url) {
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                });
        mQueue.add(stringRequest);
    }

    /**
     * volley 发送简单 POST(非上传)请求
     * @param url String 请求地址
     * @param params HashMap<String, String> POST 数据
     */
    public void post(String url, final HashMap<String, String> params) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "response -> " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        mQueue.add(stringRequest);
    }
}
