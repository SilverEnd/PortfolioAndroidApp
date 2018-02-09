package com.erikzuo.portfolioandroidapp.data.model;

/**
 * Created by Soprano on 9/02/2018.
 */

public class Education {
    private String name;
    private String degree;
    private String major;
    private long from;
    private long to;

    public Education() {
    }

    public Education(String name, String degree, String major, long from, long to) {
        this.name = name;
        this.degree = degree;
        this.major = major;
        this.from = from;
        this.to = to;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }
}
