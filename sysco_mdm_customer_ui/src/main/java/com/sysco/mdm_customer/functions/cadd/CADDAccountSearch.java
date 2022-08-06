package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDAccountSearchPage;

public class CADDAccountSearch {

    private CADDAccountSearch() {
    }

    private static final CADDAccountSearchPage caddAccountSearchPage = new CADDAccountSearchPage();


    //Search for an Existing Account
    public static void searchAccountToActivate(String existingAccountName) {

        caddAccountSearchPage.searchAccountToActivate(existingAccountName);
    }


    //Assert the Search Result name with Search Name
    public static void verifyRecordName(String existingAccountName) {

        caddAccountSearchPage.isRecordMatch(existingAccountName);
    }


    //Click the First Name
    public static void selectRecord() {

        caddAccountSearchPage.selectRecord();
    }

}
