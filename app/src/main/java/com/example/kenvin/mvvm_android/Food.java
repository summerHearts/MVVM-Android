package com.example.kenvin.mvvm_android;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Kenvin on 2017/11/10.
 */

public class Food extends BaseObservable {

    private  String img;
    private  String description;
    private  String keywords;

    public Food(String img, String description, String keywords) {
        this.img = img;
        this.description = description;
        this.keywords = keywords;
    }

    @BindingAdapter("img")
    public static void getHeaderImage(ImageView headerImageView, String url){
        Picasso.with(headerImageView.getContext()).load(url).resize(50, 50).centerCrop().into(headerImageView);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
