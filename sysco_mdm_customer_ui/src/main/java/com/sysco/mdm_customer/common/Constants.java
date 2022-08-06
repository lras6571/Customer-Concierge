package com.sysco.mdm_customer.common;

import com.sysco.mdm_customer.data.TestEnvironments;

public class Constants {

    private Constants(){
    }

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /*
     * QCenter
     * */
    public static final String TEST_ENV = System.getProperty("test.env", TestEnvironments.STG_ENVIRONMENT.getEnvironment());
    public static final String TEST_RELEASE = System.getProperty("test.release", "MDMC_CC_REG_WEEKLY_BUILD");
    public static final String TEST_PROJECT = System.getProperty("test.project", "Customer Concierge");

    /*
     * QCenter Modules and Features
     * */
    public static final String FEATURE_QCENTER = "feature";
    public static final String MODULE_UI_MDMC_CC_USBL = "MDMC_CC_USBL_UI";
    public static final String MODULE_UI_MDMC_CC_CFEA = "MDMC_CC_CFEA_UI";

    public static final String FEATURE_UI_USBL_LEAD_CREATION = "USBL_LEAD_CREATION";
    public static final String FEATURE_UI_USBL_STREET_ACC_CREATION = "USBL_STREET_ACC_CREATION";
    public static final String FEATURE_UI_USBL_CADD_ACC_CREATION = "USBL_CADD_ACC_CREATION";
    public static final String FEATURE_UI_USBL_PS_ACC_CREATION = "USBL_PS_ACC_CREATION";
    public static final String FEATURE_UI_USBL_ACC_MAINTENANCE = "USBL_ACC_MAINTENANCE";

    public static final String FEATURE_UI_CFEA_FP_LEAD_CREATION = "CFEA_FP_LEAD_CREATION";
    public static final String FEATURE_UI_CFEA_AF_LEAD_CREATION = "CFEA_AF_LEAD_CREATION";
    public static final String FEATURE_UI_CFEA_CA_LEAD_CREATION = "CFEA_CA_LEAD_CREATION";
    public static final String FEATURE_UI_CFEA_FP_ACC_CREATION = "CFEA_FP_ACC_CREATION";
    public static final String FEATURE_UI_CFEA_AF_ACC_CREATION = "CFEA_AF_ACC_CREATION";
    public static final String FEATURE_UI_CFEA_CA_ACC_CREATION = "CFEA_CA_ACC_CREATION";
    public static final String FEATURE_UI_CFEA_FP_ACC_MAINTENANCE = "CFEA_FP_ACC_MAINTENANCE";
    public static final String FEATURE_UI_CFEA_AF_ACC_MAINTENANCE = "CFEA_AF_ACC_MAINTENANCE";
    public static final String FEATURE_UI_CFEA_CA_ACC_MAINTENANCE = "CFEA_CA_ACC_MAINTENANCE";

    /*
     * Update Data
     * */
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", FALSE));
    public static final boolean IS_CREATE_BUILD_ENABLED = Boolean.parseBoolean(System.getProperty("create.build", FALSE));
    public static final boolean IS_DATA_INJECTED = Boolean.parseBoolean(System.getProperty("load.data", FALSE));
    public static final boolean IS_DATA_CLEANED_BEFORE_SUITE = Boolean.parseBoolean(System.getProperty("clean.data.before", FALSE));
    public static final boolean IS_DATA_CLEANED_AFTER_SUITE = Boolean.parseBoolean(System.getProperty("clean.data.after", FALSE));
    public static final int GUI_RETRY_COUNT = Integer.parseInt(System.getProperty("retry.count", "3"));

