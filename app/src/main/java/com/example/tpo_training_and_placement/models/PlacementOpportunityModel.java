package com.example.tpo_training_and_placement.models;

public class PlacementOpportunityModel {

    String CompanyName;

    public PlacementOpportunityModel() {
    }

    public PlacementOpportunityModel(String companyName) {
        this.CompanyName = companyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }
}
