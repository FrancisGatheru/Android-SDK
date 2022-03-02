package com.example.myapplication.Network;

import static com.example.myapplication.Model.Constants.BASE_URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckoutClient {

    //make all checkout HTTP calls
    public static Retrofit postRequestPayload() {
        //log different levels of requests per HTTP call
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    //main driver method for API client
    public static CheckoutApi initCheckoutApi() {
        return postRequestPayload().create(CheckoutApi.class);
    }
}
