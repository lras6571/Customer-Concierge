package com.sysco.mdm_customer.functions.street;


import com.sysco.mdm_customer.pages.street.SearchScreenPage;

public class SearchScreen {
private SearchScreen(){}
    static SearchScreenPage searchScreenPage = new SearchScreenPage();


    /*
     * Verify the Active Prospect Flow display or not
     * */
    public static boolean isActivateProspectHomeScreenDisplayed() {
        return searchScreenPage.isActivateProspectHomeScreenDisplayed();
    }

    /*
     * Verify the Active Prospect Flow Search Screen Table Column Verification
     * */
    public static boolean isSearchScreenTableColumnDisplayed() {
        return searchScreenPage.isSearchScreenTableColumnDisplayed();
    }
    /*
     * Enter the DSM Approve Prospect and Account Type (TRS)
     * */

    public static void searchAccountToActivate(String accountName, String accountType) {
        searchScreenPage.searchAccountToActivate(accountName, accountType);
    }
    /*
     * Search Screen fields UI Verification
     * */
    public static boolean isAccountNameStreetAddressCityFieldDisplayed() {

        return searchScreenPage.isAccountNameStreetAddressCityFieldDisplayed();
    }
    public static boolean isAccountTypeFieldDisplayed() {
        return searchScreenPage.isAccountTypeFieldDisplayed();
    }
    public static boolean isSearchButtonDisplayed() {
        return searchScreenPage.isSearchButtonDisplayed();
    }

}