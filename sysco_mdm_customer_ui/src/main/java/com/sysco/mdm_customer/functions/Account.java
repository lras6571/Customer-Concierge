package com.sysco.mdm_customer.functions;


import com.sysco.mdm_customer.pages.street.AccountPage;

public class Account {
    public static final AccountPage accountPage = new AccountPage();

    private Account() {
    }

    /*
     * Click Create Request Option in Active Account
     * */
    public static void clickCreateRequest() {

        accountPage.clickCreateRequest();
    }

    /*
     * Select Inactivation Option in Account Maintenance
     * */
    public static void selectInactivationRadioButton() {

        accountPage.selectInactivationRadioButton();
    }
    /*
     * Select Reactivation Option in Account Maintenance
     * */
    public static void selectReactivationRadioButton() {

        accountPage.selectReactivationRadioButton();
    }
    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Shipping address details of all account types
     * */

    public static void collectShippingAddressInformation() {
        accountPage.collectShippingAddressInformation();
    }

    public static String getShippingAddress(String fieldName) {
        return accountPage.getShippingAddress(fieldName);
    }

    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Billing address details of all account types
     * */
    public static void collectBillingAddressInformation() {
        accountPage.collectBillingAddressInformation();
    }

    public static String getBillingAddress(String fieldName) {
        return accountPage.getBillingAddress(fieldName);
    }

    /*
     * Request to Inactivate/Reactive Account Screen SR Verification
     *
     * */
    public static void selectSupportRequest() {
        accountPage.selectSupportRequest();
    }


    //Select the SR
    public static void selectCFEASupportRequest() {

        accountPage.selectCFEASupportRequest();
    }

    /*
     * Verify the SR Case Request Type
     * */
    public static String verifyCaseRequestType() {
        return accountPage.verifyCaseRequestType();
    }
    /*
     * Verify the Initiate Ship To Screen Account Create/Maintain
     * */
    public static String verifyInitiateShipToScreenAccountCreateMaintain() {
        return accountPage.verifyInitiateShipToScreenAccountCreate();
    }
    /*
     * Verify the Initiate Ship To Screen Status
     * */
    public static String verifyInitiateShipToScreenStatus() {
        return accountPage.verifyInitiateShipToScreenStatus();
    }
    /*
     * Verify the Initiate Ship To Screen Credit Application Status
     * */
    public static String verifyInitiateShipToScreenCreditApplicationStatus() {
        return accountPage.verifyInitiateShipToScreenCreditApplicationStatus();
    }

    public static void viewRelatedContacts(String accountName){
         accountPage.viewRelatedContacts(accountName);
    }
    /*
     * Verify the Initiate Ship To Screen Email Credit Application CheckBox
     * */
    public static boolean isEmailCreditApplicationCheckboxChecked() {
        return accountPage.isEmailCreditApplicationCheckboxChecked();
    }
    /*
     * Verify the Initiate Ship To Screen Account Role
     * */
    public static String verifyInitiateShipToScreenAccountRole() {
        return accountPage.verifyInitiateShipToScreenAccountRole();
    }
    /*
     * Verify the Initiate Ship To Screen Application Request Type
     * */
    public static String verifyInitiateShipToApplicationRequestType() {
        return accountPage.verifyInitiateShipToApplicationRequestType();
    }
}