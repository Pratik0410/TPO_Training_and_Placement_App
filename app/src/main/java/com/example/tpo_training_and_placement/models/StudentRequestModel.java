package com.example.tpo_training_and_placement.models;

import android.widget.Button;

public class StudentRequestModel {

    String StudentName, Email, PhoneNumber, Branch, Password, ConfirmPassword, StudentImage;
    Button acceptButton, denyButton;

    public StudentRequestModel() {
    }

    public StudentRequestModel(String name, String email, String phoneNumber, String branch, String password, String confirmPassword, String studentImage, Button acceptButton, Button denyButton) {
        StudentImage = studentImage;
        StudentName = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Branch = branch;
        Password = password;
        ConfirmPassword = confirmPassword;
        this.acceptButton = acceptButton;
        this.denyButton = denyButton;
    }

    public String getStudentImage() {
        return StudentImage;
    }

    public void setStudentImage(String studentImage) {
        StudentImage = studentImage;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
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
