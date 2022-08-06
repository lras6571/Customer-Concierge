package com.sysco.mdm_customer.pages.sr;

import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class SupportRequestDetailPage {

    private final By txtSupportRequestOwner = By.xpath("//span[text()='Support Request Owner']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::span[@force-lookup_lookup]");
    private final By txtStatus = By.xpath("//span[text()='Status']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::slot//lightning-formatted-text");
    private final By txtCaseRequestType = By.xpath("//span[text()='Case Request Type']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtCreditApplicationStatus = By.xpath("//span[text()='Credit Application Status']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtREQNumber = By.xpath("//span[text()='REQ#']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");

    /*
     * Verify the SR Support Request Owner
     * */
    public String verifySupportRequestOwner() {
        syscoLabUI.waitTillElementDisappear(txtSupportRequestOwner);
        return syscoLabUI.getText(txtSupportRequestOwner);
    }

    /*
     * Verify the SR Status
     * */
    public String verifyStatus() {
        syscoLabUI.waitTillElementDisappear(txtStatus);
        return syscoLabUI.getText(txtStatus);
    }

    /*
     * Verify the Case Request Type in SR Screen
     * */
    public String verifyInitiateSRScreenCaseRequestType() {

        syscoLabUI.waitTillElementLoaded(txtCaseRequestType,20);
        return syscoLabUI.getText(txtCaseRequestType);

    }

    /*
     * Verify the Credit Application Status in SR Screen
     * */
    public String verifyInitiateSRScreenCreditApplicationStatus() {

        syscoLabUI.waitTillElementLoaded(txtCreditApplicationStatus);
        return syscoLabUI.getText(txtCreditApplicationStatus);
    }

    /*
     * Verify the REQ# in SR Screen
     * */
    public String verifyInitiateSRScreenREQNumber() {
        syscoLabUI.waitTillElementDisappear(txtREQNumber);
        return syscoLabUI.getText(txtREQNumber);

    }
}
