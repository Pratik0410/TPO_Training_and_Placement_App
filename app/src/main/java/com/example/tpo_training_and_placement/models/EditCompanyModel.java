package com.example.tpo_training_and_placement.models;

public class EditCompanyModel {
    String CompanyName, TypeofCompany, ProductorServiceofCompany, AboutCompany, ContactDetails, CompanyLogo;

    public EditCompanyModel() {
    }

    public EditCompanyModel(String companyName, String typeofCompany, String productorServiceofCompany, String aboutCompany, String contactDetails, String companyLogo) {
        CompanyName = companyName;
        TypeofCompany = typeofCompany;
        ProductorServiceofCompany = productorServiceofCompany;
        AboutCompany = aboutCompany;
        ContactDetails = contactDetails;
        CompanyLogo = companyLogo;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getTypeofCompany() {
        return TypeofCompany;
    }

    public void setTypeofCompany(String typeofCompany) {
        TypeofCompany = typeofCompany;
    }

    public String getProductorServiceofCompany() {
        return ProductorServiceofCompany;
    }

    public void setProductorServiceofCompany(String productorServiceofCompany) {
        ProductorServiceofCompany = productorServiceofCompany;
    }

    public String getAboutCompany() {
        return AboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        AboutCompany = aboutCompany;
    }

    public String getContactDetails() {
        return ContactDetails;
    }

    public void setContactDetails(String contactDetails) {
        ContactDetails = contactDetails;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        CompanyLogo = companyLogo;
    }
}
