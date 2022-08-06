package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEABillToConfirmationScreenPage;

public class CFEABillToConfirmationScreen {

    private CFEABillToConfirmationScreen() {
    }

    private static final CFEABillToConfirmationScreenPage cfeaBillToConfirmationScreenPage = new CFEABillToConfirmationScreenPage();

    //Click Next in Bill To Confirmation Screen
    public static void clickNextBillToConfirmation() {
        cfeaBillToConfirmationScreenPage.clickNextBillToConfirmation();
    }

}
