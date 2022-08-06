package com.sysco.mdm_customer.functions.mrt;

import com.sysco.mdm_customer.pages.mrt.MRTLeadScreenPage;

public class MRTLeadScreen {

    private MRTLeadScreen() {
    }

    public static final MRTLeadScreenPage mrtLeadScreenPage = new MRTLeadScreenPage();


    //Click Prospect Shop
    public static void clickProspectShop() {

        mrtLeadScreenPage.clickProspectShop();
    }
}
