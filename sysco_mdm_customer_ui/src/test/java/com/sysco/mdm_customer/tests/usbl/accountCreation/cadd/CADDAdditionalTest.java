package com.sysco.mdm_customer.tests.usbl.accountCreation.cadd;


import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.*;
import com.sysco.mdm_customer.models.CommonModelGETCADDAccountDetails;
import com.sysco.mdm_customer.models.request.GetCADDAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sysco.mdm_customer.common.Constants.*;

public class CADDAdditionalTest extends TestBase {

    CommonModelGETCADDAccountDetails caddAccountDetailsGETData;
    GetCADDAccountRequest expectedCADDRequest;
    String shipToSSAID, billToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_CADD_ACC_CREATION);
    }


    @Test(description = "MDMC-TC-5119", priority = 1)
    public void verifyUSBLCADDAdditionalFlowSearchScreenFunctionality() {
        caddAccountDetailsGETData = DataUtil.getCADDModelForReferenceKey("CADD_USER_LOGIN_01", commonModelGETCADDAccountDetailsList);
        expectedCADDRequest = caddAccountDetailsGETData.getRequest();
        ConciergeLobby.clickCADDCreation();
        Wizard.createCADDSecondaryAccount();
        setupMAUserLogin(expectedCADDRequest.getSbsUser());
        CADDAccountSearch.searchAccountToActivate(expectedCADDRequest.getExistingAccountName());
        CADDAccountSearch.verifyRecordName(expectedCADDRequest.getExistingAccountName());
        CADDAccountSearch.selectRecord();
        CADDAccountTypeScreen.selectNewLocation();
        CADDSearchScreen.enterConceptDetails(expectedCADDRequest.getConceptName());
        CADDSearchScreen.searchTerritoryValues(expectedCADDRequest.getTerritoryAssignment().get(0).getSite(), expectedCADDRequest.getTerritoryAssignment().get(0).getMarketingAssociate());
    }

    @Test(description = "MDMC-TC-5121", priority = 2)
    public void verifyUSBLCADDAdditionalFlowAccountInfoScreenFunctionality() {

        CADDAccountInfoScreen.enterAccountInfoDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountName(), expectedCADDRequest.getAccountInfo().get(0).getAccountPhone());
        CADDAccountInfoScreen.enterStoreNumberDetails(expectedCADDRequest.getAccountInfo().get(0).getStoreNumber());
        CADDAccountInfoScreen.enterCityAddressDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountStreet(), expectedCADDRequest.getAccountInfo().get(0).getAccountCity());
        CADDAccountInfoScreen.enterStateAddressDetails(expectedCADDRequest.getAccountInfo().get(0).getAccountPostalCode(), expectedCADDRequest.getAccountInfo().get(0).getAccountState(), expectedCADDRequest.getAccountInfo().get(0).getAccountCountry());
        CADDAccountInfoScreen.clickNextAccountInfo();
    }

    @Test(description = "MDMC-TC-5123", priority = 3)
    public void verifyUSBLCADDAdditionalFlowContactInfoScreenFunctionality() {

        CADDContactInfoScreen.enterNameInfoDetails(expectedCADDRequest.getContactInfo().get(0).getFirstName(), expectedCADDRequest.getContactInfo().get(0).getLastName());
        CADDContactInfoScreen.enterContactInfoDetails(expectedCADDRequest.getContactInfo().get(0).getCaddEmail(), expectedCADDRequest.getContactInfo().get(0).getMobileNumber());
        CADDContactInfoScreen.clickNextAddressConfirm();
    }

    @Test(description = "MDMC-TC-5127", priority = 4)
    public void verifyUSBLCADDAdditionalFlowDeliveryPreferenceScreenFunctionality() {

        CADDDeliveryPreferenceScreen.enterDeliveryDate(expectedCADDRequest.getDeliveryPreference().get(0).getDeliveryDate());
        CADDDeliveryPreferenceScreen.enterDeliveryWindowStartTime(expectedCADDRequest.getDeliveryPreference().get(0).getStartTime());
        CADDDeliveryPreferenceScreen.enterDeliveryWindowEndTime(expectedCADDRequest.getDeliveryPreference().get(0).getEndTime());
        CADDDeliveryPreferenceScreen.enterBackdoorOpenTime(expectedCADDRequest.getDeliveryPreference().get(0).getOpenTime());
        CADDDeliveryPreferenceScreen.enterBackdoorCloseTime(expectedCADDRequest.getDeliveryPreference().get(0).getCloseTime());
        CADDDeliveryPreferenceScreen.clickDeliveryPreferenceInfo();
    }

    @Test(description = "MDMC-TC-5128", priority = 5)
    public void verifyUSBLCADDAdditionalFlowShipToConfirmationScreenFunctionality() {

        CADDShipToConfirmationScreen.assertBusinessInformation(expectedCADDRequest.getConceptName(), CADDAccountInfoScreen.retrieveAccountName(expectedCADDRequest.getAccountInfo().get(0).getAccountName()), expectedCADDRequest.getCaddAccountType(), expectedCADDRequest.getAccountInfo().get(0).getAccountPhone(), expectedCADDRequest.getAccountInfo().get(0).getStoreNumber());
        CADDShipToConfirmationScreen.assertShippingInformation(expectedCADDRequest.getAccountInfo().get(0).getAccountPostalCode(), expectedCADDRequest.getAccountInfo().get(0).getAccountState(), expectedCADDRequest.getAccountInfo().get(0).getAccountStreet(), expectedCADDRequest.getAccountInfo().get(0).getAccountCity());
        CADDShipToConfirmationScreen.assertContactName(expectedCADDRequest.getContactInfo().get(0).getFullName(), expectedCADDRequest.getContactInfo().get(0).getCaddEmail(), expectedCADDRequest.getContactInfo().get(0).getMobileNumber());
        CADDShipToConfirmationScreen.assertTerritorySite(expectedCADDRequest.getTerritoryAssignment().get(0).getSite(), expectedCADDRequest.getTerritoryAssignment().get(0).getTerritoryCode());
        CADDShipToConfirmationScreen.clickNextShipToScreen();
        CADDBillToConfirmationScreen.clickSaveAttribute();
    }


    @Test(description = "MDMC-TC-5065", priority = 6)
    public void testVerifyUSBLCADDAdditionalFlowCreditApproval() {
        //Get the Ship to SSAID
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();

        //Get the Bill to SSAID
        ShipToAccountScreen.openBillTo();
        billToSSAID = ShipToAccountScreen.getSSAIDBillTo();
        ShipToAccountScreen.navigateBack();

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);

        //Submit the Credit Application
        Response response = RequestUtil.submitCreditApp(ExcelKeyData.CORA_SUBMISSION_REQ_KEY_01, shipToSSAID, token);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App Submission failed");

        //Approve the Credit Application
        response = RequestUtil.approveShopCreditApp(ExcelKeyData.CORA_LEGACY_SHIPTO_REQ_KEY_01, token, shipToSSAID, CADDAccountInfoScreen.retrieveAccountName(expectedCADDRequest.getAccountInfo().get(0).getAccountName()));
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App not approved and Ship To details not updated");

        //Approve Bill To Credit Application
        response = RequestUtil.updateCreditAppDetails(ExcelKeyData.CORA_LEGACY_BILLTO_REQ_KEY_01, billToSSAID, token);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App Bill To details not updated");


    }
}
