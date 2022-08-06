package com.sysco.mdm_customer.functions.lead;

import com.sysco.mdm_customer.pages.lead.LeadCreatePage;

public class LeadCreation {

    private LeadCreation(){
    }
    public static final LeadCreatePage leadCreatePage = new LeadCreatePage();


    //Select the Salutation
    public static void selectSalutation() {

        leadCreatePage.selectSalutation();
    }


    //Fill the Company Name Text field by generating a random word and append it
    public static void enterCompanyName(String strCompanyName) {

        leadCreatePage.enterCompanyName(strCompanyName);
    }


    //Fill the Company Contact Details
    public static void enterCompanyContactDetails(String strFirstName, String strLastName) {

        leadCreatePage.enterCompanyContactDetails(strFirstName, strLastName);
    }


    //Fill the Weekly Sales Value
    public static void enterWeeklySales(String strWeeklySales) {

        leadCreatePage.enterWeeklySales(strWeeklySales);
    }


    //Fill the Contact Email
    public static void enterContactEmail(String contactEmail) {

        leadCreatePage.enterContactEmail(contactEmail);
    }


    //Fill the DSM Name from the Drop Down
    public static void assignToDSM (String dsmName) {

        leadCreatePage.assignToDSM(dsmName);
    }


    //Select the Rating
    public static void selectLeadRating(String strRating) {

        leadCreatePage.selectLeadRating(strRating);
    }


    //Select the Billing Address Details
    public static void enterBillToAddress(String billingStreet, String billingState, String billingCity, String billingCountry, String billingZipCode){

        leadCreatePage.enterBillToAddress(billingStreet, billingState, billingCity, billingCountry, billingZipCode);
    }


    //Save the Lead Form
    public static void saveLeadDetails() {

        leadCreatePage.saveLeadDetails();
    }

    //Click Detail Tab
    public static void clickDetailTab() {

        leadCreatePage.clickDetailTab();
    }
}
