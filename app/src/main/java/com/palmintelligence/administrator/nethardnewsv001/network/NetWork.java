package com.palmintelligence.administrator.nethardnewsv001.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/10 0010.
 */
public class NetWork {

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static JUHEAPI juheapi;

    public static JUHEAPI getJUHEAPI(){

        if (juheapi == null) {
            juheapi = getRetrofit(Api.BASE_API_JUHE).create(JUHEAPI.class);
        }
        return juheapi;
    }

    private static Retrofit getRetrofit(String baseUrl) {

        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.i("LogUtils--> ", "request:" + request.toString());
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Log.i("LogUtils--> ", "response body:" + content);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }


        }
    }
}