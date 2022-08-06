package com.sysco.mdm_customer.pages.cfea;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CFEABillToConfirmationScreenPage {

    protected By btnSendCreditApplication = By.xpath("//a[@data-value='Send Credit Application']");
    protected By lblLead = By.xpath("//div[text()='Lead']");

    //Click Send Credit Application
    public void clickNextBillToConfirmation() {

        syscoLabUI.waitTillElementLoaded(btnSendCreditApplication, 10);
        syscoLabUI.clickWithJavascript(btnSendCreditApplication);
        LoggerUtil.logINFO("Click Send Credit Application in Bill to Screen");
        syscoLabUI.waitTillElementLoaded(lblLead);
        LoggerUtil.logINFO("Wait for Account load");
        syscoLabUI.sleep(10);

    }
}
