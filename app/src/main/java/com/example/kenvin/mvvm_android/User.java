package com.example.kenvin.mvvm_android;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Kenvin on 2017/11/10.
 */

public class User extends BaseObservable{

    private String name;

    private  String password;

    private  String headerImageUrl;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        notifyPropertyChanged(BR.name);
        this.name = name;
    }

    public void setPassword(String password) {
        notifyPropertyChanged(BR.password);
        this.password = password;
    }

    @BindingAdapter("headerImageUrl")
    public static void getHeaderImage(ImageView headerImageView, String url){
        Picasso.with(headerImageView.getContext()).load(url).into(headerImageView);
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public User(String name, String password ,String headerImageUrl) {
        this.name = name;
        this.password = password;
        this.headerImageUrl = headerImageUrl;
    }
}
