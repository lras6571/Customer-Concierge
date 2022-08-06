package com.sysco.mdm_customer.functions.street;


import com.sysco.mdm_customer.pages.street.ShipToConfirmationPage;

public class ShipToConfirmation {

    static ShipToConfirmationPage shipToConfirmationPage = new ShipToConfirmationPage();

    private ShipToConfirmation() {
    }
    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Business Info For STREET primary and STREET secondary Ship-To
     * */

    public static void collectBusinessInformationDataForSTREETAccounts() {
        shipToConfirmationPage.collectBusinessInformationDataForSTREETAccounts();
    }

    public static String getBusinessInformation(String fieldName) {
        return shipToConfirmationPage.getBusinessInformation(fieldName);
    }
    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Shipping address details of all account types
     * */

    public static void collectShippingAddressInformation() {
        shipToConfirmationPage.collectShippingAddressInformation();
    }

    public static String getShippingAddress(String fieldName) {
        return shipToConfirmationPage.getShippingAddress(fieldName);
    }
    /*
     * collectNewContactInformation - To collect contact information of all account types
     * */

    public static void collectNewContactInformation() {
        shipToConfirmationPage.collectNewContactInformation();
    }

    public static String getNewContactInformation(String fieldName) {
        return shipToConfirmationPage.getNewContactInformation(fieldName);
    }
    /*
     * collectDeliveryPreferenceData - To collect contact information of all account types
     * */

    public static void collectDeliveryPreferenceData() {
        shipToConfirmationPage.collectDeliveryPreferenceData();
    }

    public static String getDeliveryPreferenceData(String fieldName) {
        return shipToConfirmationPage.getDeliveryPreferenceData(fieldName);
    }

}