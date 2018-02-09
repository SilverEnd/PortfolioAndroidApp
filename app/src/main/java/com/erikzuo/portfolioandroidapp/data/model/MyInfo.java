package com.erikzuo.portfolioandroidapp.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

/**
 * Created by Soprano on 6/02/2018.
 */

public class MyInfo {
    private String name;
    private String email;
    private String title;
    private String avatarUrl;

    public MyInfo() {}

    public MyInfo(String name, String email, String title, String avatarUrl) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
