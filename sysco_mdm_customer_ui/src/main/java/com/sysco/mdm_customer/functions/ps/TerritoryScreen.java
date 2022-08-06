package com.sysco.mdm_customer.functions.ps;

import com.sysco.mdm_customer.pages.ps.TerritoryScreenPage;

public class TerritoryScreen {

    private static final TerritoryScreenPage territoryScreenPage = new TerritoryScreenPage();


    //Click Save Attribute in Attribute Screen
    public static void clickNextProspectShopAddressScreen() {

        territoryScreenPage.clickNext();

    }
}
