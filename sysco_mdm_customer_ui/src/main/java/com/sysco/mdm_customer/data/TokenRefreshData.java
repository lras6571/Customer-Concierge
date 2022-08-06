package com.sysco.mdm_customer.data;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.utils.DateUtils;
import io.restassured.response.Response;


public class TokenRefreshData {

    private TokenRefreshData(){
    }

    public static String[] recipients = Constants.RECIPIENT_MAIL_ID.split(";");
    public static String senderEmailId = "lasan.rashmika@syscolabs.com";

    public static String adminUser = "Force.com Team";
    public static String subject = "Token Refresh in Staging - " + DateUtils.getCurrentDate();

    public static final String SMTP_HOST_NAME = "smtp.office365.com";
    public static final String SMTP_AUTH_USER = Constants.SENDER_MAIL_ID;
    public static final String SMTP_AUTH_PWD = Constants.SENDER_MAIL_PASSWORD;

    public static String token1 = "CADD";

    public static String token2 = "APIGEE QA Access";
    public static String token3 = "CoraQA";
    public static String authenticationStatus1 = "Authenticated";
    public static String fileName = " Refresh Error.png";
    public static String[] attachments = new String[]{token1 + fileName,
            token2 + fileName,
            token3 + fileName};
    public static Response response;
}
