package com.sysco.mdm_customer.tests.usbl.accountCreation.cadd;

import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.*;
import com.sysco.mdm_customer.models.CommonModelGETCADDAccountDetails;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.GetCADDAccountRequest;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;


public class CADDNewTRSProfileTest extends TestBase {

    CommonModelGETCADDAccountDetails caddAccountDetailsGETData;
    GetCADDAccountRequest expectedCADDRequest;
    CommonModelGETStreetAccountDetails streetAccountDetailsGETData;
    GetStreetAccountRequest expectedStreetRequest;


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_CADD_ACC_CREATION);
    }


    @Test(description = "MDMC-TC-5329", priority = 1)
    public void verifyUSBLCADDNewSearchScreenUI() {
        caddAccountDetailsGETData = DataUtil.getCADDModelForReferenceKey("CADD_USER_LOGIN_01", commonModelGETCADDAccountDetailsList);
        expectedCADDRequest = caddAccountDetailsGETData.getRequest();
        streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey("STREET_USER_LOGIN_01", commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedStreetRequest.getMarketingAssociate());
        ConciergeLobby.clickCADDCreation();

        //Click National Account flow for Create CADD Accounts
        Wizard.createNetNewAccount();
        //Search Screen of CADD
        CADDSearchScreen.enterConceptDetails(expectedCADDRequest.getConceptName());
        CADDSearchScreen.searchTerritoryValuesTesMa(expectedCADDRequest.getTerritoryAssignment().get(0).getSite(), expectedCADDRequest.getTerritoryAssignment().get(0).getMarketingAssociate());
    }

    @Test(description = "MDMC-TC-5069", priority = 2)
    public void verifyUSBLCADDNewAccountInfoScreenFunctionality() {
        //Account Info Screen of CADD
        CADDAccountInfoScreen.enterAccountInfoDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountName(), expectedCADDRequest.getAccountInfo().get(0).getAccountPhone());
        CADDAccountInfoScreen.enterStoreNumberDetails(expectedCADDRequest.getAccountInfo().get(0).getStoreNumber());
        CADDAccountInfoScreen.enterCityAddressDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountStreet(), expectedCADDRequest.getAccountInfo().get(0).getAccountCity());
        CADDAccountInfoScreen.enterStateAddressDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountPostalCode(), expectedCADDRequest.getAccountInfo().get(0).getAccountState(), expectedCADDRequest.getAccountInfo().get(0).getAccountCountry());
    }

    @Test(description = "MDMC-TC-5071", priority = 3)
    public void verifyUSBLCADDNewContactInfoFunctionality() {

        //Contact Info Screen of CADD
        CADDContactInfoScreen.enterNameInfoDetails(expectedCADDRequest.getContactInfo().get(0).getFirstName(), expectedCADDRequest.getContactInfo().get(0).getLastName());
        CADDContactInfoScreen.enterContactInfoDetails(expectedCADDRequest.getContactInfo().get(0).getCaddEmail(), expectedCADDRequest.getContactInfo().get(0).getMobileNumber());
        CADDContactInfoScreen.clickNextAddressConfirm();

    }

    @Test(description = "MDMC-TC-5074", priority = 4)
    public void verifyUSBLCADDNewDeliveryPreferenceFunctionality() {
        //Delivery Preference Screen of CADD
        CADDDeliveryPreferenceScreen.enterDeliveryDate(expectedCADDRequest.getDeliveryPreference().get(0).getDeliveryDate());
        CADDDeliveryPreferenceScreen.enterDeliveryWindowStartTime(expectedCADDRequest.getDeliveryPreference().get(0).getStartTime());
        CADDDeliveryPreferenceScreen.enterDeliveryWindowEndTime(expectedCADDRequest.getDeliveryPreference().get(0).getEndTime());
        CADDDeliveryPreferenceScreen.enterBackdoorOpenTime(expectedCADDRequest.getDeliveryPreference().get(0).getOpenTime());
        CADDDeliveryPreferenceScreen.enterBackdoorCloseTime(expectedCADDRequest.getDeliveryPreference().get(0).getCloseTime());
        CADDDeliveryPreferenceScreen.clickDeliveryPreferenceInfo();
    }

    @Test(description = "MDMC-TC-50675", priority = 5)
    public void verifyUSBLCADDNewShipToConfirmationFunctionality() {
        //Ship To Confirmation Screen of CADD - Assertion
        CADDShipToConfirmationScreen.assertBusinessInformation(expectedCADDRequest.getConceptName(), CADDAccountInfoScreen.retrieveAccountName(expectedCADDRequest.getAccountInfo().get(0).getAccountName()), expectedCADDRequest.getCaddAccountType(), expectedCADDRequest.getAccountInfo().get(0).getAccountPhone(), expectedCADDRequest.getAccountInfo().get(0).getStoreNumber());
        CADDShipToConfirmationScreen.assertShippingInformation(expectedCADDRequest.getAccountInfo().get(0).getAccountPostalCode(), expectedCADDRequest.getAccountInfo().get(0).getAccountState(), expectedCADDRequest.getAccountInfo().get(0).getAccountStreet(), expectedCADDRequest.getAccountInfo().get(0).getAccountCity());
        CADDShipToConfirmationScreen.assertContactName(expectedCADDRequest.getContactInfo().get(0).getFullName(), expectedCADDRequest.getContactInfo().get(0).getCaddEmail(), expectedCADDRequest.getContactInfo().get(0).getMobileNumber());
        CADDShipToConfirmationScreen.assertTerritorySite(expectedCADDRequest.getTerritoryAssignment().get(0).getSite(), expectedCADDRequest.getTerritoryAssignment().get(0).getTerritoryCode());
        CADDShipToConfirmationScreen.clickNextShipToScreen();
    }

    @Test(description = "MDMC-TC-5078", priority = 6)
    public void verifyUSBLCADDNewBillToConfirmationFunctionality() {
        //Bill To Confirmation Screen of CADD
        CADDBillToConfirmationScreen.enterBillToConfirmation(expectedCADDRequest.getBillToInfo().get(0).getBillToAccountName(), expectedCADDRequest.getBillToInfo().get(0).getBillingStreet(), expectedCADDRequest.getBillToInfo().get(0).getBillingCity(), expectedCADDRequest.getBillToInfo().get(0).getBillingState(), expectedCADDRequest.getBillToInfo().get(0).getBillingPostalCode());
        CADDBillToConfirmationScreen.clickNextBillToConfirmation();
    }
}
