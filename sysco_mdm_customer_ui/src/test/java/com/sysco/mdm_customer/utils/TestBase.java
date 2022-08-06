package com.sysco.mdm_customer.utils;

import com.sysco.mdm_customer.data.ExcelKeyData;
import com.sysco.mdm_customer.functions.*;
import com.sysco.mdm_customer.data.StreetAccountReferenceNames;
import com.sysco.mdm_customer.functions.*;
import com.sysco.mdm_customer.functions.common.QcenterCommonFunctions;
import com.sysco.mdm_customer.models.*;
import com.sysco.mdm_customer.models.request.GetLoginRequest;
import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.sysco.mdm_customer.common.Constants;
import com.syscolab.qe.core.util.qcenter.QCenterUtil;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

@Listeners(SyscoLabListener.class)
public class TestBase {

    protected static SoftAssert softAssert;
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    private static String customReleaseName = "";
    private static Map<String, String> qcenterBuildInfo;
    protected static List<CommonModelGETStreetAccountDetails> commonModelGETStreetAccountDetailsList;
    protected static List<CommonModelGETCADDAccountDetails> commonModelGETCADDAccountDetailsList;
    protected static List<CommonModelGETLoginDetails> commonModelGETLoginDetailsList;
    protected static List<CommonModelGETLeadAccountDetails> commonModelGETLeadAccountDetailsList;
    protected static List<CommonModelGETSBSApprovalDetails> commonModelGETSBSApprovalDetailsList;
    protected static List<CommonModelGETAsianFoodsLeadDetails> commonModelGETAsianFoodsLeadDetailsList;
    protected static List<CommonModelGETFreshPointLeadDetails> commonModelGETFreshPointLeadDetailsList;
    protected static List<CommonModelGETMRTAccountDetails> commonModelGETMRTAccountDetailsList;
    protected static List<CommonModelGETInitiateShipToScreenAssertionDetails> commonModelGetScreenAssertionDetailsGETDataList;
    CommonModelGETLoginDetails loginDetailsGETData;
    GetLoginRequest expectedLoginRequest;

    public static void initializeReportData() {
        System.setProperty("test.env", Constants.TEST_ENV);
        System.setProperty("test.release", Constants.TEST_RELEASE);
        System.setProperty("test.project", Constants.TEST_PROJECT);
        System.setProperty("update.dashboard", String.valueOf(Constants.UPDATE_DASHBOARD));
    }

    public void generateBuild() {
        try {
            if (Constants.IS_CREATE_BUILD_ENABLED) {
                customReleaseName = Constants.TEST_RELEASE + "_" + DateUtils.getQCenterBuildDate();
                LoggerUtil.logINFO("Custom Build Name : " + customReleaseName);
                qcenterBuildInfo = QcenterCommonFunctions.getBuildInfoByName(QcenterCommonFunctions.getQCenterBuildList(), customReleaseName);
                LoggerUtil.logINFO("Build Info : " + qcenterBuildInfo);
                if (qcenterBuildInfo.isEmpty()) {
                    LoggerUtil.logINFO("Generating Build");
                    QCenterUtil.generateBuild(Constants.TEST_PROJECT, Constants.TEST_ENV,
                            Constants.TEST_RELEASE + "_" + DateUtils.getQCenterBuildDate());
                } else {
                    LoggerUtil.logINFO("Build already exists and will not be created");
                }
            }
        } catch (Exception ex) {
            LoggerUtil.logERROR(ex.getMessage(), ex);
        }
    }

    public void initQCenter() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
    }

    public void setupBrowser() {
        commonModelGETStreetAccountDetailsList = DataUtil.getCommonModelGETStreetAccountDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_ACCOUNT_DETAIL_JSON_FILE);
        commonModelGETLoginDetailsList = DataUtil.getCommonModelGETLoginDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_LOGIN_JSON_FILE);
        commonModelGETLeadAccountDetailsList = DataUtil.getCommonModelGETLeadDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_LEAD_JSON_FILE);
        commonModelGETCADDAccountDetailsList = DataUtil.getCommonModelGETCADDDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_CADD_JSON_FILE);
        commonModelGETSBSApprovalDetailsList = DataUtil.getsbsApprovalDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_SBS_JSON_FILE);
        commonModelGETAsianFoodsLeadDetailsList = DataUtil.getAsianFoodsLeadDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_AF_LEAD_JSON_FILE);
        commonModelGETFreshPointLeadDetailsList = DataUtil.getFreshPointLeadDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_FP_LEAD_JSON_FILE);
        commonModelGETMRTAccountDetailsList = DataUtil.getCommonModelGETMRTDetailsList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_MRT_JSON_FILE);
        commonModelGetScreenAssertionDetailsGETDataList = DataUtil.screenAssertionDetailsGETDataList(Constants.TEST_RESOURCE_PATH, Constants.INPUT_ASSERTION_JSON_FILE);
        System.out.println("Test Running " + this.getClass().toString());
        ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
        loginDetailsGETData = DataUtil.getLoginModelReferenceKey("SFDC_USER_LOGIN", commonModelGETLoginDetailsList);
        expectedLoginRequest = loginDetailsGETData.getRequest();

        GUIFunctionBase.openBrowser();
        Login.enterUserDetails(expectedLoginRequest.getUsername(),expectedLoginRequest.getPassword());
        Login.clickLogin();
    }

    @BeforeSuite
    public void runBeforeSuite() {
        initializeReportData();
        generateBuild();
    }

    @BeforeClass
    public void init() {
        initQCenter();
        setupBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void initMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void updateDashboard(ITestContext iTestContext) {
        if (Constants.UPDATE_DASHBOARD) {
            try {
                syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
                syscoLabQCenter.setEnvironment(Constants.TEST_ENV);

                if (qcenterBuildInfo == null) {
                    syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
                } else {
                    syscoLabQCenter.setRelease(customReleaseName);
                }

                syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
                syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
                syscoLabQCenter.setClassName(iTestContext.getClass().getName());
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);
            } catch (Exception e) {
                LoggerUtil.logERROR(e.getMessage(), e);
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void logoutAndQuiteDriver() {
        GUIFunctionBase.closeBrowser();
    }

    /*
     * Login as MA User
     * Navigate to Customer Concierge Lobby
     *
     * */
    public void setupMAUserLogin(String userName){

        Home.clickSettings();
        Home.clickSetup();

        Home.searchMarketingAssociate(userName);
        Home.clickMAUserLoginButton();

        //Navigate to the Customer Concierge Lobby
        NavigateToCustomerConcierge.selectCustomerConcierge();

    }


    //Change the Profile
    public void changeProfile(){

        Home.changeProfile();
    }

}