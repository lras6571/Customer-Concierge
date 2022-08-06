package com.sysco.mdm_customer.functions.ps;

import com.sysco.mdm_customer.pages.ps.ContactInformationScreenPage;

public class ContactInformationScreen {

    private ContactInformationScreen(){
    }
    private static final ContactInformationScreenPage contactInformationScreenPage = new ContactInformationScreenPage();


    //Enter Contact Details in Prospect Shop
    public static void enterContactNameInfoDetails(String firstName, String lastName) {

        contactInformationScreenPage.enterFirstName(firstName);
        contactInformationScreenPage.enterLastName(lastName);
    }


    //Enter Contact Details in Prospect Shop
    public static void enterContactInfoDetails(String email, String phone) {

        contactInformationScreenPage.enterEmail(email);
        contactInformationScreenPage.enterPhoneNumber(phone);
    }


    //Click Check box in in Prospect Shop.
    public static void clickCheckBoxes() {

        contactInformationScreenPage.tickEmail();
        contactInformationScreenPage.tickPhoneNumber();
    }


    //Enter Sales Amount in Prospect Shop.
    public static void enterSalesAmount() {

        contactInformationScreenPage.enterSalesAmount();
    }


    //Click Next in Contact Info Screen
    public static void clickNextContactInfo() {

        contactInformationScreenPage.clickNextContactInfo();
    }
}
