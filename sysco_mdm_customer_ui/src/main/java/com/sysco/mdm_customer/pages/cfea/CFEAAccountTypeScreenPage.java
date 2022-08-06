package com.sysco.mdm_customer.pages.cfea;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEAAccountTypeScreenPage {


    protected By btnNo = By.xpath("(//span[@class='slds-radio_faux'])[2]");
    protected By btnYes = By.xpath("(//span[@class='slds-radio_faux'])[1]");
    protected By btnNext = By.xpath("(//button[normalize-space()='Next'])[1]");


    //Click the Next Location Button
    public void selectNewLocation() {

        syscoLabUI.waitTillElementLoaded(btnNo);
        syscoLabUI.moveToAndClick(btnNo);
        syscoLabUI.moveToAndClick(btnNext);
        LoggerUtil.logINFO("Click the Next Location Button");
    }


    //Select an Existing Location
    public void selectExistingLocation() {

        syscoLabUI.waitTillElementLoaded(btnYes);
        syscoLabUI.clickWithJavascript(btnYes);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Select an Existing Location Record");
    }
}
