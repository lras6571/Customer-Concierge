package com.sysco.mdm_customer.utils.street;

import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountData;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;

public class InactivationReactivationAssertionUtil extends TestBase {

    /*
     * Assert Inactivation /  Reactivation Flow Shipping Details
     * */
    public static void assertInactivationReactivationScreenShippingDetail(GetStreetAccountRequest expectedStreetRequest) {
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_STREET), expectedStreetRequest.getAccountInfo().get(0).getAccountStreet(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_STREET);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_CITY), expectedStreetRequest.getAccountInfo().get(0).getAccountCity(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_CITY);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_STATE), expectedStreetRequest.getAccountInfo().get(0).getAccountState(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_STATE);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_POSTAL_CODE), expectedStreetRequest.getAccountInfo().get(0).getAccountPostalCode(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_POSTAL);
        softAssert.assertEquals(Account.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_COUNTRY), expectedStreetRequest.getAccountInfo().get(0).getAccountCountry(), StreetAccountAssertionMessage.INCORRECT_SHIPPING_COUNTRY);
        softAssert.assertAll();

    }

    /*
     * Assert Inactivation /  Reactivation Flow Billing Details
     * */
    public static void assertInactivationReactivationScreenBillingDetail(GetStreetAccountRequest expectedStreetRequest) {
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_STREET), expectedStreetRequest.getBillToInfo().get(0).getBillingStreet(), StreetAccountAssertionMessage.INCORRECT_BILLING_STREET);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_CITY), expectedStreetRequest.getBillToInfo().get(0).getBillingCity(), StreetAccountAssertionMessage.INCORRECT_BILLING_CITY);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_STATE), expectedStreetRequest.getBillToInfo().get(0).getBillingState(), StreetAccountAssertionMessage.INCORRECT_BILLING_STATE);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_BILLING_POSTAL_CODE), expectedStreetRequest.getBillToInfo().get(0).getBillingPostalCode(), StreetAccountAssertionMessage.INCORRECT_BILLING_POSTAL);
        softAssert.assertEquals(Account.getBillingAddress(StreetAccountData.CONFIRM_SHIPPING_COUNTRY), expectedStreetRequest.getBillToInfo().get(0).getBillingCountry(), StreetAccountAssertionMessage.INCORRECT_BILLING_COUNTRY);
        softAssert.assertAll();
    }

    /*
     * Assert Inactivation /  Reactivation Flow Ship To Screen
     * */
    public static void assertInactivationReactivationSRScreen(GetStreetAccountRequest expectedStreetRequest, String caseRequestType) {
        softAssert.assertEquals(Account.verifyCaseRequestType(), caseRequestType, "SR Case Request Type is not Reactive");
        softAssert.assertAll();

    }
}
