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

    public static AppiumDriver initializeDriver(String platform) throws MalformedURLException {

        if (platform.equalsIgnoreCase("ios")) {
            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName("iOS");
            options.setAutomationName("XCUITest");
            options.setDeviceName(pro.getProperty("iosDeviceName"));
            options.setUdid(pro.getProperty("iosUdid"));               // simulator UDID
            options.setApp((pro.getProperty("iosApp")));
            options.setNewCommandTimeout(Duration.ofSeconds(3600));
            options.setFullReset(true);

            return new IOSDriver(
                    new URL(pro.getProperty("appiumUrl")),
                    options
            );
        }


        return null;
    }
}


