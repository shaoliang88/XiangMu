package com.example.lenovo.xiangmu.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/3/29.
 */

public class RetrofitHelp {
    private static OkHttpClient okHttpClient;
    private static APIService apiService;
    static {
        initOkhttp();
    }
    private static OkHttpClient initOkhttp() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelp.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder().build();
                }
            }
        }
        return okHttpClient;
    }
    public static APIService getAPI(){
        if (apiService==null){
            synchronized (RetrofitHelp.class){
                if (apiService==null){
                    apiService=RetrofitHelp.CreateURL(APIService.class,API.URL);
                }
            }
        }
        return apiService;
    }
    public static <T>T CreateURL(Class<T> t,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(t);
    }

}
