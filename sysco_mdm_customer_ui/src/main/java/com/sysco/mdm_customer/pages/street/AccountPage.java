package com.sysco.mdm_customer.pages.street;

import com.sysco.mdm_customer.data.StreetAccountData;
import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class AccountPage {
    String pageURL;
    private static Map<String, String> shippingAddressDataMap;
    private static Map<String, String> billingAddressDataMap;
    private final By btnCreateRequest = By.xpath("//button[@name='Account.Create_Request_USBL']");
    private final By btnMore = By.xpath("//span[contains(text(),'Show more actions')]//parent::button");
    private final By lnkCreateRequest = By.xpath("//span[text()='Create Request']//ancestor::a[@role='menuitem']");
    private final By lblAccountMaintenance = By.xpath("//span[contains(text(),'Account Maintenance')]");
    private final By rdBtnAccountMaintenance = By.xpath("//input[@type='radio' and @data-label='Account Maintenance']");
    private final By rdBtnInactivationRequest = By.xpath("//input[@type='radio' and @data-label='Inactivation Account Request']");
    private final By rdBtnReactivationRequest = By.xpath("//input[@type='radio' and @data-label='Reactivation Account Request']");
    private final By lblShippingAddress = By.xpath("//strong[text()='Shipping Address:']//parent::p//following-sibling::p");
    private final By lblBillingAddress = By.xpath("//strong[normalize-space()='Shipping Address:']");
    private final By lnkSupportRequestId = By.xpath("//a[@data-refid='recordId']//ancestor::table[@aria-label='Support Requests']//tbody//tr[1]//th//child::a");
    private final By lnkSupportRequest = By.xpath("//li[(contains(@class,'relatedListQuickLink'))]//span[(contains(text(),'Support Requests')) and (contains(@class,'slds-assistive-text'))]");
    private final By lnkCFEASupportRequest = By.xpath("(//span[normalize-space()='Support Requests'])[1]");
    private final By txtCaseRequestType = By.xpath("//span[text()='Case Request Type']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtCreditApplicationStatus = By.xpath("//span[text()='Credit Application Status']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtCreateMaintain = By.xpath("//span[text()='Account Create/Maintain']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtStatus = By.xpath("//span[text()='Status']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    //private final By txtStatus = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11'])[12]");
    private final By txtAccountRole = By.xpath("//span[text()='Account Role']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    private final By txtApplicationRequestType = By.xpath("//span[text()='Application Request Type']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::lightning-formatted-text");
    //private final By txtApplicationRequestType = By.xpath("//li[(contains(@class,'relatedListQuickLink'))]//span[(contains(text(),'Support Requests')) and (contains(@class,'slds-assistive-text'))]");
    private final By chkEmailCreditApplication = By.xpath("//span[text()='eMail Credit Application']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//child::input");
    private final By txtRelatedLinks = By.xpath("//h2[text()='Related List Quick Links']");
    private final By txtAccountName = By.xpath("//div[contains(@class,'sfaOutputNameWithHierarchyIcon')]//lightning-formatted-text[text()='#']");
    private final By lnkViewAllContacts = By.xpath("//span[contains(text(),'Related Contacts')]/../parent::a");
    private final By lnkSupportRequestID = By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
    private final By lnkSupportRequestRecord = By.xpath("(//a[@data-refid='recordId'])[1]");
    private final By lblSupportRequest = By.xpath("(//span[@class='slds-truncate slds-m-right--xx-small'])[2]");
    private final By lblOpportunities = By.xpath("//span[@title='Opportunities']");
    private final By lblLeftPanel = By.xpath("//flexipage-record-home-scrollable-column[@id='leftColumn-75']");
    private final By lblDetails = By.xpath("(//a[normalize-space()='Details'])[1]");
    protected By lnkScrollBar = By.xpath("//flexipage-component2[@data-component-id='cstServed']");
    private ArrayList<String> shippingAddressDataList;
    private ArrayList<String> billingAddressDataList;

    /*
     * Click Create Request Option in Active Account
     * */
    public void clickCreateRequest() {
        syscoLabUI.sleep(3);
        if (syscoLabUI.isDisplayed(btnCreateRequest)) {
            syscoLabUI.clickWithJavascript(btnCreateRequest);
        } else {

            if (syscoLabUI.isDisplayed(btnMore)) {
                clickVisibleElement(btnMore);
                new WebDriverWait(SyscoLabUI.driver, 10).until(ExpectedConditions.attributeToBe(btnMore, "aria-expanded", "true"));
            }
            if (syscoLabUI.isDisplayed(lnkCreateRequest)) {
                syscoLabUI.clickWithJavascript(lnkCreateRequest);
            }
        }
        LoggerUtil.logINFO("Click the Create Request");

    }

    public void clickVisibleElement(By xpath) {
        syscoLabUI.clickWithJavascript(syscoLabUI.findVisibleElements(xpath).get(0));
    }

    //Select Inactivation Option in Account Maintenance
    public void selectInactivationRadioButton() {

        syscoLabUI.waitTillElementLoaded(rdBtnAccountMaintenance,5);
        syscoLabUI.clickWithJavascript(rdBtnAccountMaintenance);
        syscoLabUI.waitTillElementLoaded(rdBtnInactivationRequest,5);
        syscoLabUI.clickWithJavascript(rdBtnInactivationRequest);
        LoggerUtil.logINFO("Select Inactivation Option in Account Maintenance");
    }

    //Select Reactivation Option in Account Maintenance
    public void selectReactivationRadioButton() {

        syscoLabUI.waitTillElementLoaded(lblAccountMaintenance,25);
        syscoLabUI.clickWithJavascript(rdBtnAccountMaintenance);
        syscoLabUI.waitTillElementLoaded(rdBtnReactivationRequest, 18);
        syscoLabUI.clickWithJavascript(rdBtnReactivationRequest);
    }

    public void requestToInactivateAccount() {
        syscoLabUI.waitTillElementDisappear(lblAccountMaintenance);
        syscoLabUI.clickWithJavascript(rdBtnAccountMaintenance);
        syscoLabUI.waitTillElementDisappeared(rdBtnInactivationRequest, 18);
        syscoLabUI.clickWithJavascript(rdBtnInactivationRequest);
    }

    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Shipping address details of all account types
     *
     * @param
     * @return
     */
    public void collectShippingAddressInformation() {
        syscoLabUI.sleep(1);
        syscoLabUI.waitTillElementLoaded(lblShippingAddress);
        List<WebElement> shippingAddressElements = syscoLabUI.findElements(lblShippingAddress);
        shippingAddressDataList = new ArrayList<>();
        System.out.println("Size" + shippingAddressElements.size());
        for (int i = 0; i < shippingAddressElements.size(); i++) {
            shippingAddressDataList.add(syscoLabUI.getText(shippingAddressElements.get(i)));
        }
        shippingAddressDataMap = new HashMap<>();
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_STREET, shippingAddressDataList.get(0));
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_CITY, shippingAddressDataList.get(1));
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_STATE, shippingAddressDataList.get(2));
        String addressSecondLine = shippingAddressDataList.get(3);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_POSTAL_CODE, addressSecondLine.split("-")[1]);
        shippingAddressDataMap.put(StreetAccountData.CONFIRM_SHIPPING_COUNTRY, addressSecondLine.split("-")[0]);
    }

    public String getShippingAddress(String fieldName) {
        return shippingAddressDataMap.get(fieldName);
    }

    /*
     * collectBusinessInformationDataForSTREETAccounts - To collect Billing address details of all account types
     *
     * @param
     * @return
     */
    public void collectBillingAddressInformation() {
        syscoLabUI.waitTillElementLoaded(lblBillingAddress, 18);
        List<WebElement> shippingAddressElements = syscoLabUI.findElements(lblBillingAddress);
        billingAddressDataList = new ArrayList<>();
        for (int i = 0; i <= shippingAddressElements.size(); i++) {
            billingAddressDataList.add(syscoLabUI.getText(shippingAddressElements.get(i)));
        }
        billingAddressDataMap = new HashMap<>();
        billingAddressDataMap.put(StreetAccountData.CONFIRM_BILLING_STREET, billingAddressDataList.get(0));
        billingAddressDataMap.put(StreetAccountData.CONFIRM_BILLING_CITY, billingAddressDataList.get(1));
        billingAddressDataMap.put(StreetAccountData.CONFIRM_BILLING_STATE, billingAddressDataList.get(2));
        String addressSecondLine = billingAddressDataList.get(3);
        billingAddressDataMap.put(StreetAccountData.CONFIRM_BILLING_POSTAL_CODE, addressSecondLine.split("-")[1]);
        billingAddressDataMap.put(StreetAccountData.CONFIRM_BILLING_COUNTRY, addressSecondLine.split("-")[0]);
    }

    public String getBillingAddress(String fieldName) {
        return billingAddressDataMap.get(fieldName);
    }
    /*
     * Verify the SR in Account Screen
     * */

    public void selectSupportRequest() {

        syscoLabUI.waitTillElementLoaded(lnkSupportRequest);
        syscoLabUI.clickWithJavascript(lnkSupportRequest);
        LoggerUtil.logINFO("Click the Support Request");
        syscoLabUI.waitTillElementLoaded(lnkSupportRequestId, 18);
        syscoLabUI.clickWithJavascript(lnkSupportRequestId);
        LoggerUtil.logINFO("Click the Support Request ID");
    }


    //Select the CFEA Support Request
    public void selectCFEASupportRequest() {

        try {
            syscoLabUI.waitTillElementLoaded(lblDetails,10);
            syscoLabUI.scrollDown(200);
            syscoLabUI.waitTillElementLoaded(lblOpportunities,10);
            syscoLabUI.scrollToElement(lblOpportunities);
            syscoLabUI.scrollToElement(lblSupportRequest);
            syscoLabUI.waitTillElementLoaded(lblSupportRequest,10);
            syscoLabUI.clickWithJavascript(lblSupportRequest);
            LoggerUtil.logINFO("Click the Support Request");
            syscoLabUI.waitTillElementLoaded(lnkSupportRequestID, 18);
            syscoLabUI.clickWithJavascript(lnkSupportRequestID);
            LoggerUtil.logINFO("Click the Support Request ID");
        }
        catch(Exception e) {

            syscoLabUI.sleep(10);
            syscoLabUI.waitTillElementLoaded(lnkCFEASupportRequest);
            syscoLabUI.clickWithJavascript(lnkCFEASupportRequest);
            LoggerUtil.logINFO("Click the Support Request Button");
            syscoLabUI.waitTillElementLoaded(lnkSupportRequestRecord, 18);
            syscoLabUI.clickWithJavascript(lnkSupportRequestRecord);
            LoggerUtil.logINFO("Click the Support Request ID");
            pageURL = syscoLabUI.getCurrentURL();
            LoggerUtil.logINFO("SR URL is : " + pageURL);
        }
    }


    //Verify the SR Case Request Type
    public String verifyCaseRequestType() {

        syscoLabUI.waitTillElementLoaded(txtCaseRequestType,10);
        return syscoLabUI.getText(txtCaseRequestType);
    }

    /*
     * Verify the Initiate Ship To Screen Account Create/Maintain
     * */
    public String verifyInitiateShipToScreenAccountCreate() {
        syscoLabUI.waitTillElementDisappear(txtCreateMaintain);
        return syscoLabUI.getText(txtCreateMaintain);
    }

    /*
     * Verify the Initiate Ship To Screen Status
     * */
    public String verifyInitiateShipToScreenStatus() {
        syscoLabUI.waitTillElementLoaded(txtStatus);
        return syscoLabUI.getText(txtStatus);
    }

    /*
     * Verify the Initiate Ship To Screen Credit Application Status
     * */
    public String verifyInitiateShipToScreenCreditApplicationStatus() {
        syscoLabUI.waitTillElementDisappear(txtCreditApplicationStatus);
        return syscoLabUI.getText(txtCreditApplicationStatus);

    }

    /*
     * Verify the Initiate Ship To Screen Related Contacts
     * */
    public void viewRelatedContacts(String accountName) {
        syscoLabUI.waitTillElementLoaded(DriverSetUpUtil.replaceInLocator(txtAccountName, "#", accountName));
        syscoLabUI.click(lnkScrollBar);
        syscoLabUI.scrollToElement(txtRelatedLinks);
        syscoLabUI.clickWithJavascript(lnkViewAllContacts);


    }

    /*
     * Verify the Initiate Ship To Screen Email Credit Application CheckBox
     * */
    public boolean isEmailCreditApplicationCheckboxChecked() {
        return syscoLabUI.isSelected(chkEmailCreditApplication);
    }

    /*
     * Verify the Initiate Ship To Screen Account Role
     * */
    public String verifyInitiateShipToScreenAccountRole() {
        syscoLabUI.waitTillElementDisappear(txtAccountRole);
        return syscoLabUI.getText(txtAccountRole);

    }

    /*
     * Verify the Initiate Ship To Screen Application Request Type
     * */
    public String verifyInitiateShipToApplicationRequestType() {
        syscoLabUI.waitTillElementDisappear(txtApplicationRequestType);
        return syscoLabUI.getText(txtApplicationRequestType);
    }
}