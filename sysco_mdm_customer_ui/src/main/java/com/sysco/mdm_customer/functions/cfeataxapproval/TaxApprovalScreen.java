package com.sysco.mdm_customer.functions.cfeataxapproval;

import com.sysco.mdm_customer.pages.cfeataxapproval.TaxApprovalScreenPage;

public class TaxApprovalScreen {

    private TaxApprovalScreen(){
    }

    public static final TaxApprovalScreenPage taxApprovalScreenPage = new TaxApprovalScreenPage();


    //Click Update Credit or Tax
    public static void clickUpdateTax() {

        taxApprovalScreenPage.clickUpdateTax();
    }


    //Click Update Credit or Tax
    public static void clickTaxInformation() {

        taxApprovalScreenPage.clickTaxInformation();
    }


    //Click Next in Address Verification Screen
    public static void clickNextAddressVerification() {
        taxApprovalScreenPage.clickNextAddressVerification();
    }


    //Click Next in Shipping Address Verification
    public static void clickNextShippingAddressVerification() {
        taxApprovalScreenPage.clickNextShippingAddressVerification();
    }

    //Click Next in Billing Address Verification
    public static void clickNextBillingAddressVerification() {
        taxApprovalScreenPage.clickNextBillingAddressVerification();
    }

    //Enter Tax Details
    public static void enterTaxDetails(String strState) {
        taxApprovalScreenPage.enterTaxDetails(strState);
    }


    //Click Next in the Final Approval
    public static void clickNextFinalApprovalScreen() {

        taxApprovalScreenPage.clickNextFinalApprovalScreen();
    }
}
