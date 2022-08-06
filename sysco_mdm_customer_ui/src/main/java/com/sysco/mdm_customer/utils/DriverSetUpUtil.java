package com.sysco.mdm_customer.utils;

import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 3/8/18.
 */
public class DriverSetUpUtil {

    DriverSetUpUtil() {
    }

    //Required driver
    public static void setToRunLocally() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/windows/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/" + System.getProperty("os.arch") + "/chromedriver");
        }
    }


    public static Capabilities setToRunRemotely(String browser) {
        DesiredCapabilities capabilities;
        System.setProperty("hub.url", "http://10.1.19.213:4444/wd/hub");
        capabilities = SyscoLabCapabilityUtil.getPCCapabilities("WIN10", "Chrome");
        if (BrowserType.CHROME.equalsIgnoreCase(browser)) {
            capabilities.setBrowserName(BrowserType.CHROME);
        } else if (BrowserType.FIREFOX.equalsIgnoreCase(browser)) {
            capabilities.setBrowserName(BrowserType.FIREFOX);
        }
        return capabilities;
    }

    public static By replaceInLocator(By byLocator, String strReplaceString, String strNewString) {
        return (By.xpath(byLocator.toString().replace("By.xpath:", "").replaceAll(strReplaceString, strNewString)));
    }

    public static By replaceInLocator(By byLocator, String strReplaceString, int strNewInteger) {
        return By.xpath(byLocator.toString().replace("By.xpath:", "").replaceAll(strReplaceString, String.valueOf(strNewInteger)));
    }
}
