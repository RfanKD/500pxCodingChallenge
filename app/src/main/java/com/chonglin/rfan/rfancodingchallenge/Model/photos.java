package com.chonglin.rfan.rfancodingchallenge.Model;

/**
 * Created by Rfan on 27/11/2016.
 */

public class Photos {

    public int id;
    public String name;
    public String image_url;
    public User user ;

    public String getImageUrl (){
        return this.image_url;
    }



}
