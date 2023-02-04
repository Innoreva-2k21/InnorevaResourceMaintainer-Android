package com.example.innorevaresourcemanager.ui.HomeModule.models;

public class EventModel {
    String id, imageUrl, title, description, venue, startDate, endDate, time, registrationLink;

    public EventModel() {
    }

    public EventModel(String id, String imageUrl, String title, String description, String venue, String startDate, String endDate, String time, String registrationLink) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.venue = venue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.registrationLink = registrationLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }
}
