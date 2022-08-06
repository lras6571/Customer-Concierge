package com.sysco.mdm_customer.functions.sr;

import com.sysco.mdm_customer.pages.sr.SupportRequestDetailPage;

public class SupportRequestDetail {
    public static final SupportRequestDetailPage supportRequestDetailPage = new SupportRequestDetailPage();

    public static String verifySupportRequestOwner(){

        return supportRequestDetailPage.verifySupportRequestOwner();
    }

    public static String verifyStatus(){
        return supportRequestDetailPage.verifyStatus();
    }

    public static String verifyInitiateSRScreenCaseRequestType(){
        return supportRequestDetailPage.verifyInitiateSRScreenCaseRequestType();
    }
    public static String verifyInitiateSRScreenCreditApplicationStatus(){
        return supportRequestDetailPage.verifyInitiateSRScreenCreditApplicationStatus();
    }
    public static String verifyInitiateSRScreenREQNumber(){
        return supportRequestDetailPage.verifyInitiateSRScreenREQNumber();
    }
}
