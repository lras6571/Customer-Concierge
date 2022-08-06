package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.WizardPage;

public class Wizard {
    public static final WizardPage WizardPage = new WizardPage();


    public static void identifyCustomer(boolean bExistingCustomer) {

        WizardPage.identifyCustomer(bExistingCustomer);
    }

    public static void chooseExperience(String sExperience) {
        WizardPage.chooseExperience(sExperience);
    }

    public static void chooseShipTo(boolean bProspectAvailable) {
        WizardPage.chooseShipTo(bProspectAvailable);
    }

    public static void createSTREETNewNetAccount() {
        ConciergeLobby.clickStreetCreation();
        Wizard.identifyCustomer(false);
        Wizard.chooseExperience("Prospect");
        Wizard.chooseShipTo(true);
    }
    public static void createSTREETSecondaryShipToAccount() {
        ConciergeLobby.clickStreetCreation();
        Wizard.identifyCustomer(true);


    }
    //Search for an Existing Account
    public static void searchAccountToActivate(String sBillToNameId,String accountRole) {

        WizardPage.searchBillToOrShipTo(sBillToNameId,accountRole);
    }

    public static void createNetNewAccount() {

        Wizard.identifyCustomer(false);
    }

    public static void createCADDSecondaryAccount() {

        Wizard.chooseShipTo(true);
    }


    //To create new prospect shop account
    public static void openProspectShopForm() {

        ConciergeLobby.clickStreetCreation();
        WizardPage.identifyCustomer(false);
        WizardPage.chooseExperience("Prospect Shop");
        WizardPage.chooseShipTo(false);
    }


    //To search the prospect that needs to be converted to prospect shop account
    public static void openProspectShopConversionForm() {

        ConciergeLobby.clickStreetCreation();
        WizardPage.identifyCustomer(false);
        WizardPage.chooseExperience("Prospect Shop");
        WizardPage.chooseShipTo(true);
    }


    public static void createCFEANewNetAccount() {

        Wizard.identifyCustomer(true);
    }
}
