package com.sysco.mdm_customer.functions.street;


import com.sysco.mdm_customer.pages.street.ShipToInfoPage;


public class ShipToInfo {

    static ShipToInfoPage shipToInfoPage = new ShipToInfoPage();

    private ShipToInfo() {
    }

    public static void enterShippingAccountName(String accountName) {
        shipToInfoPage.enterShippingAccountName(accountName);
    }


    public static void selectShipToAccountGroup(String strAccountGroup) {
        shipToInfoPage.selectShipToAccountGroup(strAccountGroup);
    }

    public static void confirmPrincipalOwnerofTheAccount() {
        shipToInfoPage.addPrincipalOwner();
    }

    public static void confirmShipAddress() {
        shipToInfoPage.confirmShippingAddress();
    }

    /*
     * Enter Shipping Details  (Shipping Street,Shipping City,Shipping State,Shipping PostalCode,ShipTo Country,ShipTo PhoneNumber)
     * */

    public static void enterShippingStreet(String shippingStreet) {
        shipToInfoPage.enterShippingStreet(shippingStreet);
    }

    public static void enterShippingCity(String shippingCity) {
        shipToInfoPage.enterShippingCity(shippingCity);
    }

    public static void selectShippingState(String state) {
        shipToInfoPage.selectShippingState(state);
    }

    public static void enterShippingPostalCode(String postalCode) {
        shipToInfoPage.enterShippingPostalCode(postalCode);
    }

    public static void selectShipToCountry(String strShipToCountry) {
        shipToInfoPage.selectShipToCountry(strShipToCountry);
    }

    public static void enterShipToPhoneNumber(String strShipToPhoneNumber) {
        shipToInfoPage.enterShipToPhoneNumber(strShipToPhoneNumber);
    }
    public static boolean isAccountInfoFieldDisplayed() {
        return  shipToInfoPage.isAccountInfoFieldDisplayed();
    }

}