package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEAShipToConfirmationScreenPage;

public class CFEAShipToConfirmationScreen {

    private CFEAShipToConfirmationScreen() {
    }

    private static final CFEAShipToConfirmationScreenPage cfeaShipToConfirmationScreenPage = new CFEAShipToConfirmationScreenPage();

    //Click Next Account Info Screen
    public static void clickNextShipToConfirmation(String key) {

        cfeaShipToConfirmationScreenPage.clickNextShipToConfirmation(key);
    }

}
