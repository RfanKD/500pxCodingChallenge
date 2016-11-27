package com.chonglin.rfan.rfancodingchallenge.Services;

import com.chonglin.rfan.rfancodingchallenge.Model.Pictures;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Rfan on 27/11/2016.
 */

public interface ImageGallery500pxAPI {

    String API_BASE_URL = "https://api.500px.com/v1" ;

    @GET("/photos")
    Call<Pictures> getPhotos();

    Retrofit retrofit =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

}
