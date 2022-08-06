package com.sysco.mdm_customer.functions.ps;

import com.sysco.mdm_customer.pages.ps.ProspectSearchPage;

public class ProspectSearch {

    private ProspectSearch(){
    }
    private static final ProspectSearchPage prospectSearchPage = new ProspectSearchPage();


    //Click Save Attribute in Attribute Screen
    public static void searchProspect(String prospectName) {

        prospectSearchPage.searchProspect(prospectName);
        prospectSearchPage.clickSearch();
        prospectSearchPage.selectFirstRecord();

    }

}
