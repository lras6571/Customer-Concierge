package com.sysco.mdm_customer.functions.sbsuser;

import com.sysco.mdm_customer.pages.sbsuser.SBSApprovalPage;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class SBSApproval {

    public static final SBSApprovalPage sbsApprovalPage = new SBSApprovalPage();


    //Accept Case SR by SBS User
    public static void selectAcceptCase() {

        sbsApprovalPage.selectAcceptCase();
    }


    //Click Data Service Tab
    public static void clickDataServiceTab() {

        sbsApprovalPage.clickDataServiceTab();
    }


    //Verify Address Details Screen
    public static void clickNextAddressVerification() {

        sbsApprovalPage.clickSaveAddresses();
        sbsApprovalPage.clickNextAddressVerification();
    }


    //Verify Tax Details Screen
    public static void enterTaxDetails(String strTaxGroup, String strTaxSupplement){

//        sbsApprovalPage.enterTaxDetails(strTaxGroup, strTaxSupplement);
        sbsApprovalPage.saveTaxDetails();
        sbsApprovalPage.navigateToNextTab();
    }


    //Approve Support Request.
    public static void approveSupportRequest(String approveComment) {

        sbsApprovalPage.approveSupportRequest(approveComment);
    }

    //Select the Support Request
    public static void selectSupportRequest() {
        sbsApprovalPage.searchSupportRequest();
    }
    //Select the Records
    public static void selectRecord(String name) {
//        asianFoodsTaxApproverHomePage.clickTimeColumn();
        sbsApprovalPage.selectRecordByName(name);
    }
}
