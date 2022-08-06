package com.sysco.mdm_customer.pages.cadd;

import com.sysco.mdm_customer.utils.DriverSetUpUtil;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;

public class CADDShipToAccountPage {

    String pageURL;
    String billToPageURL;

    protected By lblAccountName = By.xpath("//span[normalize-space()='Account ID']");
    protected By lblCustomLinks = By.xpath("(//button[@title='Edit Bill-to Account'])[1]");
    protected By lblBillToAccountName = By.xpath("//span[text()='Bill-to Account']//ancestor::div[contains(@class,'slds-hint-parent test-id')]//a");
    protected By lblBillToSecondaryAccountName = By.xpath("(//span[normalize-space()='#'])[1]");
    protected By lblShipToPage = By.xpath("(//span[@class='test-id__field-label'])[2]");
    protected By lblLead = By.xpath("//div[text()='Lead']");
    protected By lblDetails = By.xpath("//a[@data-label='Details']");


    //Get the Current URL of the Ship To
    public void getCurrentURL() {

        syscoLabUI.waitTillElementLoaded(lblDetails, 45);
        pageURL = syscoLabUI.getCurrentURL();
        LoggerUtil.logINFO("Ship to URL is : " + pageURL);
    }


    //Get the Current URL of the Ship To
    public void getFreshPointCurrentURL() {

        syscoLabUI.waitTillElementLoaded(lblDetails, 10);
        syscoLabUI.clickWithJavascript(lblDetails);
        syscoLabUI.waitTillElementLoaded(lblShipToPage, 45);
        pageURL = syscoLabUI.getCurrentURL();
        LoggerUtil.logINFO("Ship to URL is : " + pageURL);
    }


    //Get SSAID of the Ship to Address
    public String getSSAID() {

        List<String> b = Arrays.asList(pageURL.split("/"));
        return b.stream().filter(s -> s.matches("\\d.*")).collect(Collectors.joining());
    }


    //Get SSAID of the Bill to Address
    public String getSSAIDBillTo() {


        billToPageURL = syscoLabUI.getCurrentURL();
        LoggerUtil.logINFO("Bill to URL is : " + billToPageURL);
        return billToPageURL.substring(63, 81);
    }


    //Click the Bill to
    public void openBillTo() {

        syscoLabUI.waitTillElementLoaded(lblCustomLinks,15);
        syscoLabUI.scrollToElement(lblCustomLinks);
        syscoLabUI.scrollDown(550);
        syscoLabUI.clickWithJavascript(lblBillToAccountName);
        syscoLabUI.sleep(3);
    }


    //Click the Secondary Bill to
    public void openSecondaryBillTo(String secondaryBillTo) {

        syscoLabUI.scrollToElement(lblCustomLinks);
        syscoLabUI.scrollDown(550);
        syscoLabUI.click(DriverSetUpUtil.replaceInLocator(lblBillToSecondaryAccountName, "#", secondaryBillTo));
        syscoLabUI.sleep(3);
    }


    //Navigate to the Previous Page
    public void navigateBack() {

        syscoLabUI.navigateBack();
    }

}
