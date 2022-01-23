package com.example.tpo_training_and_placement.models;

public class PrePlacementModel {
    private String CompanyName;
    private String Details;
    private String Link;

    public PrePlacementModel() {
    }

    public PrePlacementModel(String companyName, String details, String link) {
        this.CompanyName = companyName;
        this.Details = details;
        this.Link = link;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        this.Link = link;
    }
}
