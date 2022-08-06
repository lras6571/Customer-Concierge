package com.sysco.mdm_customer.functions.sr;

import com.sysco.mdm_customer.pages.sr.SupportRequestPage;

public class SupportRequest {


    private static final SupportRequestPage supportRequestPage = new SupportRequestPage();


    public static void viewSupportRequests() {

        supportRequestPage.viewSupportRequests();
    }


    public static void viewFirstSupportRequest() {

        supportRequestPage.viewFirstSupportRequest();
    }


    public static boolean isRequestAssignedToUser(String accountOwner){
        return supportRequestPage.isRequestAssignedToMA(accountOwner);
    }


    public static boolean isRequestAssignedToTeam(String team){
        return supportRequestPage.isRequestAssignedToTeam(team);
    }

}
