package makyu.nga.http;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class RequestQueueSingleton {

    private static RequestQueueSingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private RequestQueueSingleton(Context ctx) {
        mRequestQueue = Volley.newRequestQueue(ctx);
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            //如果没有重写sizeOf maxSize为缓存个数
            final int maxMemory = (int) Runtime.getRuntime().maxMemory();
            final int cacheSize = maxMemory / 8;
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(cacheSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getByteCount();
                }
            };
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }

            @Override
            public Bitmap getBitmap(String arg0) {
                return cache.get(arg0);
            }
        });
    }

    public static RequestQueueSingleton get() {
        if (mInstance == null) {
            throw new IllegalArgumentException("you must init first");
        }
        return mInstance;
    }

    public static void init(Context context) {
        synchronized (RequestQueueSingleton.class) {
            if (mInstance == null) {
                mInstance = new RequestQueueSingleton(context);
            }
        }
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public <T> void add(Request<T> req) {
        mRequestQueue.add(req);
    }

    public void cancelAll() {
        mRequestQueue.cancelAll(this);
    }

}
