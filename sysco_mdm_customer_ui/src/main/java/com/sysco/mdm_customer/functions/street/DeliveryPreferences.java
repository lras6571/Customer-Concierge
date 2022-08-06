package com.sysco.mdm_customer.functions.street;

import com.sysco.mdm_customer.pages.street.DeliveryPreferencesPage;


public class DeliveryPreferences {

    public static final DeliveryPreferencesPage deliveryPreferencesPage = new DeliveryPreferencesPage();

    private DeliveryPreferences() {
    }

    public static void confirmDeliveryPreferences() {
        deliveryPreferencesPage.clickYesDeliveryPreferences();
    }

    /*
     * Enter Delivery Preferences Data
     * */
    public static void enterDeliveryDate(String deliveryDate) {
        deliveryPreferencesPage.enterDeliveryDate(deliveryDate);
    }

    public static void enterDeliveryWindowStartTime(String startTime) {
        deliveryPreferencesPage.enterTimeDeliveryWindow1Start(startTime);
    }

    public static void enterDeliveryWindowEndTime(String endTime) {
        deliveryPreferencesPage.enterTimeDeliveryWindow1End(endTime);
    }

    public static void enterBackdoorOpenTime(String openTime) {
        deliveryPreferencesPage.enterTimeBackdoorOpen(openTime);
    }

    public static void enterBackdoorCloseTime(String closeTime) {
        deliveryPreferencesPage.enterTimeBackdoorClose(closeTime);
    }
    public static boolean isDeliveryPreferencesFieldDisplayed() {
        return deliveryPreferencesPage.isDeliveryPreferencesFieldDisplayed();
    }

}