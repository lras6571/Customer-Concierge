package com.sysco.mdm_customer.common;


public class GUIConstants {
    GUIConstants() {
    }

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /*
     * Runtime
     * */
    public static final String BASE_PROTOCOL = System.getProperty("api.protocol", "https://");
    public static final String APP_BROWSER = System.getProperty("app.browser", "chrome");
    public static final String APP_URL = System.getProperty("app.url", "https://test.salesforce.com/");





}
