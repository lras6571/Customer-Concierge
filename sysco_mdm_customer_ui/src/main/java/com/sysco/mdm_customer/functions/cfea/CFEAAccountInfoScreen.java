package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEAAccountInfoScreenPage;

public class CFEAAccountInfoScreen {

    private CFEAAccountInfoScreen() {
    }

    private static final CFEAAccountInfoScreenPage cfeaAccountInfoScreenPage = new CFEAAccountInfoScreenPage();

    //Fill Account Info Details in CADD Wizard
    public static void enterAccountInfoDetails(String accountName, String phoneNumber) {
        cfeaAccountInfoScreenPage.enterAccountName(accountName);
        cfeaAccountInfoScreenPage.enterPhoneNumber(phoneNumber);
    }

    //Fill Account Info Address Details in CADD Wizard
    public static void enterStoreNumberDetails(String storeNumber) {
        cfeaAccountInfoScreenPage.enterStoreNumber(storeNumber);
    }

    //Fill Account Info Address Details in CADD Wizard
    public static void enterCityAddressDetails(String shippingStreet, String shippingCity) {
        cfeaAccountInfoScreenPage.enterShippingStreet(shippingStreet);
        cfeaAccountInfoScreenPage.enterShippingCity(shippingCity);
    }

    //Fill Account Info Address Details in CADD Wizard
    public static void enterStateAddressDetails(String shippingZip, String state, String country) {
        cfeaAccountInfoScreenPage.enterShippingZip(shippingZip);
        cfeaAccountInfoScreenPage.enterState(state);
        cfeaAccountInfoScreenPage.enterCountry(country);
    }

    //Click Next Account Info Screen
    public static void clickNextAccountInfo() {
        cfeaAccountInfoScreenPage.clickNextAccountInfo();
    }

    //Click Next Address Confirm Screen
    public static void clickNextAddressConfirm(){
        cfeaAccountInfoScreenPage.clickNextAddressConfirm();
    }

    //Retrieve Account Name
    public static String retrieveAccountName(String accountName) {
        return cfeaAccountInfoScreenPage.retrieveAccountName(accountName);
    }

}
