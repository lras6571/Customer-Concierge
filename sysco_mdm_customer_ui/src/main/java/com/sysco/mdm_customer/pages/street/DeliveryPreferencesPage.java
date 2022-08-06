package com.sysco.mdm_customer.pages.street;

import com.sysco.mdm_customer.pages.LoginPage;
import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class DeliveryPreferencesPage extends LoginPage {
    private final By drpDwnDeliveryDate = By.xpath("//select[@name='pick_Deilvery_Day']");
    private final By txtTimeDeliveryWindow1Start = By.xpath("//input[@name='txt_Standard_Delivery_Window_1_Start']");
    private final By txtTimeDeliveryWindow1End = By.xpath("//input[@name='txt_Standard_Delivery_Window_1_End']");
    private final By txtBackdoorOpen = By.xpath("//input[@name='txt_Standard_Backdoor_Open']");
    private final By txtBackdoorClose = By.xpath("//input[@name='txt_Standard_Backdoor_Close']");
    private final By rdBtnYesToAddDetails = By.xpath("(//input[@type='radio'])[1]");
    private final By txtDeliveryDate = By.xpath("//option[text()='#']");


    public void clickYesDeliveryPreferences() {
        syscoLabUI.sleep(1);
        if (syscoLabUI.isDisplayed(rdBtnYesToAddDetails)) {
            syscoLabUI.clickWithJavascript(rdBtnYesToAddDetails);
        }
    }


    public void enterDeliveryDate(String deliveryDate) {
        syscoLabUI.waitTillElementLoaded(drpDwnDeliveryDate);
        syscoLabUI.clickWithJavascript(drpDwnDeliveryDate);
        By textDeliveryDateValue = DriverSetUpUtil.replaceInLocator(txtDeliveryDate, "#", deliveryDate);
        syscoLabUI.waitTillElementLoaded(textDeliveryDateValue);
        syscoLabUI.clickWithJavascript(textDeliveryDateValue);


    }


    public void enterTimeDeliveryWindow1Start(String startTime) {
        syscoLabUI.sendKeys(txtTimeDeliveryWindow1Start, startTime);
    }

    public void enterTimeDeliveryWindow1End(String endTime) {
        syscoLabUI.sendKeys(txtTimeDeliveryWindow1End, endTime);
    }

    public void enterTimeBackdoorOpen(String openTime) {
        syscoLabUI.sendKeys(txtBackdoorOpen, openTime);
    }

    public void enterTimeBackdoorClose(String closeTime) {
        syscoLabUI.sendKeys(txtBackdoorClose, closeTime);
    }

    public boolean isDeliveryPreferencesFieldDisplayed() {
        return isElementDisplayed(drpDwnDeliveryDate) && isElementDisplayed(txtTimeDeliveryWindow1Start) && isElementDisplayed(txtTimeDeliveryWindow1End) && isElementDisplayed(txtBackdoorOpen) && isElementDisplayed(txtBackdoorClose);
    }
    public boolean isElementDisplayed(By element) {
        return syscoLabUI.waitTillElementLoaded(element).isDisplayed();
    }

}