package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEASearchScreenPage;

public class CFEASearchScreen {

    private CFEASearchScreen() {
    }


    public static final CFEASearchScreenPage cfeaSearchScreenPage = new CFEASearchScreenPage();


    //Fill the Lead Name, click Search
    public static void enterCreatedLeadName(String strLeadName) {

        cfeaSearchScreenPage.enterCreatedLeadName(strLeadName);
        cfeaSearchScreenPage.selectLead();
    }


    //Fill the Lead Name and click Search and Click Next for Select Territory
    public static void selectLead() {

        cfeaSearchScreenPage.clickNext();
    }


    //Select the First Record from the Territory
    public static void selectFreshPointTerritory() {

        cfeaSearchScreenPage.selectFreshPointTerritory();
    }

}
