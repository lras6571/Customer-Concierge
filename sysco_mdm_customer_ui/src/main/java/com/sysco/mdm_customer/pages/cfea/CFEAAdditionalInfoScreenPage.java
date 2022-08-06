package com.sysco.mdm_customer.pages.cfea;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEAAdditionalInfoScreenPage {


    protected By txtRoutingInformation = By.xpath("(//input[@name='txtRoutingInformation'])[1]");
    protected By txtNationalID = By.xpath("(//input[@name='txtNationalAndLocalId'])[1]");
    protected By btnNext = By.xpath("(//button[normalize-space()='Next'])[1]");


    //Enter Routing Information
    public void enterRoutingInformation(String strRoutingInformation) {

        syscoLabUI.waitTillElementLoaded(txtRoutingInformation);
        syscoLabUI.sendKeys(txtRoutingInformation, strRoutingInformation);
        LoggerUtil.logINFO("Enter Routing Information");
    }


    //Enter National and Local ID
    public void enterNationalID(String strNationalID) {

        syscoLabUI.waitTillElementLoaded(txtNationalID);
        syscoLabUI.sendKeys(txtNationalID, strNationalID);
        LoggerUtil.logINFO("Enter National and Local ID");
    }


    //Click Next Button in the Additional Info Screen
    public void clickNextButton() {

        syscoLabUI.clickWithJavascript(btnNext);
        syscoLabUI.sleep(10);
        LoggerUtil.logINFO("Click Next Button in the Additional Info Screen");
    }
}
