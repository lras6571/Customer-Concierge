package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDShipToConfirmationScreenPage {

    SoftAssert softAssert;
    protected By lblConceptID = By.xpath("(//dt[1])[1]");
    protected By lblBusinessName = By.xpath("(//dt[2])[1]");
    protected By lblAccountType = By.xpath("(//dt[3])[1]");
    protected By lblBusinessPhone = By.xpath("(//dt[4])[1]");
    protected By lblStoreNumber = By.xpath("(//dt[5])[1]");
    protected By lblShippingStreet = By.xpath("(//dt[1])[3]");
    protected By lblShippingDetails = By.xpath("(//dt[2])[3]");
    protected By lblContactName = By.xpath("(//dt[1])[4]");
    protected By lblContactPhone = By.xpath("(//dt[3])[2]");
    protected By lblContactEmail = By.xpath("(//dt[2])[4]");
    protected By lblTerritorySite = By.xpath("(//dt[1])[2]");
    protected By lblTerritoryCode = By.xpath("(//dt[2])[2]");
    protected By lblDeliveryDay = By.xpath("(//dt[1])[5]");
    protected By lblDeliveryWindow = By.xpath("(//dt[2])[5]");
    protected By lblDeliveryBackdoor = By.xpath("(//dt[3])[3]");
    protected By btnClickNext = By.xpath("//button[contains(text(),'Next')]");
    protected By btnNext = By.xpath("//button[contains(text(),'Next')]");
    protected By lblShipToConfirmationScreen = By.xpath("//div[contains(text(),'Confirmation')]");



    //Assert Concept ID in Ship To Confirmation Screen
    public void assertConceptID(String conceptID) {

        softAssert = new SoftAssert();
        syscoLabUI.waitTillElementLoaded(lblShipToConfirmationScreen);
        String conID = Arrays.toString((syscoLabUI.getText(lblConceptID)).split(": "));
        softAssert.assertEquals(conceptID, conID, "Concept ID is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Concept ID Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Business Name in Ship To Confirmation Screen
    public void assertBusinessName(String companyName) {

        String businessName = Arrays.toString((syscoLabUI.getText(lblBusinessName)).split(": "));
        softAssert.assertEquals(companyName, businessName, "Business Name is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Business Name Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Account Type in Ship To Confirmation Screen
    public void assertAccountType(String caddAccountType) {

        String accType = Arrays.toString((syscoLabUI.getText(lblAccountType)).split(": "));
        softAssert.assertEquals(caddAccountType, accType, "Account Type is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Account Type Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Business Phone in Ship To Confirmation Screen
    public void assertBusinessPhone(String mobileNumber) {

        String phoneNum = Arrays.toString((syscoLabUI.getText(lblBusinessPhone)).split(": "));
        softAssert.assertEquals(mobileNumber, phoneNum, "Business Phone is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Business Phone Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Store Number in Ship To Confirmation Screen
    public void assertStoreNumber(String storeNumber) {

        if (syscoLabUI.isDisplayed(lblStoreNumber)) {

            String storeNum = Arrays.toString((syscoLabUI.getText(lblStoreNumber)).split(": "));
            softAssert.assertEquals(storeNumber, storeNum, "Store Number is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Store Number Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Shipping Street in Ship To Confirmation Screen
    public void assertShippingStreet(String shippingStreet) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {
            String shippingStreet1 = syscoLabUI.getText(lblShippingStreet);
            softAssert.assertEquals(shippingStreet, shippingStreet1, "Shipping Street is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Shipping Street Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Shipping City in Ship To Confirmation Screen
    public void assertShippingCity(String shippingCity) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {
            String city = syscoLabUI.getText(lblShippingDetails).split(",")[0].trim();
            softAssert.assertEquals(shippingCity, city, "Shipping City is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Shipping City Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Shipping State in Ship To Confirmation Screen
    public void assertShippingState(String shippingState) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {
            String state = syscoLabUI.getText(lblShippingDetails).split(",")[1].trim().substring(0,2);
            softAssert.assertEquals(shippingState, state, "Shipping State is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Shipping State Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Shipping Zip in Ship To Confirmation Screen
    public void assertShippingZip(String shippingZip) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {
            String zip = (syscoLabUI.getText(lblShippingDetails).split(",")[1].trim()).replaceAll("[^0-9]", "");
            softAssert.assertEquals(shippingZip, zip, "Shipping Zip is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Shipping Zip Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Contact Name in Ship To Confirmation Screen
    public void assertContactName(String fullName) {

        String contactName = Arrays.toString((syscoLabUI.getText(lblContactName)).split(": "));
        softAssert.assertEquals(contactName, fullName, "Contact Number is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Contact Name Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Contact Email in Ship To Confirmation Screen
    public void assertContactEmail(String email) {

        String contactEmail = Arrays.toString((syscoLabUI.getText(lblContactEmail)).split(": "));
        softAssert.assertEquals(contactEmail, email, "Contact Email is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Contact Email Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Contact Number in Ship To Confirmation Screen
    public void assertContactNumber(String mobileNumber) {

        String phoneNum = Arrays.toString((syscoLabUI.getText(lblContactPhone)).split(": "));
        softAssert.assertEquals(mobileNumber, phoneNum, "Contact Number is displayed incorrectly in Ship To confirmation screen");
        LoggerUtil.logINFO("Contact Number Assertion Success in Ship To Confirmation Screen");
    }


    //Assert Territory Site in Ship To Confirmation Screen
    public void assertTerritorySite(String site) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {

            String territorySite = Arrays.toString((syscoLabUI.getText(lblTerritorySite)).split(": "));
            softAssert.assertEquals(territorySite, site, "Territory Site is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Territory Site Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Assert Territory Code in Ship To Confirmation Screen
    public void assertTerritoryCode(String territoryCode) {

        if (syscoLabUI.isDisplayed(lblShippingDetails)) {

            String territoryID = Arrays.toString((syscoLabUI.getText(lblTerritoryCode)).split(": "));
            softAssert.assertEquals(territoryCode, territoryID, "Territory Code is displayed incorrectly in Ship To confirmation screen");
            LoggerUtil.logINFO("Territory Code Assertion Success in Ship To Confirmation Screen");
        }
    }


    //Click Next in Ship To Confirmation Screen
    public void clickNextShipToScreen() {

        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click next in Ship To Screen");
    }

}
