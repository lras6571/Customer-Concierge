package com.sysco.mdm_customer.tests.usbl.accountCreation.street;

import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.street.*;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.StreetAssertionUtil;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.common.Constants.*;

public class StreetAdditionalLocationTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    CommonModelGETStreetAccountDetails streetAccountDetailsGETData;
    GetStreetAccountRequest expectedStreetRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_STREET_ACC_CREATION);
    }


    @Test(description = "MDMC-TC-5096", priority = 1)
    public void testVerifyUSBLAdditionalLocationSearchScreenFunctionality() {
        /*
         * Select the Active Account from the Search Screen
         *
         * */
        streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedStreetRequest.getMarketingAssociate());
        Wizard.createSTREETSecondaryShipToAccount();
        Wizard.searchAccountToActivate(expectedStreetRequest.getActiveAccountName(), expectedStreetRequest.getAccountRoles().get(0).getAccountRole());
        softAssert.assertTrue(AccountSearch.isAccountSearched(expectedStreetRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_LOAD);
        AccountSearch.selectNewLocation();
        Wizard.chooseShipTo(true);

        /*
         * Select the Prospect from the Search Screen
         *
         * */
        softAssert.assertTrue(SearchScreen.isActivateProspectHomeScreenDisplayed(), StreetAccountAssertionMessage.HOME_SCREEN_NOT_DISPLAY);

    }

    @Test(description = "MDMC-TC-5095", priority = 1)
    public void testVerifyUSBLAdditionalLocationSearchScreenUI() {
        StreetAssertionUtil.assertSearchScreenUI();
        SearchScreen.searchAccountToActivate(expectedStreetRequest.getProspectName(), String.valueOf(expectedStreetRequest.getAccountTypes().get(0).getAccountType()));
    }

    @Test(description = "MDMC-TC-5097", priority = 2)
    public void testVerifyUSBLAdditionalLocationAccountInfoScreenUI() {
        // Enter the detail that wanted to fill the Account Info Screen
        StreetAssertionUtil.assertAccountInfoScreenUI();
    }

    @Test(description = "MDMC-TC-5098", priority = 3)
    public void testVerifyUSBLAdditionalLocationAccountInfoScreenFunctionality() {

        ShipToInfo.enterShipToPhoneNumber(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountPhone()));
        ShipToInfo.selectShipToAccountGroup(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountGroup()));
        ShipToInfo.enterShippingStreet(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountStreet()));
        ShipToInfo.enterShippingCity(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountCity()));
        ShipToInfo.enterShippingPostalCode(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountPostalCode()));
        ShipToInfo.selectShipToCountry(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountCountry()));
        ShipToInfo.selectShippingState(String.valueOf(expectedStreetRequest.getAccountInfo().get(0).getAccountState()));
        AccountSearch.navigateToNextTab();
        ShipToInfo.confirmShipAddress();
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5099", priority = 4)
    public void testVerifyUSBLAdditionalLocationContactInfoScreenUI() {

        // Contact Info Screen Verification
        ShipToInfo.confirmPrincipalOwnerofTheAccount();
        StreetAssertionUtil.assertContactInfoScreenUI();
    }

    @Test(description = "MDMC-TC-5100", priority = 5)
    public void testVerifyUSBLAdditionalLocationContactInfoScreenFunctionality() {

        ContactInfo.enterFirstName(expectedStreetRequest.getContactInfo().get(0).getFirstName());
        ContactInfo.enterLastName(expectedStreetRequest.getContactInfo().get(0).getLastName());
        ContactInfo.enterEmailAddress(expectedStreetRequest.getContactInfo().get(0).getStreetEmail());
        ContactInfo.enterTelephoneNumber(expectedStreetRequest.getContactInfo().get(0).getMobileNumber());
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5101", priority = 6)
    public void testVerifyUSBLAdditionalLocationDeliveryPreferencesScreenUI() {

        // Delivery Preferences Screen Verification

        DeliveryPreferences.confirmDeliveryPreferences();
        StreetAssertionUtil.assertDeliveryPreferencesScreenUI();
    }

    @Test(description = "MDMC-TC-5102", priority = 7)
    public void testVerifyUSBLAdditionalLocationDeliveryPreferencesScreenFunctionality() {

        DeliveryPreferences.enterDeliveryDate(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryDay());
        DeliveryPreferences.enterDeliveryWindowStartTime(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryWindow1Start());
        DeliveryPreferences.enterDeliveryWindowEndTime(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryWindow1End());
        DeliveryPreferences.enterBackdoorOpenTime(expectedStreetRequest.getDeliveryPreference().get(0).getBackdoorOpen());
        DeliveryPreferences.enterBackdoorCloseTime(expectedStreetRequest.getDeliveryPreference().get(0).getBackdoorClose());
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5104", priority = 8)
    public void testVerifyUSBLAdditionalLocationCuisineInfoScreenFunctionality() {

        // Cuisine Info Screen Verification
        String strCuisineType = expectedStreetRequest.getCuisineAndOperation().get(0).getTypeOfCuisine();
        String strOperationType = expectedStreetRequest.getCuisineAndOperation().get(0).getTypeOfOperation();
        String strLocalOperationType = expectedStreetRequest.getCuisineAndOperation().get(0).getLocalTypeOfOperation();
        CuisineInfo.setCuisineInfo(strCuisineType, strOperationType, strLocalOperationType);
    }

    @Test(description = "MDMC-TC-5103", priority = 9)
    public void testVerifyUSBLAdditionalLocationCuisineInfoScreenUI() {

        StreetAssertionUtil.assertCuisineInfoScreenUI();
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5105", priority = 10)
    public void testVerifyUSBLAdditionalLocationShipToConfirmationScreenFunctionality() {
        //Ship To Confirmation Screen Verification
        StreetAssertionUtil.assertBusinessInformationData(expectedStreetRequest.getAccountTypes().get(0).getAccountType(), expectedStreetRequest.getAccountInfo().get(0).getAccountPhone());
        StreetAssertionUtil.assertShippingAddressInformationData(expectedStreetRequest.getAccountInfo().get(0).getAccountStreet(), expectedStreetRequest.getAccountInfo().get(0).getAccountCity(), expectedStreetRequest.getAccountInfo().get(0).getAccountPostalCode(), "US");
        StreetAssertionUtil.assertContactInformationData(expectedStreetRequest.getContactInfo().get(0).getFirstName(), expectedStreetRequest.getContactInfo().get(0).getLastName(), expectedStreetRequest.getContactInfo().get(0).getStreetEmail(), expectedStreetRequest.getContactInfo().get(0).getMobileNumber());
        AccountSearch.navigateToNextTab();


    }

}