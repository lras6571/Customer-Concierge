package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.NavigateToAccountsProspectsPage;

public class NavigateToAccountsProspects {
    public static final com.sysco.mdm_customer.pages.NavigateToAccountsProspectsPage NavigateToAccountsProspectsPage = new NavigateToAccountsProspectsPage();

    private NavigateToAccountsProspects() {
    }

    /*
     * Navigate to Accounts/Prospects
     * */
    public static void selectAccountProspectTab() {

        NavigateToAccountsProspectsPage.selectAccountsProspectTab();
    }

    /*
     * Select the Active Account
     * */
    public static void selectActiveAccount(String listFilter) {

        NavigateToAccountsProspectsPage.selectActiveAccount(listFilter);
    }

    /*
     * Verify the Active Account Status
     * */
    public static boolean isAccountStatusActive(String activeAccountName) {
        return NavigateToAccountsProspectsPage.isAccountStatusActive(activeAccountName);
    }

    //Click Lead Tab
    public static void selectLeads() {

        NavigateToAccountsProspectsPage.selectLeads();
    }
}