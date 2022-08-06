package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDSearchScreenPage;

public class CADDSearchScreen {

    private CADDSearchScreen(){
    }

    private static final CADDSearchScreenPage caddNewSearchScreenPage = new CADDSearchScreenPage();

    //Search CADD Concept ID in Search Wizard
    public static void enterConceptDetails(String conceptName) {

        caddNewSearchScreenPage.searchConceptID(conceptName);
    }

    //Select the Site and the MA from the Search Wizard
    public static void searchTerritoryValues(String site, String marketingAssociate) {

        caddNewSearchScreenPage.searchTerritory(site,marketingAssociate);
    }

    //Select the Site and the MA from the Search Wizard
    public static void searchTerritoryValuesTesMa(String site, String marketingAssociate) {

        caddNewSearchScreenPage.searchTrsMaTerritory(site,marketingAssociate);
    }


}
