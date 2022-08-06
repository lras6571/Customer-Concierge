package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDBillToConfirmationScreenPage;

public class CADDBillToConfirmationScreen {

    private CADDBillToConfirmationScreen(){
    }

    private static final CADDBillToConfirmationScreenPage caddBillToConfirmationScreenPage = new CADDBillToConfirmationScreenPage();

    //Enter Bill to Confirmation Details
    public static void enterBillToConfirmation(String billToName, String shippingStreet, String shippingCity, String state, String shippingZip) {

        caddBillToConfirmationScreenPage.enterBillToName(billToName);
        caddBillToConfirmationScreenPage.enterBillToAddress(shippingStreet);
        caddBillToConfirmationScreenPage.enterBillToCity(shippingCity);
        caddBillToConfirmationScreenPage.enterBillToState(state);
        caddBillToConfirmationScreenPage.enterBillToPostalCode(shippingZip);
    }

    //Click Next in Ship To Screen
    public static void clickNextBillToConfirmation() {

        caddBillToConfirmationScreenPage.clickNextBillToScreen();
        caddBillToConfirmationScreenPage.clickSaveAttribute();
        caddBillToConfirmationScreenPage.clickSendCreditApplication();
    }

    //Click Save Attribute in Attribute Screen
    public static void clickSaveAttribute() {

        caddBillToConfirmationScreenPage.clickSaveAttributeAdditional();

    }


}
