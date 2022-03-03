package com.example.tpo_training_and_placement.models;

public class EditTrainingDetailsModel {
    String CompanyName, AboutCompany, ContentOfTraining, EligibilityCriteria, TrainingDuration, TrainingCharges, RegistrationDate, lastDateOfRegistration, ContactDetails;

    public EditTrainingDetailsModel() {
    }

    public EditTrainingDetailsModel(String companyName, String aboutCompany, String contentOfTraining, String eligibilityCriteria, String trainingDuration, String trainingCharges, String registrationDate, String lastDateOfRegistration, String contactDetails) {
        this.CompanyName = companyName;
        this.AboutCompany = aboutCompany;
        this.ContentOfTraining = contentOfTraining;
        this.EligibilityCriteria = eligibilityCriteria;
        this.TrainingDuration = trainingDuration;
        this.TrainingCharges = trainingCharges;
        this.RegistrationDate = registrationDate;
        this.lastDateOfRegistration = lastDateOfRegistration;
        this.ContactDetails = contactDetails;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getAboutCompany() {
        return AboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        AboutCompany = aboutCompany;
    }

    public String getContentOfTraining() {
        return ContentOfTraining;
    }

    public void setContentOfTraining(String contentOfTraining) {
        ContentOfTraining = contentOfTraining;
    }

    public String getEligibilityCriteria() {
        return EligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        EligibilityCriteria = eligibilityCriteria;
    }

    public String getTrainingDuration() {
        return TrainingDuration;
    }

    public void setTrainingDuration(String trainingDuration) {
        TrainingDuration = trainingDuration;
    }

    public String getTrainingCharges() {
        return TrainingCharges;
    }

    public void setTrainingCharges(String trainingCharges) {
        TrainingCharges = trainingCharges;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getLastDateOfRegistration() {
        return lastDateOfRegistration;
    }

    public void setLastDateOfRegistration(String lastDateOfRegistration) {
        this.lastDateOfRegistration = lastDateOfRegistration;
    }

    public String getContactDetails() {
        return ContactDetails;
    }

    public void setContactDetails(String contactDetails) {
        ContactDetails = contactDetails;
    }
}
