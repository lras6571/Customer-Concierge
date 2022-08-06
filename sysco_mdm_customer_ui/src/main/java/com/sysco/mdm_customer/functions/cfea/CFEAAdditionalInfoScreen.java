package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEAAdditionalInfoScreenPage;

public class CFEAAdditionalInfoScreen {


    private CFEAAdditionalInfoScreen() {
    }

    private static final CFEAAdditionalInfoScreenPage cfeaAdditionalInfoScreenPage = new CFEAAdditionalInfoScreenPage();


    //Enter Routing Information
    public static void enterAccountInfoDetails(String strRoutingInformation) {

        cfeaAdditionalInfoScreenPage.enterRoutingInformation(strRoutingInformation);
    }


    //Enter National and Local ID
    public static void enterNationalID(String strNationalID ) {

        cfeaAdditionalInfoScreenPage.enterNationalID(strNationalID);
    }


    //Click National and Local ID
    public static void clickNextButton() {

        cfeaAdditionalInfoScreenPage.clickNextButton();
    }
}
