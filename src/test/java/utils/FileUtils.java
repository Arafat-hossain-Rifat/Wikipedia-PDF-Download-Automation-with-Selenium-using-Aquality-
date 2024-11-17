package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.io.File;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class FileUtils {

    private static final int WAIT_TIME_IN_SECONDS = SettingsTestData.getEnvironmentConfig().getWaitTimeInSeconds();

    public boolean isFileExist(File file) {
        try {
            Awaitility.await().atMost(WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            AqualityServices.getLogger().error(String.format("File %s does not exist. Exception: %s", file.getAbsolutePath(), exception.getMessage()));
            return false;
        }
        return true;
    }
}
