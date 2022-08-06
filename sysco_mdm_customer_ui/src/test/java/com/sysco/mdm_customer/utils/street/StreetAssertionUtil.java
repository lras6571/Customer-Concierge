package com.sysco.mdm_customer.utils.street;

import com.sysco.mdm_customer.data.ActivateProspectData;
import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountData;
import com.sysco.mdm_customer.functions.street.*;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.TestBase;


public class StreetAssertionUtil extends TestBase {


    /*
     * Assert Street Account CCA Flow
     * */
    public static void assertBusinessInformationData(String accountType,String mobileNumber) {
        ShipToConfirmation.collectBusinessInformationDataForSTREETAccounts();
       // softAssert.assertEquals(ShipToConfirmation.getBusinessInformation(ActivateProspectData.CONFIRM_ACCOUNT_NAME), prospectName, StreetAccountAssertionMessage.INCORRECT_ACCOUNT_NAME);
        softAssert.assertEquals(ShipToConfirmation.getBusinessInformation(ActivateProspectData.CONFIRM_ACCOUNT_TYPE),accountType, StreetAccountAssertionMessage.INCORRECT_ACCOUNT_TYPE);
        softAssert.assertEquals(ShipToConfirmation.getBusinessInformation(ActivateProspectData.CONFIRM_ACCOUNT_PHONE), mobileNumber, StreetAccountAssertionMessage.INCORRECT_ACCOUNT_PHONE_NUMBER);
        softAssert.assertAll();
    }

    public static void assertShippingAddressInformationData(String accountStreet,String accountCity,String accountPostalCode,String accountCountry) {
        ShipToConfirmation.collectShippingAddressInformation();
        softAssert.assertEquals(ShipToConfirmation.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_STREET), accountStreet, StreetAccountAssertionMessage.INCORRECT_SHIPPING_STREET);
        softAssert.assertEquals(ShipToConfirmation.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_CITY), accountCity, StreetAccountAssertionMessage.INCORRECT_SHIPPING_CITY);
        softAssert.assertEquals(ShipToConfirmation.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_POSTAL_CODE), accountPostalCode, StreetAccountAssertionMessage.INCORRECT_SHIPPING_POSTAL);
        softAssert.assertEquals(ShipToConfirmation.getShippingAddress(StreetAccountData.CONFIRM_SHIPPING_COUNTRY), accountCountry, StreetAccountAssertionMessage.INCORRECT_SHIPPING_COUNTRY);
        softAssert.assertAll();
    }
    public static void assertContactInformationData(String firstName,String lastName,String streetEmail,String mobileNumber) {
        ShipToConfirmation.collectNewContactInformation();
        String contactName = firstName + " " + lastName;
        softAssert.assertEquals(ShipToConfirmation.getNewContactInformation(StreetAccountData.NAME), contactName, StreetAccountAssertionMessage.INCORRECT_PRINCIPLE_CONTACT_NAME);
        softAssert.assertEquals(ShipToConfirmation.getNewContactInformation(StreetAccountData.EMAIL),streetEmail, StreetAccountAssertionMessage.INCORRECT_PRINCIPLE_CONTACT_EMAIL);
        softAssert.assertEquals(ShipToConfirmation.getNewContactInformation(StreetAccountData.PHONE), mobileNumber, StreetAccountAssertionMessage.INCORRECT_PRINCIPLE_CONTACT_NUMBER);

    }
    public static void assertDeliveryPreferenceData(String deliveryDay,String deliveryWindow1Start,String deliveryWindow1End,String backdoorOpen,String backdoorClose) {
        ShipToConfirmation.collectDeliveryPreferenceData();
        softAssert.assertEquals(ShipToConfirmation.getDeliveryPreferenceData(StreetAccountData.DELIVERY_DAY), deliveryDay, StreetAccountAssertionMessage.INCORRECT_DELIVERY_DAY);
        softAssert.assertEquals(ShipToConfirmation.getDeliveryPreferenceData(StreetAccountData.STANDARD_DELIVERY_WINDOW_START), deliveryWindow1Start, StreetAccountAssertionMessage.INCORRECT_DELIVERY_WINDOW_START);
        softAssert.assertEquals(ShipToConfirmation.getDeliveryPreferenceData(StreetAccountData.STANDARD_DELIVERY_WINDOW_END), deliveryWindow1End, StreetAccountAssertionMessage.INCORRECT_DELIVERY_WINDOW_END);
        softAssert.assertEquals(ShipToConfirmation.getDeliveryPreferenceData(StreetAccountData.STANDARD_BACKDOOR_START), backdoorOpen, StreetAccountAssertionMessage.INCORRECT_DELIVERY_BOOK_START);
        softAssert.assertEquals(ShipToConfirmation.getDeliveryPreferenceData(StreetAccountData.STANDARD_BACKDOOR_END), backdoorClose, StreetAccountAssertionMessage.INCORRECT_DELIVERY_BOOK_END);

    }

    /*
     * Assert Street Account CCA Flow Search Screen
     * */
    public static void assertSearchScreenUI() {

        softAssert.assertTrue(SearchScreen.isAccountNameStreetAddressCityFieldDisplayed(), "Account Name/Street Address/ City Field is not Displayed");
        softAssert.assertTrue(SearchScreen.isAccountTypeFieldDisplayed(), "Account Type Field is not Displayed");
        softAssert.assertTrue(SearchScreen.isSearchButtonDisplayed(), "Account Type Field is not Displayed");
        softAssert.assertAll();
    }
    /*
     * Assert Street Account CCA Flow Account Info Screen
     * */
    public static void assertAccountInfoScreenUI() {
        softAssert.assertTrue(ShipToInfo.isAccountInfoFieldDisplayed(), "Account Name or Phone or Account Group or Address Street or City or State or Postal CodeCountry Fields are not Displayed");
        softAssert.assertAll();
    }
    /*
     * Assert Street Account CCA Flow Contact Info Screen
     * */
    public static void assertContactInfoScreenUI() {
        softAssert.assertTrue(ContactInfo.isContactInfoFieldDisplayed(), "Contact Owner or Principal Officer Fields are not Displayed");
        softAssert.assertAll();
    }
    /*
     * Assert Street Account CCA Flow Contact Info Screen
     * */
    public static void assertDeliveryPreferencesScreenUI() {
        softAssert.assertTrue(DeliveryPreferences.isDeliveryPreferencesFieldDisplayed(), "Contact Owner or Principal Officer Fields are not Displayed");
        softAssert.assertAll();
    }
    /*
     * Assert Street Account CCA Flow Cuisine Info Screen
     * */
    public static void assertCuisineInfoScreenUI() {
        softAssert.assertTrue(CuisineInfo.isCuisineInfoFieldDisplayed(), "Contact Owner or Principal Officer Fields are not Displayed");
        softAssert.assertAll();
    }

}