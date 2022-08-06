package com.sysco.mdm_customer.tests.usbl.accountCreation.ps;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.data.LoginData;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.Wizard;
import com.sysco.mdm_customer.functions.cadd.CADDAccountInfoScreen;
import com.sysco.mdm_customer.functions.cadd.ShipToAccountScreen;
import com.sysco.mdm_customer.functions.ps.AddressDetailsScreen;
import com.sysco.mdm_customer.functions.ps.ContactInformationScreen;
import com.sysco.mdm_customer.functions.ps.ProspectSearch;
import com.sysco.mdm_customer.functions.ps.TerritoryScreen;
import com.sysco.mdm_customer.models.CommonModelGETCADDAccountDetails;
import com.sysco.mdm_customer.models.CommonModelGETStreetAccountDetails;
import com.sysco.mdm_customer.models.request.GetCADDAccountRequest;
import com.sysco.mdm_customer.models.request.GetStreetAccountRequest;
import com.sysco.mdm_customer.utils.DataUtil;
import com.sysco.mdm_customer.utils.ExcelUtil;
import com.sysco.mdm_customer.utils.RequestUtil;
import com.sysco.mdm_customer.utils.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.sysco.mdm_customer.common.Constants.*;


public class ProspectShopWithProspectTest extends TestBase {

    CommonModelGETStreetAccountDetails streetAccountDetailsGETData;
    GetStreetAccountRequest expectedStreetRequest;
    CommonModelGETCADDAccountDetails caddAccountDetailsGETData;
    GetCADDAccountRequest expectedCADDRequest;
    String shipToSSAID, billToSSAID;
    String clientID = Constants.CLIENT_KEY_STAGING;
    String clientSecret = Constants.CLIENT_SECRET_STAGING;
    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute(FEATURE_QCENTER, MODULE_UI_MDMC_CC_USBL + " - " + FEATURE_UI_USBL_PS_ACC_CREATION);
    }

    /*
     * Login as MA User Thomas Flynn
     * Navigate to Customer Concierge Lobby
     * Click Start Wizard
     *
     * */

    //Enter Data in the Address Screen
    @Test(description = "MDMC-TC-5165", priority = 1)
    public void testProspectShopWithProspectSearchScreenFunctionality() {

        streetAccountDetailsGETData = DataUtil.getEmployeeModelForReferenceKey(StreetAccountReferenceNames.STREET_USER_LOGIN_01, commonModelGETStreetAccountDetailsList);
        expectedStreetRequest = streetAccountDetailsGETData.getRequest();
        caddAccountDetailsGETData = DataUtil.getCADDModelForReferenceKey("CADD_USER_LOGIN_01", commonModelGETCADDAccountDetailsList);
        expectedCADDRequest = caddAccountDetailsGETData.getRequest();
        setupMAUserLogin(expectedStreetRequest.getMarketingAssociate());
        Wizard.openProspectShopConversionForm();
        ProspectSearch.searchProspect(expectedStreetRequest.getProspectName());
        TerritoryScreen.clickNextProspectShopAddressScreen();

        AddressDetailsScreen.enterShipToNameDetails(expectedStreetRequest.getAccountInfo().get(0).getAccountName());
        AddressDetailsScreen.enterShipToAddressDetails(expectedStreetRequest.getBillToInfo().get(0).getBillingStreet(), expectedStreetRequest.getBillToInfo().get(0).getBillingCity());
        AddressDetailsScreen.enterShipToPostalDetails(expectedStreetRequest.getBillToInfo().get(0).getBillingState(), expectedStreetRequest.getBillToInfo().get(0).getBillingPostalCode());

        AddressDetailsScreen.enterBillToNameDetails(expectedStreetRequest.getBillToInfo().get(0).getBillToAccountName());
        AddressDetailsScreen.enterBillToAddressDetails(expectedStreetRequest.getBillToInfo().get(0).getBillingStreet(), expectedStreetRequest.getBillToInfo().get(0).getBillingCity());
        AddressDetailsScreen.enterBillToPostalDetails(expectedStreetRequest.getBillToInfo().get(0).getBillingState(), expectedStreetRequest.getBillToInfo().get(0).getBillingPostalCode());

        AddressDetailsScreen.clickNextProspectShopAddressScreen();
        AddressDetailsScreen.clickNextAddressConfirmation();


    }

    //Enter Data in the Contact Details Screen
    @Test(description = "MDMC-TC-5168", priority = 2)
    public void testProspectShopWithProspectContactInformationScreenFunctionality() {

        ContactInformationScreen.enterContactNameInfoDetails(expectedCADDRequest.getContactInfo().get(0).getFirstName(), expectedCADDRequest.getContactInfo().get(0).getLastName());
        ContactInformationScreen.enterContactInfoDetails(expectedCADDRequest.getContactInfo().get(0).getCaddEmail(), expectedCADDRequest.getContactInfo().get(0).getMobileNumber());
        ContactInformationScreen.clickCheckBoxes();
        ContactInformationScreen.enterSalesAmount();
        ContactInformationScreen.clickNextContactInfo();
    }


    //Patch Requests to the Cora Side
    @Test(description = "MDMC-TC-5065", priority = 3)
    public void testProspectShopWithProspectCreditApproval(ITestContext context) {

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
        String accountName = AddressDetailsScreen.retrieveAccountName(expectedStreetRequest.getAccountInfo().get(0).getAccountName());
        context.setAttribute("AcceptCaseAccountName", accountName);

        //Approve the Credit Application
        response = RequestUtil.approveShopCreditApp(ExcelKeyData.CORA_LEGACY_SHIPTO_REQ_KEY_01, token, shipToSSAID, accountName);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App not approved and Ship To details not updated");

        //Approve Bill To Credit Application
        response = RequestUtil.updateCreditAppDetails(ExcelKeyData.CORA_LEGACY_BILLTO_REQ_KEY_01, billToSSAID, token);
        Assert.assertEquals(response.getStatusCode(), 204, "Credit App Bill To details not updated");

    }
}
