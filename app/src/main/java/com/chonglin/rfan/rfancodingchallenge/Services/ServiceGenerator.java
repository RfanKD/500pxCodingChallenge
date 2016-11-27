package com.chonglin.rfan.rfancodingchallenge.Services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rfan on 27/11/2016.
 */

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.500px.com/v1" ;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    //public static <S> S createService (Class <S> serviceClass){
    //    Retrofit retrofit = builder.client(httpClient).build();
    //    return retrofit.create(serviceClass);
    //}


}