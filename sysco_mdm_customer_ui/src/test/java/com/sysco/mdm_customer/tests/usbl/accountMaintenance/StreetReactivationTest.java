package com.sysco.mdm_customer.tests.usbl.accountMaintenance;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.functions.Home;
import com.sysco.mdm_customer.functions.NavigateToAccountsProspects;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.street.AccountSearch;
import com.sysco.mdm_customer.functions.street.ContactInfo;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.InactivationReactivationAssertionUtil;
import com.sysco.mdm_customer.utils.street.SupportRequestAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.functions.Login.refreshBrowser;

public class StreetReactivationTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    GetStreetAccountRequest expectedStreetRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);


    //MDMC-TC-5135,MDMC-TC-5136,MDMC-TC-5240
    @Test(description = "MDMC-TC-5135")
    public void testVerifyReactivationFlow() {


        //Log in as Thomas Flynn and go to the Account tab
        CommonModelGETStreetAccountDetails streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        Home.clickSettings();
        Home.clickSetup();
        Home.searchMarketingAssociate(expectedStreetRequest.getMarketingAssociate());
        Home.clickMAUserLoginButton();
        NavigateToAccountsProspects.selectAccountProspectTab();


        //Select Active Account From Accounts/Prospect Page and Get the Ship to SSAID
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_2);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();


        //Select Reactive Account From Accounts/Prospect Page
        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectedStreetRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectReactivationRadioButton();

        //Request to Reactivate Account Screen Adding Principal Officer Details
        AccountSearch.navigateToNextTab();
        ContactInfo.enterFirstName(expectedStreetRequest.getContactInfo().get(0).getFirstName());
        ContactInfo.enterLastName(expectedStreetRequest.getContactInfo().get(0).getLastName());
        ContactInfo.enterEmailAddress(expectedStreetRequest.getContactInfo().get(0).getStreetEmail());
        ContactInfo.enterTelephoneNumber(expectedStreetRequest.getContactInfo().get(0).getMobileNumber());
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();


        //Request to Reactivate Account Screen SR Verification
        Account.selectSupportRequest();
        InactivationReactivationAssertionUtil.assertInactivationReactivationSRScreen(expectedStreetRequest, "Reactivate");

    }


    //Send Token Refresh Request and Get the Access Token |  Approve the Reactivation Request (Tax = No)
    @Test(description = "MDMC-TC-5065", priority = 2, dependsOnMethods = {"testVerifyReactivationFlow"})
    public void testReactivationApproval() {

        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);
        Response response = RequestUtil.approveReactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON, Constants.PAYMENT_TERMS, Constants.TAX_NO, Constants.COLLECTOR__c, Constants.REGISTERED__c, Constants.TRIBAL_LAND, Constants.CREDIT_ANALYST);
        Assert.assertEquals(response.getStatusCode(), 204, "Reactivation Failed and not Approved");
    }


    //Assertion After the Approval
    @Test(description = "MDMC-TC-5241", priority = 3, dependsOnMethods = {"testReactivationApproval"})
    public void testAssertionAfterApproval() {

        refreshBrowser();
        SupportRequestAssertionUtil.assertCreditApplicationStatusAfterApproval(expectedStreetRequest);

    }
}