    public static final String TEST_RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    public static final String TEST_ACCOUNT_DATA_DIRECTORY = "testData/";
    public static final String STREET_ACCOUNT_DATA_JSON_FILE = "StreetAccountData.json";
    public static final String LOGIN_DATA_JSON_FILE = "LoginData.json";
    public static final String LEAD_DATA_JSON_FILE = "LeadAccountData.json";
    public static final String CADD_DATA_JSON_FILE = "CADDAccountData.json";
    public static final String SBS_DATA_JSON_FILE = "SBSApprovalData.json";
    public static final String AF_LEAD_DATA_JSON_FILE = "AsianFoodsAccountData.json";
    public static final String FP_LEAD_DATA_JSON_FILE = "FreshPointLeadAccountData.json";
    public static final String MRT_DATA_JSON_FILE = "MRTAccountData.json";
    public static final String MRT_ASSERTION_JSON_FILE = "AssertionData.json";
    public static final String INPUT_ACCOUNT_DETAIL_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + STREET_ACCOUNT_DATA_JSON_FILE;
    public static final String INPUT_LOGIN_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + LOGIN_DATA_JSON_FILE;
    public static final String INPUT_LEAD_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + LEAD_DATA_JSON_FILE;
    public static final String INPUT_CADD_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + CADD_DATA_JSON_FILE;
    public static final String INPUT_SBS_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + SBS_DATA_JSON_FILE;
    public static final String INPUT_AF_LEAD_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + AF_LEAD_DATA_JSON_FILE;
    public static final String INPUT_FP_LEAD_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + FP_LEAD_DATA_JSON_FILE;
    public static final String INPUT_MRT_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + MRT_DATA_JSON_FILE;
    public static final String INPUT_ASSERTION_JSON_FILE = TEST_ACCOUNT_DATA_DIRECTORY + MRT_ASSERTION_JSON_FILE;

    public static final String LEAD_VIEW_LIST_1 = "My Leads";
    public static final String ACCOUNT_VIEW_LIST_1 = "My Active Accounts";
    public static final String ACCOUNT_VIEW_LIST_2 = "My Inactive Accounts/Prospects";
    public static final String ACCOUNT_VIEW_LIST_3 = "FreshPoint Active 115 OpCo";
    public static final String ACCOUNT_VIEW_LIST_4 = "Asian Foods 103 Active";
    public static final String ACCOUNT_VIEW_LIST_5 = "Asian Foods Inactive 103 OpCo";
    public static final String ACCOUNT_VIEW_LIST_6 = "FreshPoint Inactive 115 OpCo";

    public static final String CORA_TOKEN_BASE_URI = "https://test.salesforce.com";
    public static String SALESFORCE_BASE_URI = "https://sysco--staging.my.salesforce.com";

    //Token Refresh.
    public static final String RECIPIENT_MAIL_ID = System.getProperty("recipient.mail.id", "");
    public static final String SENDER_MAIL_ID = System.getProperty("sender.email.id", "");
    public static final String SENDER_MAIL_PASSWORD = System.getProperty("sender.email.password", "");

    public static final String SR_TO_VERIFY = "";
    public static final String TEST_DATA_PATH = "/src/main/resources/testData/";

    //CORA API connected app
    public static final String CLIENT_KEY_STAGING = System.getProperty("client.key", "3MVG9ayzKZt5EleGNsDppj_ex8aRUOFN92D1.LMFOsAqgNReZP3RfrlafRllpRPzP73uTw8E1OsSrJzM2zW_5");
    public static final String CLIENT_SECRET_STAGING = System.getProperty("client.secret", "AB23F482CBA589F8443EDFE9E56369655889912CECC6C00ED4793A11E1292798");

    //Data Reference Keys
    public static final String SFDC_CFEA_FP_LEAD_USER = "SFDC_CFEA_FP_LEAD_USER";
    public static final String SFDC_CFEA_AF_LEAD_USER = "SFDC_CFEA_AF_LEAD_USER";

    //Data Account Types
    public static final String NET = "NET";
    public static final String NSL = "NSL";
    public static final String NLA = "NLA";

    //Data Queue Types
    public static final String AF_NCOB_QUEUE = "Asian Foods NCOB Queue";
    public static final String FP_NCOB_QUEUE = "FreshPoint NCOB Queue";

    public static final String KEY_NOT_FOUND = "KEY_NOT_FOUND";

    //Inactivation Patch Request
    public static final String APP_STATUS = "Approved";
    public static final String CORA_RESPONSE_JSON = "Approved testing";


    //Reactivation Patch Request
    public static final String PAYMENT_TERMS = "Net 7";
    public static final String TAX_YES = "Yes";
    public static final String TAX_NO = "No";
    public static final String COLLECTOR__c = "ACLAG056";
    public static final String REGISTERED__c = "No";
    public static final String TRIBAL_LAND = "No";
    public static final String CREDIT_ANALYST= "ACCAF056";

}