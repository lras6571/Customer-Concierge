package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDDeliveryPreferenceScreenPage;

public class CADDDeliveryPreferenceScreen {

    public static final CADDDeliveryPreferenceScreenPage caddDeliveryPreferenceScreenPage = new CADDDeliveryPreferenceScreenPage();

    private CADDDeliveryPreferenceScreen() {
    }

    //Select the Delivery Date from the Drop-Down
    public static void enterDeliveryDate(String deliveryDate) {

        caddDeliveryPreferenceScreenPage.enterDeliveryDate(deliveryDate);
    }

    //Fill the Standard Delivery Window 1 Start Time
    public static void enterDeliveryWindowStartTime(String startTime) {

        caddDeliveryPreferenceScreenPage.enterTimeDeliveryWindow1Start(startTime);
    }

    //Fill the Standard Delivery Window 1 End Time
    public static void enterDeliveryWindowEndTime(String endTime) {

        caddDeliveryPreferenceScreenPage.enterTimeDeliveryWindow1End(endTime);
    }

    //Fill the Standard Backdoor Open Time
    public static void enterBackdoorOpenTime(String openTime) {

        caddDeliveryPreferenceScreenPage.enterTimeBackdoorOpen(openTime);
    }

    //Fill the Standard Backdoor Close Time
    public static void enterBackdoorCloseTime(String closeTime) {

        caddDeliveryPreferenceScreenPage.enterTimeBackdoorClose(closeTime);
    }

    //Enter Next Button in Account Info - CADD Wizard
    public static void clickDeliveryPreferenceInfo() {

        caddDeliveryPreferenceScreenPage.clickNextAccountInfo();
    }


}
