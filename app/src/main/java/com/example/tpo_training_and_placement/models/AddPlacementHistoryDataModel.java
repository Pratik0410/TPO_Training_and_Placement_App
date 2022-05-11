package com.example.tpo_training_and_placement.models;

public class AddPlacementHistoryDataModel {
    String StudentName, StudentImage, Branch;

    public AddPlacementHistoryDataModel() {
    }

    public AddPlacementHistoryDataModel(String studentName, String studentImage, String branch) {
        StudentName = studentName;
        StudentImage = studentImage;
        Branch = branch;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentImage() {
        return StudentImage;
    }

    public void setStudentImage(String studentImage) {
        StudentImage = studentImage;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
