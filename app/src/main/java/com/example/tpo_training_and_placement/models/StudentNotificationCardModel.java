package com.example.tpo_training_and_placement.models;

public class StudentNotificationCardModel {

    private String StudentName, Branch;

    public StudentNotificationCardModel() {
    }

    public StudentNotificationCardModel(String studentName, String branch) {
        StudentName = studentName;
        Branch = branch;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

}
