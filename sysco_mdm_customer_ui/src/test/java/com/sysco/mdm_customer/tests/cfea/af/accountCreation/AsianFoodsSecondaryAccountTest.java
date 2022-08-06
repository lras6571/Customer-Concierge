package com.sysco.mdm_customer.tests.cfea.af.accountCreation;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.functions.ConciergeLobby;
import com.sysco.mdm_customer.functions.NavigateToCustomerConcierge;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.CADDAccountSearch;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.cfea.*;
import com.sysco.mdm_customer.functions.cfealead.CFEALeadCreation;
import com.sysco.mdm_customer.models.CommonModelGETAsianFoodsLeadDetails;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
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

public class AsianFoodsSecondaryAccountTest extends TestBase {

    CommonModelGETAsianFoodsLeadDetails afLeadDetailsGETData;
    AFLeadAccountRequest expectAFLeadRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_AF_ACC_CREATION);
    }

    @Test(description = "MDMC-TC-5218", priority = 1)
    public void testVerifyCFEAAsianFoodsSecondaryAccountLeadSearch(ITestContext context) {

        //Get Account Company name from context
        String accountCompanyName = (String) context.getAttribute("AFAccountCompanyName");

        //AF user login
        afLeadDetailsGETData = DataUtil.getAFLeadModelForReferenceKey(SFDC_CFEA_AF_LEAD_USER, commonModelGETAsianFoodsLeadDetailsList);
        expectAFLeadRequest = afLeadDetailsGETData.getRequest();
        setupMAUserLogin(expectAFLeadRequest.getMarketingAssociate());

        //Lead create
        ConciergeLobby.clickCFEALeadCreationIcon();
        CFEALeadCreation.enterCompanyName(expectAFLeadRequest.getCompanyName());
        CFEALeadCreation.selectSalutation();
        CFEALeadCreation.enterWeeklySales(expectAFLeadRequest.getWeeklySales());
        CFEALeadCreation.enterContactEmail(expectAFLeadRequest.getContactEmail());
        CFEALeadCreation.enterCompanyContactDetails(expectAFLeadRequest.getFirstName(), expectAFLeadRequest.getLastName());
        CFEALeadCreation.selectLeadRating();
        CFEALeadCreation.selectBusinessStructure();
        CFEALeadCreation.saveLeadDetails();

        //Set Lead name to context
        String leadNameForNSL = CFEALeadCreation.retrieveLeadName(expectAFLeadRequest.getCompanyName());

        //Navigate to the Customer Concierge Lobby
        NavigateToCustomerConcierge.selectCustomerConcierge();

        //Click National Account flow for Create CADD Accounts
        ConciergeLobby.clickCFEAAccountIcon();
        Wizard.createCADDSecondaryAccount();

        //Search Screen of CFEA existing Account
        CADDAccountSearch.searchAccountToActivate(accountCompanyName);
        CADDAccountSearch.verifyRecordName(expectAFLeadRequest.getExistingAccountName());
        CADDAccountSearch.selectRecord();
        CFEAAccountTypeScreen.selectExistingLocation();
        Wizard.chooseShipTo(true);

        //Enter Created Lead Name and Select the Lead
        CFEASearchScreen.enterCreatedLeadName(leadNameForNSL);
        CFEASearchScreen.selectLead();

    }

    @Test(description = "MDMC-TC-5220", priority = 2)
    public void testVerifyCFEAAsianFoodsSecondaryAccountAccountInfo() {

        CFEAAccountInfoScreen.enterAccountInfoDetails(expectAFLeadRequest.getCompanyName(), expectAFLeadRequest.getMobileNumber());
        CFEAAccountInfoScreen.enterCityAddressDetails(expectAFLeadRequest.getLeadBillToInfo().get(0).getBillingStreet(), expectAFLeadRequest.getLeadBillToInfo().get(0).getBillingCity());
        CFEAAccountInfoScreen.enterStateAddressDetails(expectAFLeadRequest.getLeadBillToInfo().get(0).getBillingPostalCode(), expectAFLeadRequest.getLeadBillToInfo().get(0).getBillingState(), expectAFLeadRequest.getLeadBillToInfo().get(0).getBillingCountry());
        CFEAAccountInfoScreen.clickNextAccountInfo();
        CFEAAccountInfoScreen.clickNextAddressConfirm();

    }

    @Test(description = "MDMC-TC-5222", priority = 3)
    public void testVerifyCFEAAsianFoodsSecondaryAccountContactInfo() {

        CFEAContactInfoScreen.enterNameInfoDetails(expectAFLeadRequest.getFirstName(), expectAFLeadRequest.getLastName());
        CFEAContactInfoScreen.enterContactInfoDetails(expectAFLeadRequest.getContactEmail(), expectAFLeadRequest.getMobileNumber());
        CFEAContactInfoScreen.selectLanguagePreference(expectAFLeadRequest.getLanguage());
        CFEAContactInfoScreen.clickNextContactInfo();

        CFEAAdditionalInfoScreen.enterAccountInfoDetails(expectAFLeadRequest.getRoutingInformation());
        CFEAAdditionalInfoScreen.enterNationalID(expectAFLeadRequest.getNationalID());
        CFEAAdditionalInfoScreen.clickNextButton();

    }

    @Test(description = "MDMC-TC-5224", priority = 4)
    public void testVerifyCFEAAsianFoodsSecondaryAccountShipToConfirmation() {

        CFEAShipToConfirmationScreen.clickNextShipToConfirmation(NSL);

    }

    @Test(description = "MDMC-TC-5249", priority = 5)
    public void testVerifyCFEAAsianFoodsSecondaryAccountCreditApproval(ITestContext context) throws InterruptedException {

        //Get the Ship to SSAID
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);

        //Approve the Credit Application
        Response response = RequestUtil.approveCreditApplication(ExcelKeyData.CORA_LEGACY_SHIPTO_REQ_KEY_01, token, shipToSSAID);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App not approved and Ship To details not updated");

        //Set Account name to context
        context.setAttribute("AFSecondaryAccountName", CFEAContactInfoScreen.retrieveNameInfo(expectAFLeadRequest.getFirstName(), expectAFLeadRequest.getLastName()));

    }

}
