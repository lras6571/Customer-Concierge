package com.sysco.mdm_customer.utils;

//import com.sysco.mdm_customer.api.common.Constant;
import com.sysco.mdm_customer.common.Constants;
import com.sysco.mdm_customer.data.CORARequestData;
import com.sysco.mdm_customer.data.LoginData;
import com.syscolab.qe.core.excelUtils.ReadExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Rifad on 3/6/18.
 */
public class ExcelUtil {


    protected static String username;
    protected static String password;
    protected static String marketingAssociate;
    protected static String mobileNumber;
    protected static String companyName;
    protected static String weeklySales;
    protected static String firstName;
    protected static String lastName;
    protected static String fullName;
    protected static String DSM;
    protected static String leadRating;
    protected static String SBSUser;
    protected static String conceptName;
    protected static String site;
    protected static String accountName;
    protected static String storeNumber;
    protected static String shippingStreet;
    protected static String shippingCity;
    protected static String shippingZip;
    protected static String state;
    protected static String email;
    protected static String deliveryDate;
    protected static String caddAccountType;
    protected static String billToName;
    protected static String startTime;
    protected static String endTime;
    protected static String openTime;
    protected static String closeTime;
    protected static String prospectName;
    protected static String accountType;
    protected static String shipToPhone;
    protected static String accountGroup;
    protected static String postalCode;
    protected static String accountCountry;
    protected static String accountState;
    protected static String streetEmail;
    protected static String typeOfCuisine;
    protected static String typeOfOperation;
    protected static String localTypeOfOperation;
    protected static String territoryCode;
    protected static FileInputStream fs;
    public static final String HOME_DIRECTORY = "user.dir";

//    //Read values from test.properties file
//    public static void getLoginData(String mdmLoginKey01) throws IOException {
//
//        Properties prop = new Properties();
//        fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\test.properties");
//        prop.load(fs);
//
//        username = prop.getProperty("username");
//        password = prop.getProperty("password");
//        marketingAssociate=prop.getProperty("marketingAssociate");
//        mobileNumber=prop.getProperty("mobileNumber");
//        companyName=prop.getProperty("companyName");
//        weeklySales=prop.getProperty("weeklySales");
//        firstName=prop.getProperty("firstName");
//        lastName=prop.getProperty("lastName");
//        fullName=prop.getProperty("fullName");
//        DSM=prop.getProperty("DSM");
//        leadRating=prop.getProperty("leadRating");
//        SBSUser=prop.getProperty("SBSUser");
//        conceptName=prop.getProperty("conceptName");
//        site=prop.getProperty("site");
//        accountName=prop.getProperty("accountName");
//        storeNumber=prop.getProperty("storeNumber");
//        shippingStreet=prop.getProperty("shippingStreet");
//        shippingCity=prop.getProperty("shippingCity");
//        shippingZip=prop.getProperty("shippingZip");
//        state=prop.getProperty("state");
//        email=prop.getProperty("email");
//        deliveryDate=prop.getProperty("deliveryDate");
//        startTime=prop.getProperty("startTime");
//        endTime=prop.getProperty("endTime");
//        openTime=prop.getProperty("openTime");
//        closeTime=prop.getProperty("closeTime");
//        caddAccountType=prop.getProperty("caddAccountType");
//        billToName=prop.getProperty("billToName");
//        territoryCode=prop.getProperty("territoryCode");
//        prospectName=prop.getProperty("prospectName");
//        accountType=prop.getProperty("accountType");
//        shipToPhone=prop.getProperty("shipToPhone");
//        accountGroup=prop.getProperty("accountGroup");
//        postalCode=prop.getProperty("postalCode");
//        accountCountry=prop.getProperty("accountCountry");
//        accountState=prop.getProperty("accountState");
//        streetEmail=prop.getProperty("streetEmail");
//        typeOfCuisine=prop.getProperty("typeOfCuisine");
//        typeOfOperation=prop.getProperty("typeOfOperation");
//        localTypeOfOperation=prop.getProperty("localTypeOfOperation");
//
//    }
//
//    public String getUsername() {
//
//        return username;
//    }
//    public String getPassword() {
//
//        return password;
//    }
//
//    public String getMarketingAssociate() {
//
//        return marketingAssociate;
//    }
//
//    public String getMobileNumber() {
//
//        return mobileNumber;
//    }
//
//    public String getCompanyName() {
//
//        return companyName;
//    }
//
//    public String getWeeklySales() {
//
//        return weeklySales;
//    }
//
//    public String getFirstName() {
//
//        return firstName;
//    }
//
//    public String getLastName() {
//
//        return lastName;
//    }
//
//    public String getFullName() {
//
//        return fullName;
//    }
//
//    public String getDSM() {
//
//        return DSM;
//    }
//
//    public String getLeadRating() {
//
//        return leadRating;
//    }
//
//    public String getSBSUser() {
//
//        return SBSUser;
//    }
//
//    public String getConceptName() {
//
//        return conceptName;
//    }
//
//    public String getSite() {
//
//        return site;
//    }
//
//    public String getAccountName() {
//
//        return accountName;
//    }
//
//    public String getStoreNumber() {
//
//        return storeNumber;
//    }
//
//    public String getShippingStreet() {
//
//        return shippingStreet;
//    }
//
//    public String getShippingCity() {
//
//        return shippingCity;
//    }
//
//    public String getShippingZip() {
//
//        return shippingZip;
//    }
//
//    public String getState() {
//
//        return state;
//    }
//
//    public String getEmail() {
//
//        return email;
//    }
//
//    public String getCADDAccountType() {
//
//        return caddAccountType;
//    }
//
//    public String getBillToName() {
//
//        return billToName;
//    }
//    public String getDeliveryDate() {
//
//        return deliveryDate;
//    }
//
//    public String getStartTime() {
//
//        return startTime;
//    }
//
//    public String getEndTime() {
//
//        return endTime;
//    }
//
//    public String getOpenTime() {
//
//        return openTime;
//    }
//
//    public String getCloseTime() {
//
//        return closeTime;
//    }
//
//    public String getTerritoryCode() {
//
//        return territoryCode;
//    }
//    public String getProspectName() {
//
//        return prospectName;
//    }
//    public String getAccountType() {
//
//        return accountType;
//    }
//    public String getShipToPhone() {
//
//        return shipToPhone;
//    }
//    public String getAccountGroup() {
//
//        return accountGroup;
//    }
//    public String getPostalCode() {
//
//        return postalCode;
//    }
//    public String getAccountCountry() {
//
//        return accountCountry;
//    }
//
//    public String getAccountState() {
//
//        return accountState;
//    }
//    public String getStreetEmail() {
//
//        return streetEmail;
//    }
//    public String getTypeOfCuisine() {
//
//        return typeOfCuisine;
//    }
//    public String getTypeOfOperation() {
//
//        return typeOfOperation;
//    }
//    public String getLocalTypeOfOperation() {
//
//        return localTypeOfOperation;
//    }

    public static CORARequestData getCORARequestData(String key) {
        Object coraRequestObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+ Constants.TEST_DATA_PATH +"CORARequestData.xls", 0, CORARequestData.class);
        return (CORARequestData) coraRequestObject;
    }

    public static LoginData getLoginData(String key) {
        Object loginObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+ Constants.TEST_DATA_PATH +"TestData.xls", 0, LoginData.class);
        return (LoginData) loginObject;
    }
}
