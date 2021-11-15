package com.example.tpo_training_and_placement.models;

import android.widget.Button;

public class StudentRequestModel {

    String name, email, mobileNumber, branch;
    Button acceptButton, denyButton;

    public StudentRequestModel() {
    }

    public StudentRequestModel(String name, String email, String mobileNumber, String branch,
                               Button acceptButton, Button denyButton) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.branch = branch;
        this.acceptButton = acceptButton;
        this.denyButton = denyButton;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getBranch() {
        return branch;
    }

    public Button getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(Button acceptButton) {
        this.acceptButton = acceptButton;
    }

    public Button getDenyButton() {
        return denyButton;
    }

    public void setDenyButton(Button denyButton) {
        this.denyButton = denyButton;
    }
}
