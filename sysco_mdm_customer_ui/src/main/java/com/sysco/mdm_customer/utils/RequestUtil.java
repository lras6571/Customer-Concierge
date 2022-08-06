package com.sysco.mdm_customer.utils;

import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.common.URIs;
import com.sysco.mdm_customer.data.TokenRefreshData;
import com.syscolab.qe.core.api.jackson.JacksonUtil;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.Headers;
import com.syscolab.qe.core.api.util.RequestMethods;
import io.restassured.response.Response;
import request.CORARequest;


public class RequestUtil {

    RequestUtil() {
    }

    //SFDC Token for Blue Sky User
    public static String getSalesForceAccessToken(String clientID, String clientSecret, String username, String password) {

        RestUtil.API_HOST = Constants.CORA_TOKEN_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.SALESFORCE_TOKEN_URI;

        String body = "grant_type=password&client_id=CLIENTID&client_secret=CLIENTSECRET&username=USER_NAME&password=PASS_WORD"
                .replace("CLIENTID", clientID).replace("CLIENTSECRET", clientSecret).replace("USER_NAME", username)
                .replace("PASS_WORD", password);

        Response response = RestUtil.send(Headers.getHeaderUrlEncoded(), body, URI, RequestMethods.POST.toString());
        TokenRefreshData.response = response;
        Constants.SALESFORCE_BASE_URI = response.getBody().jsonPath().get("instance_url");
        URIs.RESPONSE_STATUS_CODE = response.statusCode();
        return response.getBody().jsonPath().get("access_token");
    }

    public static Response submitCreditApp(String key, String accountSSAID, String token) {
        CORARequest orderRequest = new CORARequest().getSubmissionPatchRequest(key);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.ACCOUNT_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }

    public static Response updateCreditAppDetails(String key, String accountSSAID, String token) {
        CORARequest orderRequest = new CORARequest().getBillToPatchRequest(key);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.ACCOUNT_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }

    public static Response approveShopCreditApp(String key, String token, String accountSSAID, String accountName) {
        CORARequest orderRequest = new CORARequest().getShopShipToPatchRequest(key, accountName);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.ACCOUNT_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }


    //CFEA Credit Approval by Cora End
    public static Response approveCreditApplication(String key, String token, String accountSSAID) {

        CORARequest orderRequest = new CORARequest().getCreditApprovePatchRequest(key);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.LEAD_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }


    //Inactivation Patch Request
    public static Response approveInactivation(String token, String accountSSAID,String appStatus,String coraResponse) {

        CORARequest orderRequest = new CORARequest().getInactivationPatchRequest(appStatus,coraResponse);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.ACCOUNT_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }


    //Reactivation Patch Request
    public static Response approveReactivation(String token, String accountSSAID,String appStatus,String coraResponse,String paymentTerms,String tax,String collector,String registered, String tribal, String creditAnalyst) {

        CORARequest orderRequest = new CORARequest().getReactivationPatchRequest(appStatus,coraResponse,paymentTerms,tax,collector,registered,tribal, creditAnalyst);
        String body = JacksonUtil.getAsString(orderRequest);

        RestUtil.API_HOST = Constants.SALESFORCE_BASE_URI;
        RestUtil.BASE_PATH = "";
        String URI = URIs.ACCOUNT_OBJECT_URI.replace("SSAID", accountSSAID);

        return RestUtil.send(Headers.getBearerHeaders(token), body, URI, RequestMethods.PATCH.name());
    }

}
