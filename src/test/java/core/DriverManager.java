package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class DriverManager {
    private static Properties pro;

    static {
        pro = new Properties();
        try (InputStream input = DriverManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            pro.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    /**
     * Returns the value of an environment variable if set and non-empty,
     * otherwise falls back to the matching key in config.properties.
     * This lets CI override local settings without touching source files.
     */
    private static String getConfig(String envKey, String propKey) {
        String envVal = System.getenv(envKey);
        return (envVal != null && !envVal.trim().isEmpty()) ? envVal : pro.getProperty(propKey);
    }

    public static AppiumDriver initializeDriver(String platform) throws MalformedURLException {

        if (platform.equalsIgnoreCase("ios")) {
            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName("iOS");
            options.setAutomationName("XCUITest");
            options.setDeviceName(getConfig("DEVICE_NAME",  "iosDeviceName"));
            options.setUdid(getConfig("SIMULATOR_UDID",    "iosUdid"));
            options.setApp(getConfig("APP_PATH",           "iosApp"));
            options.setNewCommandTimeout(Duration.ofSeconds(3600));
            // No fullReset: the CI "Boot iOS Simulator" step already provides a
            // clean simulator. fullReset shuts it down and restarts it, causing
            // a 135s+ boot timeout. App state is reset between classes via
            // mobile: terminateApp / mobile: launchApp in BaseTests.resetApp().

            return new IOSDriver(
                    new URL(getConfig("APPIUM_URL", "appiumUrl")),
                    options
            );
        }

        return null;
    }
}


