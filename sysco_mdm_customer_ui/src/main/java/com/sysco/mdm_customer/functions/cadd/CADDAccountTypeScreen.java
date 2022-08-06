package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDAccountTypeScreenPage;


public class CADDAccountTypeScreen {

    private CADDAccountTypeScreen() {
    }

    private static final CADDAccountTypeScreenPage caddAccountTypeScreenPage = new CADDAccountTypeScreenPage();


    //Click the Next Location Button
    public static void selectNewLocation() {

        caddAccountTypeScreenPage.selectNewLocation();
    }


    //Select an Existing Location
    public static void selectExistingLocation() {

        caddAccountTypeScreenPage.selectExistingLocation();

    }
}
