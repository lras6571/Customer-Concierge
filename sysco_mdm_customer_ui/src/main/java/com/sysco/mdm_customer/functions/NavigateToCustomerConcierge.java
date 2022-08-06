package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.NavigateToCustomerConciergePage;

public class NavigateToCustomerConcierge {
    static NavigateToCustomerConciergePage NavigateToCustomerConciergePage = new NavigateToCustomerConciergePage();

    private NavigateToCustomerConcierge() {
    }

    /*
     * Navigate to Customer Concierge Lobby
     *
     * */
    public static void selectCustomerConcierge() {
        NavigateToCustomerConciergePage.selectCustomerConcierge();
    }
}