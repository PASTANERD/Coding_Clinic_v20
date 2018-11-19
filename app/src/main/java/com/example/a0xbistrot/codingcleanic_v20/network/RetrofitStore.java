package com.example.a0xbistrot.codingcleanic_v20.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitStore {

    private static final String GithubAPI = "https://api.github.com";

    private static Retrofit retrofit;

    public synchronized static Retrofit get() {
        if (retrofit != null) return retrofit;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)   // Client <-> API 간에 커뮤니케이션에서 log 정보를 수집함
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        retrofit = new Retrofit.Builder() // Retrofit 객체 생성
                .client(client)
                .baseUrl(GithubAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }
}
