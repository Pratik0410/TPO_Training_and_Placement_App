package com.example.tpo_training_and_placement.models;

public class StudentNotificationCardModel {
    private String Name;
    private String Branch;

    public StudentNotificationCardModel() {
    }

    public StudentNotificationCardModel(String name, String branch) {
        this.Name = name;
        this.Branch = branch;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
