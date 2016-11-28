package com.chonglin.rfan.rfancodingchallenge.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chonglin.rfan.rfancodingchallenge.Adapter.MyImageAdapter;
import com.chonglin.rfan.rfancodingchallenge.Model.Photos;
import com.chonglin.rfan.rfancodingchallenge.Model.Pictures;
import com.chonglin.rfan.rfancodingchallenge.R;
import com.chonglin.rfan.rfancodingchallenge.Services.ImageGallery500pxAPI;
import com.chonglin.rfan.rfancodingchallenge.Services.ServiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String consumerKey = "Y74D8h5g0w8ndi5mQInYhDZoIDyqYn5U7acltQ8Q";
    private final int numberOfPhoto = 36;
    private ArrayList<Photos> images;
    private ProgressDialog pDialog;
    private MyImageAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ImageGallery500pxAPI galleryService = ServiceGenerator.createService(ImageGallery500pxAPI.class);
        Call<Pictures> calls = galleryService.getPhotos(consumerKey,numberOfPhoto);
        System.out.println("full url now is " + calls.request().url());
        calls.enqueue(new Callback<Pictures>() {
            @Override
            public void onResponse(Call<Pictures> call,Response<Pictures> response) {
                if (response.isSuccessful()) {
                    System.out.println("successful " + response.raw().toString());
                    Pictures pictures = response.body();
                    System.out.println("successful code " + pictures.total_items);
                    images = new ArrayList<>(Arrays.asList(pictures.photos));
                    System.out.println("image size:  " + images.size());
                    mAdapter = new MyImageAdapter(getApplicationContext(), images);

                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);

                } else {
                    System.out.println("received response but error " + response.headers());

                }
            }

            @Override
            public void onFailure(Call<Pictures> call,Throwable t) {
                System.out.println("complete failure");
                System.out.println("complete failure " + t.getMessage());
            }
        });
    }
}
