package com.example.tpo_training_and_placement.models;

public class EditPlacementOpportunityModel {
    private String CompanyName, Role, Location, Summary, KeyQualification, JobDescription, AdditionalRequirements, LinkForApplying, CompanyLogo;

    public EditPlacementOpportunityModel() {
    }



    public EditPlacementOpportunityModel(String companyName, String role, String location, String summary, String keyQualification, String jobDescription, String additionalRequirements, String linkForApplying, String companyLogo) {
        this.CompanyName = companyName;
        this.Role = role;
        this.Location = location;
        this.Summary = summary;
        this.KeyQualification = keyQualification;
        this.JobDescription = jobDescription;
        this.AdditionalRequirements = additionalRequirements;
        this.LinkForApplying = linkForApplying;
        this.CompanyLogo = companyLogo;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getKeyQualification() {
        return KeyQualification;
    }

    public void setKeyQualification(String keyQualification) {
        KeyQualification = keyQualification;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public String getAdditionalRequirements() {
        return AdditionalRequirements;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        AdditionalRequirements = additionalRequirements;
    }

    public String getLinkForApplying() {
        return LinkForApplying;
    }

    public void setLinkForApplying(String linkForApplying) {
        LinkForApplying = linkForApplying;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        CompanyLogo = companyLogo;
    }
}
