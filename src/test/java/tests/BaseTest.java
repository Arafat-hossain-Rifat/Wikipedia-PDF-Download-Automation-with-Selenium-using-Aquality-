package tests;

import aquality.selenium.browser.AqualityServices;
import models.EnvironmentConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.SettingsTestData;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        EnvironmentConfig config = SettingsTestData.getEnvironmentConfig();
        AqualityServices.getBrowser().goTo(config.getHost());
        AqualityServices.getBrowser().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

}
