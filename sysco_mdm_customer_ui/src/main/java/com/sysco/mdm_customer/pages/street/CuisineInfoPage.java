package com.sysco.mdm_customer.pages.street;

import com.sysco.mdm_customer.pages.LoginPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sysco.mdm_customer.pages.GUIPageBase.syscoLabUI;


public class CuisineInfoPage extends LoginPage {
    private final By drpDwnCuisineType = By.xpath("//*[text()='Type of Cuisine']//following::select[1]");
    private final By drpDwnOperationType = By.xpath("//*[text()='Type of Operation']//following::select[1]");
    private final By drpDwnLocalOperationType = By.xpath("//*[text()='Local Type of Operation']//following::select[1]");

    /*
     * Enter Cuisine Info Screen Data
     * */
    public void setCuisineInfo(String strCuisine, String strOperation, String strLocalOperationType) {
        syscoLabUI.waitTillElementLoaded(drpDwnCuisineType);
        syscoLabUI.selectFromDropDown(drpDwnOperationType, strOperation);
        new WebDriverWait(SyscoLabUI.driver, 10).until(ExpectedConditions.presenceOfElementLocated(drpDwnLocalOperationType));
        syscoLabUI.selectFromDropDown(drpDwnLocalOperationType, strLocalOperationType);
        syscoLabUI.selectFromDropDown(drpDwnCuisineType, strCuisine);

    }
    /*
     * Assert Street Account CCA Flow Cuisine Info Screen
     * */
    public boolean isCuisineInfoFieldDisplayed() {
        return isElementDisplayed(drpDwnCuisineType) && isElementDisplayed(drpDwnOperationType) && isElementDisplayed(drpDwnLocalOperationType);
    }
    public boolean isElementDisplayed(By element) {
        return syscoLabUI.waitTillElementLoaded(element).isDisplayed();
    }
}