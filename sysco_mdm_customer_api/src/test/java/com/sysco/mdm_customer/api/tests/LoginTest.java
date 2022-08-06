package com.sysco.mdm_customer.api.tests;

import com.sysco.mdm_customer.api.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Classic Mode - Lead Creation");
    }

    @Test(description = "ID-001", alwaysRun = true)
    public static void testLogin() {

    }

}
