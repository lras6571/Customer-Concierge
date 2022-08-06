package com.sysco.mdm_customer.functions.sbsuser;

import com.sysco.mdm_customer.pages.sbsuser.SBSUserHomePage;


public class SBSUserHome {


     public static final SBSUserHomePage sbsUserHomePage = new SBSUserHomePage();


    //Select the Support Request Tab
    public static void clickSupportRequestTab() {

        sbsUserHomePage.clickSupportRequestTab();
    }


    //Select the Master Data Queue Filter
    public static void selectMasterDataQueue(String supportRequestFilter) {

        sbsUserHomePage.selectMasterDataQueue(supportRequestFilter);
    }


    //Select the Records by Time
    public static void clickTimeColumn() {

        sbsUserHomePage.clickTimeColumn();
    }


    //Select the First Record
    public static void selectFirstRecord() {

        sbsUserHomePage.selectFirstRecord();
    }
}
