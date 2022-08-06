package com.sysco.mdm_customer.functions.cfealead;

import com.sysco.mdm_customer.pages.cfealead.CFEALeadCreatePage;

public class CFEALeadCreation {

    private CFEALeadCreation() {
    }

    public static final CFEALeadCreatePage cfeaLeadCreatePage = new CFEALeadCreatePage();

    //Fill the Company Name Text field by generating a random word and append it
    public static void enterCompanyName(String strCompanyName) {

        cfeaLeadCreatePage.enterCompanyName(strCompanyName);
    }


    //Select the Salutation
    public static void selectSalutation() {

        cfeaLeadCreatePage.selectSalutation();
    }


    //Fill the Company Contact Details
    public static void enterCompanyContactDetails(String strFirstName, String strLastName) {

        cfeaLeadCreatePage.enterCompanyContactDetails(strFirstName, strLastName);
    }


    //Fill the Company Contact Details
    public static void enterPhoneNumber(String strPhoneNumber) {

        cfeaLeadCreatePage.enterPhoneNumber(strPhoneNumber);
    }


    //Fill the Company Contact Details
    public static void enterTitle() {

        cfeaLeadCreatePage.enterTitle();
    }


    //Fill the Weekly Sales Value
    public static void enterWeeklySales(String strWeeklySales) {

        cfeaLeadCreatePage.enterWeeklySales(strWeeklySales);
    }


    //Fill the Contact Email
    public static void enterContactEmail(String contactEmail) {

        cfeaLeadCreatePage.enterContactEmail(contactEmail);
    }


    //Fill the Contact Email
    public static void enterCommunicationMethod() {

        cfeaLeadCreatePage.enterCommunicationMethod();
    }


    //Select the Rating
    public static void selectLeadRating() {

        cfeaLeadCreatePage.selectLeadRating();
    }


    //Select the Rating
    public static void selectBusinessStructure() {

        cfeaLeadCreatePage.selectBusinessStructure();
    }


    //Save the Lead Form
    public static void saveLeadDetails() {

        cfeaLeadCreatePage.saveLeadDetails();
    }


    //Retrieve Lead Name
    public static String retrieveLeadName(String companyName) {
        return cfeaLeadCreatePage.retrieveLeadName(companyName);
    }

}
