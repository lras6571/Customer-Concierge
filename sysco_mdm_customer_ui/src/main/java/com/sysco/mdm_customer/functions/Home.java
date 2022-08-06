package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.HomePage;

public class Home {

    private Home() {
    }

    public static final HomePage homePage = new HomePage();

    //Click Settings
    public static void clickSettings() {
        homePage.clickSettingsIcon();
    }


    //Click Setup
    public static void clickSetup() {
        homePage.clickSetupButton();
    }


    //Search Marketing Associate
    public static void searchMarketingAssociate(String marketingAssociate) {
        homePage.clickUserSearch(marketingAssociate);
    }


    //Login as MA
    public static void clickMAUserLoginButton() {
        homePage.clickMAUserLogin();

    }

    //Change the Profile
    public static void changeProfile() {

        homePage.changeProfile();
    }

}
