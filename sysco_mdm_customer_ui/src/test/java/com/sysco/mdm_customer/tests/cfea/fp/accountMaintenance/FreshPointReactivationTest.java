package com.sysco.mdm_customer.tests.cfea.fp.accountMaintenance;

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
import com.sysco.mdm_customer.models.CommonModelGETFreshPointLeadDetails;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.FreshPointInactivationReactivationAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FreshPointReactivationTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    CommonModelGETFreshPointLeadDetails fpLeadDetailsGETData;
    FPLeadAccountRequest expectFPLeadRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);


    //MDMC-TC-5135,MDMC-TC-5136,MDMC-TC-5240
    @Test(description = "MDMC-TC-5135", priority = 0)
    public void testVerifyFreshPointReactivationFlow() {

        fpLeadDetailsGETData = DataUtil.getFPLeadModelForReferenceKey("SFDC_CFEA_FP_LEAD_USER", commonModelGETFreshPointLeadDetailsList);
        expectFPLeadRequest = fpLeadDetailsGETData.getRequest();
        Home.clickSettings();
        Home.clickSetup();
        Home.searchMarketingAssociate(expectFPLeadRequest.getMarketingAssociate());
        Home.clickMAUserLoginButton();
        NavigateToAccountsProspects.selectAccountProspectTab();



        //Select Reactive Account From Accounts/Prospect Page
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_6);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();
        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectFPLeadRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectReactivationRadioButton();
        AccountSearch.navigateToNextTab();


        //Request to Reactivate Account Screen Adding Principal Officer Details
        ContactInfo.enterFirstName(expectFPLeadRequest.getContactInfo().get(0).getFirstName());
        ContactInfo.enterLastName(expectFPLeadRequest.getContactInfo().get(0).getLastName());
        ContactInfo.enterEmailAddress(expectFPLeadRequest.getContactInfo().get(0).getStreetEmail());
        ContactInfo.enterTelephoneNumber(expectFPLeadRequest.getContactInfo().get(0).getMobileNumber());
        ContactInfo.enterCustomerLanguagePreference(expectFPLeadRequest.getLanguage());
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();

        //Request to Reactivate Account Screen SR Verification
        Account.selectCFEASupportRequest();
        FreshPointInactivationReactivationAssertionUtil.assertInactivationReactivationSRScreen(expectFPLeadRequest, "Reactivate");

    }


    //Send Token Refresh Request and Get the Access Token |  Approve the Reactivation Request (Tax = No)
    @Test(description = "MDMC-TC-5065", priority = 2, dependsOnMethods = {"testVerifyFreshPointReactivationFlow"})
    public void testFreshPointReactivationApproval() {

        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);
        Response response = RequestUtil.approveReactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON, Constants.PAYMENT_TERMS, Constants.TAX_NO, Constants.COLLECTOR__c, Constants.REGISTERED__c, Constants.TRIBAL_LAND, Constants.CREDIT_ANALYST);
        Assert.assertEquals(response.getStatusCode(), 204, "Reactivation Failed and not Approved");
    }
}