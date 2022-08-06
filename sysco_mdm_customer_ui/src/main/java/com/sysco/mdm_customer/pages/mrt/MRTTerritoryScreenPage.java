package com.sysco.mdm_customer.pages.mrt;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class MRTTerritoryScreenPage {


    protected By drpDownTerritorySelect = By.xpath("(//input[@placeholder='--Select One--'])[1]");
    protected By drpDownOption = By.xpath("//div[@class='DESKTOP uiContainerManager']//li[1]//div[1]");
    protected By btnNext = By.xpath("//button[normalize-space()='Next']");
    protected By lblShipToInfo = By.xpath("//span[contains(text(),'SHIP TO INFORMATION')]");
    protected By btnClose = By.xpath("//button[@title='Remove selected option']//*[name()='svg']");



    //Select Territory
    public void selectTerritory() {

        syscoLabUI.waitTillElementLoaded(drpDownTerritorySelect, 15);
        syscoLabUI.clickWithJavascript(drpDownTerritorySelect);
        LoggerUtil.logINFO("Click Territory Drop Down");
        syscoLabUI.waitTillElementLoaded(drpDownOption, 5);
        syscoLabUI.clickWithJavascript(drpDownOption);
        syscoLabUI.waitTillElementLoaded(btnClose, 5);
        syscoLabUI.sleep(2);
        LoggerUtil.logINFO("Select a Territory from the Drop Down");

    }


    //Click Next Button in the Territory Select Screen
    public void clickNext() {

        syscoLabUI.waitTillElementLoaded(btnNext);
        syscoLabUI.clickWithJavascript(btnNext);
        LoggerUtil.logINFO("Click Next in Territory Select Screen");
        syscoLabUI.waitTillElementLoaded(lblShipToInfo,10);
    }
}
