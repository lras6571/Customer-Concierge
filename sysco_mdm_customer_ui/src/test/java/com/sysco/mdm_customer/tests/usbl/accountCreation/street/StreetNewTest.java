package com.sysco.mdm_customer.tests.usbl.accountCreation.street;


import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.CADDAccountInfoScreen;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.street.*;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.StreetAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.common.Constants.*;

public class StreetNewTest extends TestBase {
    String shipToSSAID, billToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    SoftAssert softAssert = new SoftAssert();

    CommonModelGETStreetAccountDetails streetAccountDetailsGETData;
    GetStreetAccountRequest expectedStreetRequest;



    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_STREET_ACC_CREATION);
    }


    @Test(description = "MDMC-TC-5053", priority = 1)
    public void testVerifyUSBLSearchScreenFunctionality() {

        streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedStreetRequest.getMarketingAssociate());
        Wizard.createSTREETNewNetAccount();

        // Select the Prospect from the Search Screen
        softAssert.assertTrue(SearchScreen.isActivateProspectHomeScreenDisplayed(), StreetAccountAssertionMessage.HOME_SCREEN_NOT_DISPLAY);
        // softAssert.assertTrue(SearchScreen.isSearchScreenTableColumnDisplayed(), StreetAccountAssertionMessage.PROSPECT_TABLE_COLUMN_NOT_DISPLAY);

    }

    @Test(description = "MDMC-TC-5044", priority = 2)
    public void testVerifyUSBLSearchScreenUI() {
        StreetAssertionUtil.assertSearchScreenUI();
        SearchScreen.searchAccountToActivate(expectedStreetRequest.getProspectName(), String.valueOf(expectedStreetRequest.getAccountTypes().get(0).getAccountType()));
    }

    @Test(description = "MDMC-TC-5052", priority = 3)
    public void testVerifyUSBLAccountInfoScreenUI() {
        StreetAssertionUtil.assertAccountInfoScreenUI();
    }

    @Test(description = "MDMC-TC-5054", priority = 4)
    public void testVerifyUSBLAccountInfoScreenFunctionality() {
        /*
         * Enter the detail that wanted to fill the Account Info Screen
         * */

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

    @Test(description = "MDMC-TC-5444", priority = 5)
    public void testVerifyUSBLContactInfoScreenUI() {
        ShipToInfo.confirmPrincipalOwnerofTheAccount();
        StreetAssertionUtil.assertContactInfoScreenUI();
    }

    @Test(description = "MDMC-TC-5445", priority = 6)
    public void testVerifyUSBLContactInfoScreenFunctionality() {
        // Contact Info Screen Verification

        ContactInfo.enterFirstName(expectedStreetRequest.getContactInfo().get(0).getFirstName());
        ContactInfo.enterLastName(expectedStreetRequest.getContactInfo().get(0).getLastName());
        ContactInfo.enterEmailAddress(expectedStreetRequest.getContactInfo().get(0).getStreetEmail());
        ContactInfo.enterTelephoneNumber(expectedStreetRequest.getContactInfo().get(0).getMobileNumber());
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5055", priority = 7)
    public void testVerifyUSBLDeliveryPreferencesScreenUI() {
        DeliveryPreferences.confirmDeliveryPreferences();
        StreetAssertionUtil.assertDeliveryPreferencesScreenUI();
    }

    @Test(description = "MDMC-TC-5056", priority = 8)
    public void testVerifyUSBLDeliveryPreferencesScreenFunctionality() {
        /*
         * Delivery Preferences Screen Verification
         * */

        DeliveryPreferences.enterDeliveryDate(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryDay());
        DeliveryPreferences.enterDeliveryWindowStartTime(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryWindow1Start());
        DeliveryPreferences.enterDeliveryWindowEndTime(expectedStreetRequest.getDeliveryPreference().get(0).getDeliveryWindow1End());
        DeliveryPreferences.enterBackdoorOpenTime(expectedStreetRequest.getDeliveryPreference().get(0).getBackdoorOpen());
        DeliveryPreferences.enterBackdoorCloseTime(expectedStreetRequest.getDeliveryPreference().get(0).getBackdoorClose());
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5058", priority = 9)
    public void testVerifyUSBLCuisineInfoScreenFunctionality() {
        /*
         * Cuisine Info Screen Verification
         * */
        String strCuisineType = expectedStreetRequest.getCuisineAndOperation().get(0).getTypeOfCuisine();
        String strOperationType = expectedStreetRequest.getCuisineAndOperation().get(0).getTypeOfOperation();
        String strLocalOperationType = expectedStreetRequest.getCuisineAndOperation().get(0).getLocalTypeOfOperation();
        CuisineInfo.setCuisineInfo(strCuisineType, strOperationType, strLocalOperationType);

    }

    @Test(description = "MDMC-TC-5057", priority = 10)
    public void testVerifyUSBLCuisineInfoScreenUI() {
        StreetAssertionUtil.assertCuisineInfoScreenUI();
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5059", priority = 11)
    public void testVerifyUSBLShipToConfirmationScreenFunctionality() {
        /*
         * Ship To Confirmation Screen Verification
         * */
        StreetAssertionUtil.assertBusinessInformationData(expectedStreetRequest.getAccountTypes().get(0).getAccountType(), expectedStreetRequest.getAccountInfo().get(0).getAccountPhone());
        StreetAssertionUtil.assertShippingAddressInformationData(expectedStreetRequest.getAccountInfo().get(0).getAccountStreet(), expectedStreetRequest.getAccountInfo().get(0).getAccountCity(), expectedStreetRequest.getAccountInfo().get(0).getAccountPostalCode(), "US");
        StreetAssertionUtil.assertContactInformationData(expectedStreetRequest.getContactInfo().get(0).getFirstName(), expectedStreetRequest.getContactInfo().get(0).getLastName(), expectedStreetRequest.getContactInfo().get(0).getStreetEmail(), expectedStreetRequest.getContactInfo().get(0).getMobileNumber());
        AccountSearch.navigateToNextTab();
    }

    @Test(description = "MDMC-TC-5062", priority = 12)
    public void testVerifyUSBLBillToConfirmationScreenFunctionality() {
        /*
         * Bill To Confirmation Screen Verification
         * */
        BillToInfo.createNewBillTo(expectedStreetRequest.getBillToInfo().get(0).getBillToAccountName(), expectedStreetRequest.getBillToInfo().get(0).getBillingStreet(), expectedStreetRequest.getBillToInfo().get(0).getBillingCity(), expectedStreetRequest.getBillToInfo().get(0).getBillingState(), expectedStreetRequest.getBillToInfo().get(0).getBillingPostalCode());
        AccountSearch.navigateToNextTab();
        BillToInfo.sendCreditApplication(true);

    }
    @Test(description = "MDMC-TC-5065", priority = 13)
    public void testVerifyUSBLCreditApproval(ITestContext context) {
        //Account.viewRelatedContacts(expectedStreetRequest.getProspectName());
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
        String accountName = CADDAccountInfoScreen.retrieveAccountName("Pzza Hut");
        context.setAttribute("AcceptCaseAccountName", accountName);
        //Approve the Credit Application
        response = RequestUtil.approveShopCreditApp(ExcelKeyData.CORA_LEGACY_SHIPTO_REQ_KEY_01, token, shipToSSAID, accountName);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App not approved and Ship To details not updated");

        //Approve Bill To Credit Application
        response = RequestUtil.updateCreditAppDetails(ExcelKeyData.CORA_LEGACY_BILLTO_REQ_KEY_01, billToSSAID, token);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App Bill To details not updated");
        /*
         * SR Verification After Accept Case
         * */
//        NavigateToAccountsProspects.selectActiveAccount("My Active Accounts");
//        SupportRequest.viewSupportRequests();
//        SupportRequest.viewFirstSupportRequest();
//        SupportRequestAssertionUtil.assertStreetAccountCreationFlowAfterAcceptCase(expectedStreetRequest);


    }



}