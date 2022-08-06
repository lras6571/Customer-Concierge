package com.sysco.mdm_customer.utils.street;

import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountData;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;

public class AsianFoodInactivationReactivationAssertionUtil extends TestBase {

    /*
     * Assert Inactivation /  Reactivation Flow Shipping Details
     * */
    public static void assertInactivationReactivationScreenShippingDetail(AFLeadAccountRequest expectAFLeadRequest) {
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_STREET), expectAFLeadRequest.getAccountInfo().get(0).getAccountStreet(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_STREET);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_CITY), expectAFLeadRequest.getAccountInfo().get(0).getAccountCity(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_CITY);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_STATE), expectAFLeadRequest.getAccountInfo().get(0).getAccountState(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_STATE);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_POSTAL_CODE), expectAFLeadRequest.getAccountInfo().get(0).getAccountPostalCode(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_POSTAL);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_COUNTRY), expectAFLeadRequest.getAccountInfo().get(0).getAccountCountry(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_COUNTRY);
        softAssert.assertAll();

    }

    /*
     * Assert Inactivation /  Reactivation Flow Billing Details
     * */
    public static void assertInactivationReactivationScreenBillingDetail(AFLeadAccountRequest expectAFLeadRequest) {
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_STREET), expectAFLeadRequest.getBillToInfo().get(0).getBillingStreet(), StreetAccountAssertionMessage.INCORRECT_BILLING_STREET);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_CITY), expectAFLeadRequest.getBillToInfo().get(0).getBillingCity(), StreetAccountAssertionMessage.INCORRECT_BILLING_CITY);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_STATE), expectAFLeadRequest.getBillToInfo().get(0).getBillingState(), StreetAccountAssertionMessage.INCORRECT_BILLING_STATE);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_POSTAL_CODE), expectAFLeadRequest.getBillToInfo().get(0).getBillingPostalCode(), StreetAccountAssertionMessage.INCORRECT_BILLING_POSTAL);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_SHIPPING_COUNTRY), expectAFLeadRequest.getBillToInfo().get(0).getBillingCountry(), StreetAccountAssertionMessage.INCORRECT_BILLING_COUNTRY);
        softAssert.assertAll();
    }

    /*
     * Assert Inactivation /  Reactivation Flow Ship To Screen
     * */
    public static void assertInactivationReactivationSRScreen(AFLeadAccountRequest expectAFLeadRequest, String caseRequestType) {
        softAssert.assertEquals(Account.verifyCaseRequestType(), caseRequestType, "SR Case Request Type is not Reactive/Inactive");
        softAssert.assertAll();

    }
}
