package com.sysco.mdm_customer.functions.ps;

import com.sysco.mdm_customer.pages.ps.AddressDetailsScreenPage;

public class AddressDetailsScreen {


    private static final AddressDetailsScreenPage addressDetailsScreenPage = new AddressDetailsScreenPage();


    //Enter Ship to Details of Prospect Shop Flow
    public static void enterShipToNameDetails(String shipToName) {

        addressDetailsScreenPage.enterShipToName(shipToName);
    }

    //Enter Ship to Address Details of Prospect Shop Flow
    public static void enterShipToAddressDetails(String shipToStreet, String shipToCity) {

        addressDetailsScreenPage.enterShipToAddress(shipToStreet);
        addressDetailsScreenPage.enterShipToCity(shipToCity);
    }


    //Enter Ship to Postal Details of Prospect Shop Flow
    public static void enterShipToPostalDetails(String shipToState, String shipToZip) {

        addressDetailsScreenPage.enterShipToState(shipToState);
        addressDetailsScreenPage.enterShipToZipCode(shipToZip);
    }


    //Enter Ship To Country Details of Prospect Shop Flow
    public static void enterShipToCountryDetails(String shipToCounty) {

        addressDetailsScreenPage.enterShipToCountryDetails(shipToCounty);
    }


    //Enter Bill to Details of Prospect Shop Flow
    public static void enterBillToNameDetails(String shipToName) {

        addressDetailsScreenPage.enterBillToName(shipToName);
    }


    //Enter Bill to Address Details of Prospect Shop Flow
    public static void enterBillToAddressDetails(String shipToStreet, String shipToCity) {

        addressDetailsScreenPage.enterBillToStreet(shipToStreet);
        addressDetailsScreenPage.enterBillToCity(shipToCity);
    }


    //Enter Bill to Postal Details of Prospect Shop Flow
    public static void enterBillToPostalDetails(String shipToState, String shipToZip) {

        addressDetailsScreenPage.enterBillToZipCode(shipToZip);
        addressDetailsScreenPage.enterBillToState(shipToState);
    }


    //click Next in Prospect Shop Address Screen
    public static void clickNextProspectShopAddressScreen() {

        addressDetailsScreenPage.clickNextAddressScreen();
    }


    //click Next in Prospect Shop Address Screen
    public static void clickNextAddressConfirmation() {

        addressDetailsScreenPage.clickNextAddressConfirmation();
    }


    //Retrieve Account Name
    public static String retrieveAccountName(String accountName){

        return addressDetailsScreenPage.retrieveAccountName(accountName);
    }
}
