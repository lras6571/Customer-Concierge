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

public class StreetInactivationTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    GetStreetAccountRequest expectedStreetRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);


    @Test(description = "MDMC-TC-5238", priority = 0)
    public void testVerifyInactivationFlow() {

        //Log in as Thomas Flynn and go to the Account tab
        CommonModelGETStreetAccountDetails streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        Home.clickSettings();
        Home.clickSetup();
        Home.searchMarketingAssociate(expectedStreetRequest.getMarketingAssociate());
        Home.clickMAUserLoginButton();
        NavigateToAccountsProspects.selectAccountProspectTab();


        //Select Active Account From Accounts/Prospect Page and Get the Ship to SSAID
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_1);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();

        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectedStreetRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectInactivationRadioButton();
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();

        //Request to Inactivate Account Screen SR Verification
        Account.selectSupportRequest();
        softAssert.assertEquals(Account.verifyCaseRequestType(), "Inactive", "SR Case Request Type is not Inactive");
    }


    //Patch Requests to the Cora Side
    @Test(description = "MDMC-TC-5134", priority = 2)
    public void testInactivationApproval() {

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);


        //Approve the Inactivation Request
        Response response = RequestUtil.approveInactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON);
        Assert.assertEquals(response.getStatusCode(), 204, "Inactivation Failed and not Approved");

    }

    //Assertion After Approval
    @Test(description = "MDMC-TC-5241", priority = 3,dependsOnMethods={"testVerifyInactivationFlow", "testInactivationApproval"})
    public void testAssertionAfterApproval() {

        refreshBrowser();
        SupportRequestAssertionUtil.assertCreditApplicationStatusAfterApproval(expectedStreetRequest);

    }
}