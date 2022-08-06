package com.sysco.mdm_customer.functions.cfeataxapproval;

import com.sysco.mdm_customer.pages.cfeataxapproval.TaxApproverHomePage;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class TaxApproverHome {

    private TaxApproverHome() {
    }

    public static final TaxApproverHomePage asianFoodsTaxApproverHomePage = new TaxApproverHomePage();


    //Click Lead Tab
    public static void clickLeadTab() {
        asianFoodsTaxApproverHomePage.clickLeadTab();
    }


    //Select the Asian Foods NCOB Queue Filter
    public static void selectAsianFoodsFilter(String strAsianFoodsFilter) {
        asianFoodsTaxApproverHomePage.selectAsianFoodsFilter(strAsianFoodsFilter);
    }


    //Select the Fresh Point NCOB Queue Filter
    public static void selectFreshPointFilter(String strFreshPointFilter) {
        asianFoodsTaxApproverHomePage.selectFreshPointFilter(strFreshPointFilter);
    }


    //Select the Records
    public static void selectRecord(String recordName, String queueName) {
        asianFoodsTaxApproverHomePage.selectRecordByName(recordName, queueName);
    }

}
