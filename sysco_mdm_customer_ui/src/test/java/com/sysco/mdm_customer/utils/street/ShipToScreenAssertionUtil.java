package com.sysco.mdm_customer.utils.street;

import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;

public class ShipToScreenAssertionUtil extends TestBase {
    /*
     * Assert Inactivation /  Reactivation Flow Shipping Details
     * */
    public static void assertInitiateShipToScreen(GetStreetAccountRequest expectedStreetRequest) {

        softAssert.assertEquals(Account.verifyInitiateShipToScreenAccountCreateMaintain(), "Initiated", "Account Create/Maintain is not Initiated");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenStatus(), "Prospect", "Status is not Prospect");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenCreditApplicationStatus(), "Transmitted", "Credit Application Status is not Transmitted");
        softAssert.assertTrue(Account.isEmailCreditApplicationCheckboxChecked(), "emil Credit Application is not checked");
        softAssert.assertEquals(Account.verifyInitiateShipToScreenAccountRole(), "Ship To", "Credit Application Status is not Transmitted");
        softAssert.assertEquals(Account.verifyInitiateShipToApplicationRequestType(), "Ship To", "Credit Application Status is not Transmitted");
        softAssert.assertAll();

    }

}
