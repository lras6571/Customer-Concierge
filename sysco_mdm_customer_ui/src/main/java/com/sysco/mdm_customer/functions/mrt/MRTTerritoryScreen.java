package com.sysco.mdm_customer.functions.mrt;

import com.sysco.mdm_customer.pages.mrt.MRTTerritoryScreenPage;

public class MRTTerritoryScreen {

    private MRTTerritoryScreen() {
    }

    public static final MRTTerritoryScreenPage mrtTerritoryScreenPage = new MRTTerritoryScreenPage();


    //Select Territory
    public static void selectTerritory() {

        mrtTerritoryScreenPage.selectTerritory();

    }

    //Click Next Button in the Territory Select Screen
    public static void clickNext() {

        mrtTerritoryScreenPage.clickNext();

    }

}
