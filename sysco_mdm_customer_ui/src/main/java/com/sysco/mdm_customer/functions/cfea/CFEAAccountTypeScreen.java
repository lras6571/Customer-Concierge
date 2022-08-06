package com.sysco.mdm_customer.functions.cfea;

import com.sysco.mdm_customer.pages.cfea.CFEAAccountTypeScreenPage;

public class CFEAAccountTypeScreen {

    private CFEAAccountTypeScreen() {
    }

    private static final CFEAAccountTypeScreenPage cfeaAccountTypeScreenPage = new CFEAAccountTypeScreenPage();



    //Select the Next Location Button
    public static void selectNewLocation() {

        cfeaAccountTypeScreenPage.selectNewLocation();
    }


    //Select an Existing Location
    public static void selectExistingLocation() {

        cfeaAccountTypeScreenPage.selectExistingLocation();

    }
}
