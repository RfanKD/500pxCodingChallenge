package com.chonglin.rfan.rfancodingchallenge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chonglin.rfan.rfancodingchallenge.Model.Pictures;
import com.chonglin.rfan.rfancodingchallenge.R;
import com.chonglin.rfan.rfancodingchallenge.Services.ImageGallery500pxAPI;

import java.io.IOException;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageGallery500pxAPI galleryService = ImageGallery500pxAPI.retrofit.create (ImageGallery500pxAPI.class);
        Call<Pictures> call = galleryService.getPhotos();
        try {
            Pictures result = call.execute().body();

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("here instead");
        }

    }
}
