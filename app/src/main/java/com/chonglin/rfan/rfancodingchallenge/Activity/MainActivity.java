package com.chonglin.rfan.rfancodingchallenge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chonglin.rfan.rfancodingchallenge.Model.Pictures;
import com.chonglin.rfan.rfancodingchallenge.R;
import com.chonglin.rfan.rfancodingchallenge.Services.ImageGallery500pxAPI;
import com.chonglin.rfan.rfancodingchallenge.Services.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String consumerKey = "nezVvBqd7GKQt2jfYogFFEmTzjVD8U2CPumXSsfS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageGallery500pxAPI galleryService = ServiceGenerator.createService(ImageGallery500pxAPI.class);
        Call<Pictures> call = galleryService.getPhotos(consumerKey);
        call.enqueue(new Callback<Pictures>() {
            @Override
            public void onResponse(Call<Pictures> call,Response<Pictures> response) {
                if (response.isSuccessful()) {
                    System.out.println("successful " + response.toString());
                } else {
                    System.out.println("received response but error " + response.headers());
                }
            }

            @Override
            public void onFailure(Call<Pictures> call,Throwable t) {
                System.out.println("complete failure");
            }
        });

    }
}
