package com.sysco.mdm_customer.api.util;

import com.sysco.mdm_customer.api.common.Constant;
import com.sysco.mdm_customer.functions.Home;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(SyscoLabListener.class)
public class TestBase {

    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
        System.out.println("Running " + this.getClass().toString());
    }

    @AfterMethod(alwaysRun = true)
    public void updateQCenter(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constant.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constant.TEST_ENV);
            syscoLabQCenter.setRelease(Constant.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());
            if (Constant.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(testListeners.getResults(), syscoLabQCenter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
