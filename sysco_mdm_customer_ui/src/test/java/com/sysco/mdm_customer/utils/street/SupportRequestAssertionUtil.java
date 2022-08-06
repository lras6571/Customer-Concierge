package com.sysco.mdm_customer.utils.street;

import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.functions.sr.SupportRequest;
import com.sysco.mdm_customer.functions.sr.SupportRequestDetail;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;

public class SupportRequestAssertionUtil extends TestBase {

    /*
     * Assert Inactivation /  Reactivation Flow Shipping Details
     * */
    public static void assertStreetAccountCreationFlowAfterAcceptCase(GetStreetAccountRequest expectedStreetRequest) {
        softAssert.assertEquals(SupportRequestDetail.verifySupportRequestOwner(), expectedStreetRequest.getSupportRequest().get(0).getSupportRequestOwner(), StreetAccountAssertionMessage.SUPPORT_REQUEST_OWNER_INCORRECT);
        softAssert.assertEquals(SupportRequestDetail.verifyStatus(), expectedStreetRequest.getSupportRequest().get(0).getStatus(), StreetAccountAssertionMessage.SUPPORT_REQUEST_STATUS_INCORRECT);
        softAssert.assertAll();

    }

    public static void assertCreditApplicationStatusAfterApproval(GetStreetAccountRequest expectedStreetRequest) {
        softAssert.assertEquals(SupportRequestDetail.verifyInitiateSRScreenCreditApplicationStatus(), expectedStreetRequest.getSupportRequest().get(0).getCreditApplicationStatusAfterApproval(), StreetAccountAssertionMessage.SUPPORT_REQUEST_STATUS_INCORRECT);
        softAssert.assertAll();

    }

    /*
     * Assert initiate SR Screen
     * */
    public static void assertInitiateSRScreen(GetStreetAccountRequest expectedStreetRequest) {
        softAssert.assertEquals(SupportRequestDetail.verifySupportRequestOwner(), expectedStreetRequest.getSupportRequest().get(0).getSupportRequestOwner(), StreetAccountAssertionMessage.SUPPORT_REQUEST_OWNER_INCORRECT);
        softAssert.assertEquals(SupportRequestDetail.verifyStatus(), expectedStreetRequest.getSupportRequest().get(0).getStatus(), StreetAccountAssertionMessage.SUPPORT_REQUEST_STATUS_INCORRECT);
        softAssert.assertEquals(SupportRequestDetail.verifyInitiateSRScreenCaseRequestType(), expectedStreetRequest.getSupportRequest().get(0).getCaseRequestType(), StreetAccountAssertionMessage.SUPPORT_REQUEST_STATUS_INCORRECT);
        softAssert.assertEquals(SupportRequestDetail.verifyInitiateSRScreenCreditApplicationStatus(), expectedStreetRequest.getSupportRequest().get(0).getStatus(), StreetAccountAssertionMessage.SUPPORT_REQUEST_STATUS_INCORRECT);
        softAssert.assertTrue(SupportRequestDetail.verifyInitiateSRScreenREQNumber().contains("CA-"), "REQ# Number ");
        softAssert.assertAll();

    }

}
