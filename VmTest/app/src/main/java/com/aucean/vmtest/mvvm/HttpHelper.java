package com.aucean.vmtest.mvvm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jie on 2017/3/31.
 */

public class HttpHelper
{
    public static final String TAG = "OkHttpManger";
    private static final String BASE_URL = "http://www.gelonghui.com/";
    private static OkHttpClient okHttpClient;
    private static HttpHelper httpHelper = new HttpHelper();
    private static IHttpServer iHttpServer;
    private HttpHelper() {

        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException
                {

                    Request.Builder builder = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json;charset=utf-8")
                            .addHeader("Accept-Encoding", "gzip")
                            .addHeader("Connection", "keep-alive")
                            .addHeader("FromApp", "true")
                            .addHeader("platform", "android");

                    Response response = chain.proceed(builder.build());
                    return response;
                }
            });

        okHttpClient = builder.build();
        Retrofit rxRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();
        iHttpServer = rxRetrofit.create(IHttpServer.class);
    }

    public static HttpHelper getInstance() {

        return httpHelper ;
    }

    public OkHttpClient getOkHttpClient()
    {
        return okHttpClient;
    }

    public static IHttpServer getServer() {
        return iHttpServer;
    }
}
