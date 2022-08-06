package com.sysco.mdm_customer.functions;

import com.sysco.mdm_customer.common.GUIConstants;
import com.sysco.mdm_customer.pages.GUIPageBase;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import static com.sysco.mdm_customer.common.GUIConstants.APP_BROWSER;


public class GUIFunctionBase {
    GUIFunctionBase() {
    }

    public static void openBrowser() {

        DesiredCapabilities desiredCapabilities = getDownloadCapabilitiesForBrowserType(APP_BROWSER);
        GUIPageBase.loadLoginPage(GUIConstants.APP_URL, desiredCapabilities);
        LoggerUtil.logINFO("Opening Browser");
    }


    public static DesiredCapabilities getDownloadCapabilitiesForBrowserType(String browserType) {

        DesiredCapabilities desiredCapabilities;
        if (browserType.equalsIgnoreCase("IE")) {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
        } else if (browserType.equalsIgnoreCase("FIREFOX")) {
            desiredCapabilities = DesiredCapabilities.firefox();
        } else if (browserType.equalsIgnoreCase("CHROME")) {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--start-maximized");
            desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            return desiredCapabilities;
        } else if (browserType.equalsIgnoreCase("EDGE")) {
            desiredCapabilities = DesiredCapabilities.edge();
        } else {
            desiredCapabilities = new DesiredCapabilities();
        }
        return desiredCapabilities;
    }

    public static void closeBrowser() {

        GUIPageBase.quitDriver();
    }
}
