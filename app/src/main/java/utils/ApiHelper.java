package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import bilibili.demoforbilibili.BaseApplication;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ly on 2017/2/19.
 */

public class ApiHelper {
    private static OkHttpClient okHttpClient;

    static {
        initOkHttp();
    }

    private static  void initOkHttp(){
        if (okHttpClient == null) {
                synchronized (ApiHelper.class) {
                    if (okHttpClient == null) {
                        Cache cache = new Cache(new File(BaseApplication.getInstance().getCacheDir(), "httpCache"), 1024 * 1024 * 10);
                        okHttpClient = new OkHttpClient.Builder()
                                .cache(cache)
                                .addNetworkInterceptor(new CacheInterceptor())
                                .connectTimeout(30, TimeUnit.SECONDS)
                                .readTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(30, TimeUnit.SECONDS)
                                .build();
                    }
                }
                }
    }

    public static <T> T createApi(Class<T> cls, String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(cls);
    }




    private static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (CommonUtils.isNetWorkAvialable(BaseApplication.getInstance())) {
                //有网络时只从网络获取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            } else {
                //无网络时只从缓存中读取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (CommonUtils.isNetWorkAvialable(BaseApplication.getInstance())) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }

    }
}
