package com.sysco.mdm_customer.common;

public class URIs {

    private URIs() {
    }

    //Patch Request URLs
    public static final String SALESFORCE_TOKEN_URI = "services/oauth2/token";
    public static final String ACCOUNT_OBJECT_URI = "services/data/v52.0/sobjects/Account/SSAID";
    public static final String LEAD_OBJECT_URI = "services/data/v52.0/sobjects/Lead/SSAID";
    public static int RESPONSE_STATUS_CODE = 111;

}
