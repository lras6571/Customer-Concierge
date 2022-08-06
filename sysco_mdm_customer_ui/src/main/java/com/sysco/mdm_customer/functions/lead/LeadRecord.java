package com.sysco.mdm_customer.functions.lead;

import com.sysco.mdm_customer.pages.lead.LeadRecordPage;

public class LeadRecord {

    private LeadRecord(){
            }

    private static final LeadRecordPage leadRecordPage = new LeadRecordPage();


    //Click Convert Button
    public static void startLeadConversion() {

        leadRecordPage.startLeadConversion();
    }


    //Enter Name and OpCo details to the Lead Convert Window
    public static void enterRecordOwner(String strOpCoID, String strOwner) {

        leadRecordPage.enterRecordOwner(strOpCoID, strOwner);
    }


    //Enter the Account Name
    public static void setAccountName(){

        leadRecordPage.setAccountName();
    }


    //Enter the Territory Name
    public static void setTerritory(String strTerritory){

        leadRecordPage.setTerritory(strTerritory);
    }

    //Tick Reminder Check Box
    public static void setReminder(boolean strReminder){

        leadRecordPage.setReminder(strReminder);
    }


    //Click Convert Button
    public static void finishLeadConversion() {

        leadRecordPage.finishLeadConversion();
    }



}
