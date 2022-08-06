package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDAccountInfoScreenPage;

public class CADDAccountInfoScreen {

    private CADDAccountInfoScreen(){
    }

    private static final CADDAccountInfoScreenPage caddAccountInfoScreenPage = new CADDAccountInfoScreenPage();


    //Fill Account Info Details in CADD Wizard
    public static void enterAccountInfoDetails(String accountName,String phoneNumber) {

        caddAccountInfoScreenPage.enterAccountName(accountName);
        caddAccountInfoScreenPage.enterPhoneNumber(phoneNumber);
    }


    //Fill Account Info Address Details in CADD Wizard
    public static void enterStoreNumberDetails(String storeNumber){

        caddAccountInfoScreenPage.enterStoreNumber(storeNumber);
    }


    //Fill Account Info Address Details in CADD Wizard
    public static void enterCityAddressDetails(String shippingStreet,String shippingCity) {


        caddAccountInfoScreenPage.enterShippingStreet(shippingStreet);
        caddAccountInfoScreenPage.enterShippingCity(shippingCity);

    }


    //Fill Account Info Address Details in CADD Wizard
    public static void enterStateAddressDetails(String shippingZip, String state,String country) {

        caddAccountInfoScreenPage.enterShippingZip(shippingZip);
        caddAccountInfoScreenPage.enterState(state);
        caddAccountInfoScreenPage.enterCountry(country);
    }


    //Fill Account Info Address Details in CADD Wizard
    public static void clickNextAccountInfo() {

        caddAccountInfoScreenPage.clickNextAccountInfo();
        caddAccountInfoScreenPage.clickNextAddressConfirm();
    }


    //Retrieve Account Name
    public static String retrieveAccountName(String accountName){

        return caddAccountInfoScreenPage.retrieveAccountName(accountName);
    }


}
