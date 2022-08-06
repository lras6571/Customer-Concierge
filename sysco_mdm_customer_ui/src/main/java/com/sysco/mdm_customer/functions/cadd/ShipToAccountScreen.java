package com.sysco.mdm_customer.functions.cadd;

import com.sysco.mdm_customer.pages.cadd.CADDShipToAccountPage;

public class ShipToAccountScreen {

    private ShipToAccountScreen(){
    }

    private static final CADDShipToAccountPage caddShipToAccountPage = new CADDShipToAccountPage();

    //Get the Current URL
    public static void getCurrentURL() {

        caddShipToAccountPage.getCurrentURL();
    }

    //Get the Current URL of FreshPoint
    public static void getFreshPointCurrentURL() {

        caddShipToAccountPage.getFreshPointCurrentURL();
    }


    //Get SSAID of the Ship to Address
    public static String getSSAID() {

        return caddShipToAccountPage.getSSAID();
    }


    //Get SSAID of the Ship to Address
    public static String getSSAIDBillTo() {

        return caddShipToAccountPage.getSSAIDBillTo();
    }


    //Click Bill to Button
    public static void openBillTo(){

        caddShipToAccountPage.openBillTo();
    }

    //Click Bill to Button
    public static void openSecondaryBillTo(String secondaryBillTo){

        caddShipToAccountPage.openSecondaryBillTo(secondaryBillTo);
    }


    //Click Back Button in Chrome
    public static  void navigateBack(){

        caddShipToAccountPage.navigateBack();
    }
}
