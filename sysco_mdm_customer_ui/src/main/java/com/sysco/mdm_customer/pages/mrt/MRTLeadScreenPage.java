package com.sysco.mdm_customer.pages.mrt;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class MRTLeadScreenPage {


    protected By btnProspectShop = By.xpath("//span[contains(text(),'Prospect Shop')]");
    protected By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");
    protected By lblLeadOwner = By.xpath("//span[contains(text(),'Lead Owner')]");
    protected By btnArrow = By.xpath("//button[@class='slds-button slds-button_icon-border-filled']");

    //Click Prospect Shop
    public void clickProspectShop() {

        syscoLabUI.waitTillElementLoaded(lblDetails, 25);
        syscoLabUI.clickWithJavascript(lblDetails);
        LoggerUtil.logINFO("MRT Lead Loaded");


        try {
            syscoLabUI.waitTillElementLoaded(btnProspectShop,5);
            syscoLabUI.clickWithJavascript(btnProspectShop);

        }
        catch(Exception e) {
            syscoLabUI.clickWithJavascript(btnArrow);
            syscoLabUI.waitTillElementLoaded(btnProspectShop,5);
            syscoLabUI.clickWithJavascript(btnProspectShop);
        }

        LoggerUtil.logINFO("Click Prospect Shop Button");

    }
}
