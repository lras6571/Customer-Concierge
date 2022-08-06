package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.pages.ConciergeLobbyPage;

public class ConciergeLobby {

    public static final ConciergeLobbyPage conciergeLobbyPage = new ConciergeLobbyPage();

    private ConciergeLobby() {
    }


    //Click Lead Account Creation Icon
    public static void clickLeadCreation() {

        conciergeLobbyPage.clickLeadCreationIcon();
    }


    //Click Street Account Creation Icon
    public static void clickStreetCreation() {

        conciergeLobbyPage.clickStreetAccountIcon();
    }


    //Click CADD Account Creation Icon
    public static void clickCADDCreation() {

        conciergeLobbyPage.clickCADDAccountIcon();
    }


    //Click CFEA Lead Creation Icon
    public static void clickCFEALeadCreationIcon() {

        conciergeLobbyPage.clickCFEALeadCreationIcon();
    }


    //Click CFEA Accounts Creation Icon
    public static void clickCFEAAccountIcon() {

        conciergeLobbyPage.clickCFEAAccountIcon();
    }
}
