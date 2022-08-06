package com.sysco.mdm_customer.tests.cfea.af.accountMaintenance;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.functions.Home;
import com.sysco.mdm_customer.functions.NavigateToAccountsProspects;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.street.AccountSearch;
import com.sysco.mdm_customer.functions.street.ContactInfo;
import com.sysco.mdm_customer.models.CommonModelGETAsianFoodsLeadDetails;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.AsianFoodInactivationReactivationAssertionUtil;
import com.sysco.mdm_customer.utils.street.FreshPointInactivationReactivationAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.common.Constants.*;

public class AsianFoodsReactivationTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    AFLeadAccountRequest expectAFLeadRequest;
    CommonModelGETAsianFoodsLeadDetails afLeadDetailsGETData;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_AF_ACC_MAINTENANCE);
    }

    //MDMC-TC-5135,MDMC-TC-5136,MDMC-TC-5240
    @Test(description = "MDMC-TC-5135")
    public void testVerifyAsianFoodsReactivationFlow() {

        afLeadDetailsGETData = DataUtil.getAFLeadModelForReferenceKey(SFDC_CFEA_AF_LEAD_USER, commonModelGETAsianFoodsLeadDetailsList);
        expectAFLeadRequest = afLeadDetailsGETData.getRequest();
        Home.clickSettings();
        Home.clickSetup();
        setupMAUserLogin(expectAFLeadRequest.getMarketingAssociate());
        NavigateToAccountsProspects.selectAccountProspectTab();


        //Select Reactive Account From Accounts/Prospect Page
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_5);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();
        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectAFLeadRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectReactivationRadioButton();
        AccountSearch.navigateToNextTab();


        //Request to Reactivate Account Screen Adding Principal Officer Details
        ContactInfo.enterFirstName(expectAFLeadRequest.getContactInfo().get(0).getFirstName());
        ContactInfo.enterLastName(expectAFLeadRequest.getContactInfo().get(0).getLastName());
        ContactInfo.enterEmailAddress(expectAFLeadRequest.getContactInfo().get(0).getStreetEmail());
        ContactInfo.enterTelephoneNumber(expectAFLeadRequest.getContactInfo().get(0).getMobileNumber());
        ContactInfo.enterCustomerLanguagePreference(expectAFLeadRequest.getLanguage());
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();

        //Request to Reactivate Account Screen SR Verification
        Account.selectCFEASupportRequest();
        AsianFoodInactivationReactivationAssertionUtil.assertInactivationReactivationSRScreen(expectAFLeadRequest,"Reactivate");

    }


    //Send Token Refresh Request and Get the Access Token |  Approve the Reactivation Request (Tax = No)
    @Test(description = "MDMC-TC-5065", priority = 2, dependsOnMethods = {"testVerifyAsianFoodsReactivationFlow"})
    public void testAsianFoodsReactivationApproval() {

        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);
        Response response = RequestUtil.approveReactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON, Constants.PAYMENT_TERMS, Constants.TAX_NO, Constants.COLLECTOR__c, Constants.REGISTERED__c, Constants.TRIBAL_LAND, Constants.CREDIT_ANALYST);
        Assert.assertEquals(response.getStatusCode(), 204, "Reactivation Failed and not Approved");
    }

}