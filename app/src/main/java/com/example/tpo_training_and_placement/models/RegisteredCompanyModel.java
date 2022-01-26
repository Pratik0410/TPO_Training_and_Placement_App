package com.example.tpo_training_and_placement.models;

public class RegisteredCompanyModel {

    private String CompanyName;

    public RegisteredCompanyModel() {
    }


    public RegisteredCompanyModel(String companyName) {
        this.CompanyName = companyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }
}
