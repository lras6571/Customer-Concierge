package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDShipToConfirmationScreenPage;


public class CADDShipToConfirmationScreen {

    private CADDShipToConfirmationScreen(){
    }

    private static final CADDShipToConfirmationScreenPage caddShipToConfirmationScreenPage = new CADDShipToConfirmationScreenPage();


    //Assert Business Information in Ship To Screen
    public static void assertBusinessInformation(String conceptID,String companyName,String caddAccountType,String mobileNumber,String storeNumber) {

        caddShipToConfirmationScreenPage.assertConceptID(conceptID);
        caddShipToConfirmationScreenPage.assertBusinessName(companyName);
        caddShipToConfirmationScreenPage.assertAccountType(caddAccountType);
        caddShipToConfirmationScreenPage.assertBusinessPhone(mobileNumber);
        caddShipToConfirmationScreenPage.assertStoreNumber(storeNumber);
    }


    //Assert Shipping Information in Ship To Screen
    public static void assertShippingInformation(String shippingZip,String state,String shippingStreet,String shippingCity) {

        caddShipToConfirmationScreenPage.assertShippingStreet(shippingStreet);
        caddShipToConfirmationScreenPage.assertShippingZip(shippingZip);
        caddShipToConfirmationScreenPage.assertShippingState(state);
        caddShipToConfirmationScreenPage.assertShippingCity(shippingCity);
    }


    //Assert Contact Information in Ship To Screen
    public static void assertContactName(String fullName,String email,String mobileNumber) {

        caddShipToConfirmationScreenPage.assertContactName(fullName);
        caddShipToConfirmationScreenPage.assertContactEmail(email);
        caddShipToConfirmationScreenPage.assertContactNumber(mobileNumber);
    }


    //Assert Territory Information in Ship To Screen
    public static void assertTerritorySite(String site,String territoryCode) {

        caddShipToConfirmationScreenPage.assertTerritorySite(site);
        caddShipToConfirmationScreenPage.assertTerritoryCode(territoryCode);
    }


    //Click Next in Ship To Screen
    public static void clickNextShipToScreen() {

        caddShipToConfirmationScreenPage.clickNextShipToScreen();
    }
}
