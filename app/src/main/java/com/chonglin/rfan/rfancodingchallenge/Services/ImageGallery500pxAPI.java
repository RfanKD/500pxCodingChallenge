package com.chonglin.rfan.rfancodingchallenge.Services;

import com.chonglin.rfan.rfancodingchallenge.Model.Pictures;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Rfan on 27/11/2016.
 */

public interface ImageGallery500pxAPI {

    @GET("/v1/photos")
    Call<Pictures> getPhotos(
            @Query("consumer_key") String code,
            @Query("page") int pageNumber );

    @POST("/token")
    Call<AccessToken> getAccessToken(
            @Field("oauth_consumer_key") String code);

}
