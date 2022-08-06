package com.sysco.mdm_customer.functions.cfeataxapproval;

import com.sysco.mdm_customer.pages.cfeataxapproval.TaxConfirmationScreenPage;

public class TaxConfirmationScreen {

    private TaxConfirmationScreen() {
    }

    public static final TaxConfirmationScreenPage taxConfirmationScreenPage = new TaxConfirmationScreenPage();



    //Refresh the Browser
    public static void refreshBrowser() {

        taxConfirmationScreenPage.refreshBrowser();
    }


    //Get CFEA FP New Account ID
    public static void getFreshPointAccountID() {

        taxConfirmationScreenPage.getFreshPointAccountID();
    }


    //Get CFEA AF New Account ID
    public static void getAsianFoodsAccountID() {

        taxConfirmationScreenPage.getAsianFoodsAccountID();
    }
}
