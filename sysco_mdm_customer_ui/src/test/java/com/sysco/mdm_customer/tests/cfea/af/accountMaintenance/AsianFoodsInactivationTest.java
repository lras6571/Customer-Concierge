package com.sysco.mdm_customer.tests.cfea.af.accountMaintenance;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.data.StreetAccountAssertionMessage;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.Account;
import com.sysco.mdm_customer.functions.NavigateToAccountsProspects;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.street.AccountSearch;
import com.sysco.mdm_customer.models.CommonModelGETAsianFoodsLeadDetails;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.AFLeadAccountRequest;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import com.sysco.mdm_customer.utils.street.SupportRequestAssertionUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.common.Constants.*;
import static com.sysco.mdm_customer.functions.Login.refreshBrowser;

public class AsianFoodsInactivationTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    CommonModelGETAsianFoodsLeadDetails afLeadDetailsGETData;
    AFLeadAccountRequest expectAFLeadRequest;
    String shipToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    CommonModelGETStreetAccountDetails streetAccountDetailsGETData;
    GetStreetAccountRequest expectedStreetRequest;

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_CFEA + " - " + FEATURE_UI_CFEA_AF_ACC_MAINTENANCE);
    }

    @Test(description = "MDMC-TC-5258", priority = 1)
    public void testVerifyAFInactivationFlow() {

        //AF user login
        afLeadDetailsGETData = DataUtil.getAFLeadModelForReferenceKey(SFDC_CFEA_AF_LEAD_USER, commonModelGETAsianFoodsLeadDetailsList);
        expectAFLeadRequest = afLeadDetailsGETData.getRequest();
        streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();

        setupMAUserLogin(expectAFLeadRequest.getMarketingAssociate());
        NavigateToAccountsProspects.selectAccountProspectTab();

        //Select Active Account From Accounts/Prospect Page
        NavigateToAccountsProspects.selectActiveAccount(Constants.ACCOUNT_VIEW_LIST_4);
        ShipToAccountScreen.getCurrentURL();
        shipToSSAID = ShipToAccountScreen.getSSAID();
        softAssert.assertTrue(NavigateToAccountsProspects.isAccountStatusActive(expectAFLeadRequest.getActiveAccountName()), StreetAccountAssertionMessage.ACCOUNT_NOT_ACTIVE_STATUS);
        Account.clickCreateRequest();
        Account.selectInactivationRadioButton();
        AccountSearch.navigateToNextTab();
        AccountSearch.navigateToNextTab();

        Account.selectCFEASupportRequest();

    }


    //Patch Requests to the Cora Side
    @Test(description = "MDMC-TC-5134", priority = 2)
    public void testAFInactivationApproval() {

        //Send Token Refresh Request and Get the Access Token
        String token = RequestUtil.getSalesForceAccessToken(clientID, clientSecret, loginData.userName, loginData.password);


        //Approve the Inactivation Request
        Response response = RequestUtil.approveInactivation(token, shipToSSAID, Constants.APP_STATUS, Constants.CORA_RESPONSE_JSON);
        Assert.assertEquals(response.getStatusCode(), 204, "Inactivation Failed and not Approved");

    }

    //Assertion After Approval
    @Test(description = "MDMC-TC-5241", priority = 3, dependsOnMethods = {"testVerifyAFInactivationFlow", "testAFInactivationApproval"})
    public void testAssertionAfterApproval() {

        refreshBrowser();
        SupportRequestAssertionUtil.assertCreditApplicationStatusAfterApproval(expectedStreetRequest);

    }

}