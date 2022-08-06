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
import com.sysco.mdm_customer.models.CommonModelGETFreshPointLeadDetails;
import com.sysco.mdm_customer.models.request.FPLeadAccountRequest;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.FreshPointInactivationReactivationAssertionUtil;
import com.sysco.mdm_customer.utils.street.SupportRequestAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.functions.Login.refreshBrowser;

public class FreshPointInactivationTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    CommonModelGETFreshPointLeadDetails fpLeadDetailsGETData;
    FPLeadAccountRequest expectFPLeadRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    GetStreetAccountRequest expectedStreetRequest;


    //MDMC-TC-5179,MDMC-TC-5235,MDMC-TC-5256
    @Test(description = "MDMC-TC-5179", priority = 0)
    public void testVerifyFPInactivationFlow() {


        //Log in as Mario Arzapalo and select an Inactive Account
        fpLeadDetailsGETData = DataUtil.getFPLeadModelForReferenceKey("SFDC_CFEA_FP_LEAD_USER", commonModelGETFreshPointLeadDetailsList);
        expectFPLeadRequest = fpLeadDetailsGETData.getRequest();
        Home.clickSettings();
        Home.clickSetup();
        Home.searchMarketingAssociate(expectFPLeadRequest.getMarketingAssociate());
        Home.clickMAUserLoginButton();
        NavigateToAccountsProspects.selectAccountProspectTab();


        //Select Active Account From Accounts/Prospect Page and Get the Ship to SSAID
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_3);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();

        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectFPLeadRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectInactivationRadioButton();
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();


        //Request to Inactivate Account Screen SR Verification
        Account.selectCFEASupportRequest();
        FreshPointInactivationReactivationAssertionUtil.assertInactivationReactivationSRScreen(expectFPLeadRequest, "Inactivate");

    }

    //Patch Requests to the Cora Side
    @Test(description = "MDMC-TC-5134", priority = 2)
    public void testFPInactivationApproval() {

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);


        //Approve the Inactivation Request
        Response response = RequestUtil.approveInactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON);
        Assert.assertEquals(response.getStatusCode(), 204, "Inactivation Failed and not Approved");

    }

    //Assertion After Approval
    @Test(description = "MDMC-TC-5241", priority = 3,dependsOnMethods={"testVerifyFPInactivationFlow", "testFPInactivationApproval"})
    public void testAssertionAfterApproval() {

        refreshBrowser();
        SupportRequestAssertionUtil.assertCreditApplicationStatusAfterApproval(expectedStreetRequest);

    }
}