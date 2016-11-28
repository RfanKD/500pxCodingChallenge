package com.chonglin.rfan.rfancodingchallenge.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chonglin.rfan.rfancodingchallenge.Model.Photos;
import com.chonglin.rfan.rfancodingchallenge.R;

import java.util.List;

/**
 * Created by Rfan on 28/11/2016.
 */

public class MyImageAdapter extends RecyclerView.Adapter<MyImageAdapter.MyViewHolder>{

    private List<Photos> images;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public MyImageAdapter(Context context, List<Photos> images) {
        mContext = context;
        this.images = images;
    }

    @Override
    public MyImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_thumbnail, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyImageAdapter.MyViewHolder holder, int position) {
        Photos image = images.get(position);

        Glide.with(mContext).load(image.getImageUrl())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
