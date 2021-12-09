package com.example.tpo_training_and_placement.models;

public class SentNotificationModel {

    private String Date;
    private String Notice;

    public SentNotificationModel() {
    }

    public SentNotificationModel(String dateString, String noticeString) {
        this.Date = dateString;
        this.Notice = noticeString;
    }

    public String getDate() {

        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        this.Notice = notice;
    }
}

