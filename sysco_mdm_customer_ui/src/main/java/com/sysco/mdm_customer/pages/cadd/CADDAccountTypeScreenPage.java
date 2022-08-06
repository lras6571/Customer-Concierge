package com.sysco.mdm_customer.pages.cadd;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDAccountTypeScreenPage {

    protected By btnNewLocation = By.xpath("//button[contains(text(),'Create New Location')]");
    protected By btnFirstRecord = By.xpath("(//button[contains(text(),'Select')])[1]");
    protected By rdBtnFirstRecord = By.xpath("//span[@class='slds-radio_faux']");
    protected By txtExistingLocation = By.xpath("//div[contains(text(),'Select from existing location(s) below')]");


    //Click the Next Location Button
    public void selectNewLocation() {

        syscoLabUI.moveToAndClick(btnNewLocation);
        LoggerUtil.logINFO("Click the Next Location Button");
    }


    //Select an Existing Location
    public void selectExistingLocation() {

        syscoLabUI.scrollToElement(rdBtnFirstRecord);
        LoggerUtil.logINFO("Scroll Down to find Existing Location");
        syscoLabUI.waitTillElementLoaded(txtExistingLocation);
        syscoLabUI.clickWithJavascript(rdBtnFirstRecord);
        LoggerUtil.logINFO("Select an Existing Location Record");
    }

}
