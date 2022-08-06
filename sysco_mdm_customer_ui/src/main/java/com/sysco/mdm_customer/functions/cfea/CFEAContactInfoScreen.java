package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEAContactInfoScreenPage;

public class CFEAContactInfoScreen {

    private CFEAContactInfoScreen(){
    }

    private static final CFEAContactInfoScreenPage cfeaContactInfoScreenPage = new CFEAContactInfoScreenPage();

    public static void enterNameInfoDetails(String firstName, String lastName) {
        cfeaContactInfoScreenPage.enterFirstName(firstName);
        cfeaContactInfoScreenPage.enterLastName(lastName);
    }

    public static void enterContactInfoDetails(String email, String phone) {
        cfeaContactInfoScreenPage.enterEmail(email);
        cfeaContactInfoScreenPage.enterPhoneNumber(phone);
    }

    //Select the Customer Language Preference
    public static void selectLanguagePreference(String strLanguage) {
        cfeaContactInfoScreenPage.selectLanguagePreference(strLanguage);
    }

    //Enter Next Button in Contact Info Screen - CADD Wizard
    public static void clickNextContactInfo() {
        cfeaContactInfoScreenPage.clickNextContactInfo();
    }

    //Retrieve Name Info
    public static String retrieveNameInfo(String firstName, String lastName) {
        return cfeaContactInfoScreenPage.retrieveNameInfo(firstName, lastName);
    }

}
