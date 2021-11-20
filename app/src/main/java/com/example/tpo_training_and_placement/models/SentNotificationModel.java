package com.example.tpo_training_and_placement.models;

import android.util.Log;

public class SentNotificationModel {

    private String dateString;
    private String noticeString;

    public SentNotificationModel() {
    }

    public SentNotificationModel(String dateString, String noticeString) {
        this.dateString = dateString;
        this.noticeString = noticeString;
    }

    public String getDateString() {

        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getNoticeString() {
        return noticeString;
    }

    public void setNoticeString(String noticeString) {
        this.noticeString = noticeString;
    }
}

