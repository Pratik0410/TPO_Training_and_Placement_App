package com.example.tpo_training_and_placement.models;

public class AddPlacementOpportunityModel {

    String CompanyName, CompanyLogo;

    public AddPlacementOpportunityModel() {
    }


    public AddPlacementOpportunityModel(String companyName, String companyLogo) {
        CompanyName = companyName;
        CompanyLogo = companyLogo;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompany_Logo(String companyLogo) {
        CompanyLogo = companyLogo;
    }
}
