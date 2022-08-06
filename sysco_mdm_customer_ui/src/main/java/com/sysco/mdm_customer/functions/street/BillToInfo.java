package com.sysco.mdm_customer.functions.street;

import com.sysco.mdm_customer.pages.street.BillToInfoPage;


public class BillToInfo {
    static BillToInfoPage billToInfoPage = new BillToInfoPage();

    private BillToInfo() {
    }

    /*
     * Select the Send Credit Application Option
     * */
    public static void sendCreditApplication(boolean bSend) {
        billToInfoPage.sendCreditApplication(bSend);
    }

    public static void initiateAccount() {
        billToInfoPage.initiateAccount();
    }
    /*
     * Enter Bill To Confirmation Screen Data
     * */

    public static void createNewBillTo(String billName, String billToStreet, String billCity, String billState, String postalCode) {
        billToInfoPage.createNewBillTo(billName, billToStreet, billCity, billState, postalCode);
    }
}