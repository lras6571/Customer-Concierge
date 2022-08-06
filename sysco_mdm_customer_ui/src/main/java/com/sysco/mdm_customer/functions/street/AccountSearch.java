package com.sysco.mdm_customer.functions.street;


import com.sysco.mdm_customer.pages.street.AccountSearchPage;


public class AccountSearch {

    static AccountSearchPage accountSearchPage = new AccountSearchPage();

    private AccountSearch() {
    }

    /*
     * Navigate To the Next Page
     * */
    public static void navigateToNextTab() {
        accountSearchPage.navigateToNextTab();
    }

    /*
     * Already Active Account Search
     * */
    public static boolean isAccountSearched(String searchedAccountName) {
        return accountSearchPage.isAccountSearched(searchedAccountName);
    }

    /*
     * Select Secondary Location Account
     * */
    public static void selectSecondaryLocationAddShipTo(String primaryAccountName) {
        accountSearchPage.selectSecondaryLocationAddShipTo(primaryAccountName);
    }

    /*
     * Select New Location Button
     * */
    public static void selectNewLocation() {
        accountSearchPage.selectNewLocation();

    }
}