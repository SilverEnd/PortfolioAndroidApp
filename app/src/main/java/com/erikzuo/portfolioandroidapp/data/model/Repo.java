package com.erikzuo.portfolioandroidapp.data.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.security.acl.Owner;

/**
 * Created by Soprano on 7/02/2018.
 */

public class Repo {
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("description")
    private String description;

    @SerializedName("html_url")
    private String link;

    public Repo(int id, String name, String fullName, String description, String link) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.link = link;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
