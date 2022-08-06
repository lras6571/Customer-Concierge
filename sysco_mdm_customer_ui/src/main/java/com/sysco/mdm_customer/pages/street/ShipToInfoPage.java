package com.sysco.mdm_customer.pages.street;


import com.sysco.mdm_customer.pages.LoginPage;
import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class ShipToInfoPage extends LoginPage {


    private final By txtAccountName = By.xpath("//input[contains(@name,'accountName')]");
    private final By txtShippingStreet = By.xpath("//textarea[@name='street']");
    private final By txtShippingCity = By.xpath("//input[@name='city']");
    private final By txtShippingState = By.xpath("//input[@name='province']");
    private By txtOptionShippingState = By.xpath("//div[@role='option']//span[text()='#']");
    private final By txtShippingPostalCode = By.xpath("//input[@name='postalCode']");
    private By drpDwnShippingCountry = By.xpath("//input[@name='country']");
    private final By txtShippingCountry = By.xpath("//*[contains(@name,'shippingCountry')]");
    private final By txtAccountPhone = By.xpath("//input[contains(@name,'accountPhone')]");
    private final By drpDwnAccountGroup = By.xpath("//*[contains(@name,'accountGroup')]");
    private final By optionAccountGroup = By.xpath("//*[@role='option']//span[text()='#']");
    private final By rdBtnPrincipalOwner = By.xpath("(//input[@type='radio'])[last()]");
    private By optionShippingCountry = By.xpath("//*[@role='option']//span[text()='#']");
    private By drpDwnShippingState = By.xpath("//input[@placeholder='Search Shipping States']");
    //Secondary ship-to
    private final By btnNext = By.xpath("(//input[@value='Next'])[1]");


    public void enterShippingAccountName(String accountName) {
        syscoLabUI.sendKeys(txtAccountName, accountName);
    }


    public void selectShipToAccountGroup(String strAccountGroup) {
        syscoLabUI.clickWithJavascript(drpDwnAccountGroup);
        By accountGroup = DriverSetUpUtil.replaceInLocator(optionAccountGroup, "#", strAccountGroup);
        syscoLabUI.waitTillElementLoaded(accountGroup);
        syscoLabUI.clickWithJavascript(accountGroup);
    }


    public void confirmShippingAddress() {
        if (syscoLabUI.isDisplayed(btnNext)) {
            syscoLabUI.click(btnNext);
            syscoLabUI.sleep(2);
        }
    }

    public void addPrincipalOwner() {
        syscoLabUI.sleep(2);
        if (syscoLabUI.isDisplayed(rdBtnPrincipalOwner)) {
            syscoLabUI.clickWithJavascript(rdBtnPrincipalOwner);
        }
    }

    /*
     * Enter Shipping Details  (Shipping Street,Shipping City,Shipping State,Shipping PostalCode,ShipTo Country,ShipTo PhoneNumber)
     * */
    public void enterShippingStreet(String shippingStreet) {
        syscoLabUI.sendKeys(txtShippingStreet, shippingStreet);
    }

    public void enterShippingCity(String shippingCity) {
        syscoLabUI.sendKeys(txtShippingCity, shippingCity);
    }

    public void selectShippingState(String state) {
        syscoLabUI.sendKeys(txtShippingState, state);
//        By txtShippingState = DriverSetUpUtil.replaceInLocator(txtOptionShippingState,"#",state);
//        syscoLabUI.waitTillElementLoaded(drpDwnShippingState);
//        syscoLabUI.click(drpDwnShippingState);
//        syscoLabUI.sendKeys(drpDwnShippingState, state.trim());
//        syscoLabUI.waitTillElementLoaded(txtShippingState);
//        syscoLabUI.click(txtShippingState);
    }

    public void enterShippingPostalCode(String postalCode) {
        syscoLabUI.sendKeys(txtShippingPostalCode, postalCode);
    }

    public void selectShipToCountry(String strShipToCountry) {
       // syscoLabUI.sendKeys(txtShippingCountry, strShipToCountry);
        syscoLabUI.click(drpDwnShippingCountry);
        By shippingCountry = DriverSetUpUtil.replaceInLocator(optionShippingCountry,"#",strShipToCountry);
        syscoLabUI.waitTillElementLoaded(shippingCountry);
        syscoLabUI.click(shippingCountry);
//        syscoLabUI.sendKeys(drpDwnShippingCountry,strShipToCountry);
//        LoggerUtil.logINFO("Enter Country in the Field");
    }

    public void enterShipToPhoneNumber(String strShipToPhoneNumber) {
        syscoLabUI.sendKeys(txtAccountPhone, strShipToPhoneNumber);
    }
    /*
     * Assert Street Account CCA Flow Account Info Screen
     * */
    public boolean isAccountInfoFieldDisplayed() {
        return isElementDisplayed(txtAccountName) && isElementDisplayed(txtAccountPhone) && isElementDisplayed(drpDwnAccountGroup) && isElementDisplayed(txtShippingStreet) && isElementDisplayed(txtShippingCity) && isElementDisplayed(txtShippingState) && isElementDisplayed(txtShippingPostalCode) && isElementDisplayed(drpDwnShippingCountry);
    }
    public boolean isElementDisplayed(By element) {

        return syscoLabUI.waitTillElementLoaded(element).isDisplayed();
    }
}