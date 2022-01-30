package com.example.tpo_training_and_placement.models;

public class AddPlacementOpportunityModel {

    String CompanyName;

    public AddPlacementOpportunityModel() {
    }

    public AddPlacementOpportunityModel(String companyName) {
        this.CompanyName = companyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }
}
