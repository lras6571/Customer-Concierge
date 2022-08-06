package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDDeliveryPreferenceScreenPage {

    protected By drpDwnDeliveryDate = By.xpath("//select[@name='pick_Deilvery_Day']");
    protected By txtTimeDeliveryWindow1Start = By.xpath("//input[@name='txt_Standard_Delivery_Window_1_Start']");
    protected By txtTimeDeliveryWindow1End = By.xpath("//input[@name='txt_Standard_Delivery_Window_1_End']");
    protected By txtBackdoorOpen = By.xpath("//input[@name='txt_Standard_Backdoor_Open']");
    protected By txtBackdoorClose = By.xpath("//input[@name='txt_Standard_Backdoor_Close']");
    protected By btnNextDeliveryPreference = By.xpath("//button[contains(text(),'Next')]");


    //Select the Delivery Date from the Drop-Down
    public void enterDeliveryDate(String deliveryDate) {

        syscoLabUI.waitTillElementLoaded(drpDwnDeliveryDate);
        Select date = new Select(syscoLabUI.findElement(drpDwnDeliveryDate));
        date.selectByVisibleText(deliveryDate);
        syscoLabUI.selectFromDropDown(drpDwnDeliveryDate, deliveryDate);
        LoggerUtil.logINFO("Select the Delivery Date from the Drop Down in Delivery Preference Screen");

    }

    //Fill the Standard Delivery Window 1 Start Time
    public void enterTimeDeliveryWindow1Start(String startTime) {
        syscoLabUI.sendKeys(txtTimeDeliveryWindow1Start, startTime);
        LoggerUtil.logINFO("Fill the Standard Delivery Window 1 Start Time in Delivery Preference Screen");
    }

    //Fill the Standard Delivery Window 1 End Time
    public void enterTimeDeliveryWindow1End(String endTime) {

        syscoLabUI.sendKeys(txtTimeDeliveryWindow1End, endTime);
        LoggerUtil.logINFO("Fill the Standard Delivery Window 1 End Time in Delivery Preference Screen");
    }

    //Fill the Standard Backdoor Open Time
    public void enterTimeBackdoorOpen(String openTime) {

        syscoLabUI.sendKeys(txtBackdoorOpen, openTime);
        LoggerUtil.logINFO("Fill the Standard Backdoor Open Time in Delivery Preference Screen");
    }

    //Fill the Standard Backdoor Close Time
    public void enterTimeBackdoorClose(String closeTime) {

        syscoLabUI.sendKeys(txtBackdoorClose, closeTime);
        LoggerUtil.logINFO("Fill the Standard Backdoor Close Time in Delivery Preference Screen");
    }

    //Enter Next Button in Account Info - CADD Wizard
    public void clickNextAccountInfo() {

        syscoLabUI.clickWithJavascript(btnNextDeliveryPreference);
        LoggerUtil.logINFO("Click Next in Delivery Preference Screen");
    }

}
