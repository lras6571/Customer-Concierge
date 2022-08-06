package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDContactInfoScreenPage;

public class CADDContactInfoScreen {

    private CADDContactInfoScreen(){
    }

    private static final CADDContactInfoScreenPage caddContactInfoScreenPage = new CADDContactInfoScreenPage();


    public static void enterNameInfoDetails(String firstName, String lastName) {

        caddContactInfoScreenPage.enterFirstName(firstName);
        caddContactInfoScreenPage.enterLastName(lastName);
    }


    public static void enterContactInfoDetails(String email, String phone) {

        caddContactInfoScreenPage.enterEmail(email);
        caddContactInfoScreenPage.enterPhoneNumber(phone);
    }


    //Select the Customer Language Preference
    public static void selectLanguagePreference() {

        caddContactInfoScreenPage.selectLanguagePreference();
    }


    //Enter Next Button in Contact Info Screen - CADD Wizard
    public static void clickNextAddressConfirm() {

        caddContactInfoScreenPage.clickNextAddressConfirm();
    }
}
