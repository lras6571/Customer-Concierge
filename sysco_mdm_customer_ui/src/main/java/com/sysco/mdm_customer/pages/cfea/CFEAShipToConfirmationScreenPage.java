package com.sysco.mdm_customer.pages.cfea;

import com.sysco.mdm_customer.exceptions.CustomException;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.common.Constants.*;
import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEAShipToConfirmationScreenPage {

    protected By btnNext = By.xpath("(//button[normalize-space()='Next'])[1]");
    protected By lblConfirmation = By.xpath("//div[contains(text(),'Confirmation')]");
    protected By lblLead = By.xpath("//div[text()='Lead']");

    //Enter Next Button in Account Info - CADD Wizard
    public void clickNextShipToConfirmation(String key) {

        switch (key){
            case NET:
                syscoLabUI.waitTillElementLoaded(lblConfirmation,10);
                syscoLabUI.clickWithJavascript(btnNext);
                LoggerUtil.logINFO("Click next in Ship-To Confirmation Screen");
                break;
            case NLA:
            case NSL:
                syscoLabUI.waitTillElementLoaded(lblConfirmation,10);
                syscoLabUI.clickWithJavascript(btnNext);
                LoggerUtil.logINFO("Click next in Ship-To Confirmation Screen");
                syscoLabUI.waitTillElementLoaded(lblLead);
                LoggerUtil.logINFO("Wait till Account Load");
                break;
            default:
                throw new CustomException(KEY_NOT_FOUND + key);
        }

        syscoLabUI.sleep(10);
        LoggerUtil.logINFO("Wait till Response arrives from CORA Side");
    }

}
