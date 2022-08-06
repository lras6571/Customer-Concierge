package com.sysco.mdm_customer.tests.cfea.fp.accountCreation;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.cfea.*;
import com.sysco.mdm_customer.models.CommonModelGETFreshPointLeadDetails;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
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

public class FreshPointNewAccountTest extends TestBase {

    CommonModelGETFreshPointLeadDetails fpLeadDetailsGETData;
    FPLeadAccountRequest expectFPLeadRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_FP_ACC_CREATION);
    }

    @Test(description = "MDMC-TC-5160", priority = 1)
    public void testVerifyCFEAFreshPointNewAccountLeadSearch(ITestContext context) {

        //Get Lead name from context
        String leadName = (String) context.getAttribute("FPLeadName");

        //FP user login
        fpLeadDetailsGETData = DataUtil.getFPLeadModelForReferenceKey(SFDC_CFEA_FP_LEAD_USER, commonModelGETFreshPointLeadDetailsList);
        expectFPLeadRequest = fpLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectFPLeadRequest.getMarketingAssociate());

        //Enter Created Lead Name and Select the Lead
        ConciergeLobby.clickCFEAAccountIcon();
        Wizard.createNetNewAccount();
        Wizard.createCFEANewNetAccount();
        CFEASearchScreen.enterCreatedLeadName(leadName);
        CFEASearchScreen.selectFreshPointTerritory();

    }

    @Test(description = "MDMC-TC-5170", priority = 2)
    public void testVerifyCFEAFreshPointNewAccountAccountInfo() {

        //Fill the Account Info Screen
        CFEAAccountInfoScreen.enterAccountInfoDetails(expectFPLeadRequest.getCompanyName(), expectFPLeadRequest.getMobileNumber());
        CFEAAccountInfoScreen.enterCityAddressDetails(expectFPLeadRequest.getLeadBillToInfo().get(0).getBillingStreet(), expectFPLeadRequest.getLeadBillToInfo().get(0).getBillingCity());
        CFEAAccountInfoScreen.enterStateAddressDetails(expectFPLeadRequest.getLeadBillToInfo().get(0).getBillingPostalCode(), expectFPLeadRequest.getLeadBillToInfo().get(0).getBillingState(), expectFPLeadRequest.getLeadBillToInfo().get(0).getBillingCountry());
        CFEAAccountInfoScreen.clickNextAccountInfo();
        CFEAAccountInfoScreen.clickNextAddressConfirm();

    }

    @Test(description = "MDMC-TC-5171", priority = 3)
    public void testVerifyCFEAFreshPointNewAccountContactInfo() {

        //Fill the Contact Info Screen
        CFEAContactInfoScreen.enterNameInfoDetails(expectFPLeadRequest.getFirstName(), expectFPLeadRequest.getLastName());
        CFEAContactInfoScreen.enterContactInfoDetails(expectFPLeadRequest.getContactEmail(), expectFPLeadRequest.getMobileNumber());
        CFEAContactInfoScreen.selectLanguagePreference(expectFPLeadRequest.getLanguage());
        CFEAContactInfoScreen.clickNextContactInfo();

        //Fill the Additional Info Screen
        CFEAAdditionalInfoScreen.enterAccountInfoDetails(expectFPLeadRequest.getRoutingInformation());
        CFEAAdditionalInfoScreen.enterNationalID(expectFPLeadRequest.getNationalID());
        CFEAAdditionalInfoScreen.clickNextButton();

    }

    @Test(description = "MDMC-TC-5175", priority = 4)
    public void testVerifyCFEAFreshPointNewAccountShipToConfirmation() {

        //Click Ship to Confirmation Screen
        CFEAShipToConfirmationScreen.clickNextShipToConfirmation(NET);

    }

    @Test(description = "MDMC-TC-5177", priority = 5)
    public void testVerifyCFEAFreshPointNewAccountBillToConfirmation() {

        //Click Ship to Confirmation Screen
        CFEABillToConfirmationScreen.clickNextBillToConfirmation();

    }

    @Test(description = "MDMC-TC-5180", priority = 6)
    public void testVerifyCFEAFreshPointNewAccountCreditApproval(ITestContext context) throws InterruptedException {

        //Get the Ship to SSAID
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);

        //Approve the Credit Application
        Response response = RequestUtil.approveCreditApplication(ExcelKeyData.CORA_LEGACY_SHIPTO_REQ_KEY_01, token, shipToSSAID);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App not approved and Ship To details not updated");

        //Set Account Owner name to context
        context.setAttribute("FPAccountOwnerName", CFEAContactInfoScreen.retrieveNameInfo(expectFPLeadRequest.getFirstName(), expectFPLeadRequest.getLastName()));

        //Set Account Company name to context
        context.setAttribute("FPAccountCompanyName", CFEAAccountInfoScreen.retrieveAccountName(expectFPLeadRequest.getCompanyName()));
        Thread.sleep(10000);

    }

}
