package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.Env;
import models.EnvironmentConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    public final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String ENV_FILE_PATH = "src/test/resources/env.json";
    private final Gson GSON = new Gson();

    public EnvironmentConfig getEnvironmentConfig() {
        String envConfigPath = ENVIRONMENT_PATH + getCurrentEnvironment() + ".json";
        return deserializeJson(envConfigPath, EnvironmentConfig.class);
    }

    private String getCurrentEnvironment() {
        Env env = deserializeJson(ENV_FILE_PATH, Env.class);
        return env.getEnv();
    }

    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(String.format("Settings file %s not found or incorrect. Error msg: %s", filePath, e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}
