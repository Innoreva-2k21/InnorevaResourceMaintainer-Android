package com.example.innorevaresourcemanager.ui.HomeModule.models;

public class BannerDataModel {
    String title, url;

    public BannerDataModel(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public BannerDataModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
