package com.sysco.mdm_customer.utils.lead;

import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.models.request.GetLeadAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;
import org.junit.Assert;

public class ApprovedLeadAssertionUtil extends TestBase {


    //Assertions of Approved Ship To - After the Approval of DSM
    public static void assertInitiateShipToScreen(String accountCreateMaintain,String status,String creditApplicationStatus,String accountRole,String applicationRequestType ) {

        softAssert.assertEquals(Account.verifyInitiateShipToScreenAccountCreateMaintain(), accountCreateMaintain, "Account Create/Maintain is not Initiated");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenStatus(), status, "Status is not Prospect");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenCreditApplicationStatus(), creditApplicationStatus, "Credit Application Status is not Transmitted");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenAccountRole(), accountRole, "Account Role is not Ship To");
        softAssert.assertEquals(Account.verifyInitiateShipToApplicationRequestType(), applicationRequestType, "Application Request Type is not Credit Application");
        softAssert.assertAll();
    }


    //Assertions of Approved Ship To - After the Approval of DSM
    public static void assertInitiateShipToScreenProspect(GetLeadAccountRequest expectedLeadAccountRequest) {

        Assert.assertEquals("Status is not Prospect", "Prospect", Account.verifyInitiateShipToScreenStatus());
    }
}
