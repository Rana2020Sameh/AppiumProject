package tests;

import core.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    // Single shared driver for the entire suite — WDA builds only once.
    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    protected static Wait<AppiumDriver> waitFluent;
    protected SoftAssert soft = new SoftAssert();

    static final String APP_BUNDLE_ID = "org.reactjs.native.example.wdioDemoApp";

    /**
     * Creates the Appium session once for the entire suite.
     * WDA is built and started only here — no repeated startups between classes.
     */
    @BeforeSuite
    public synchronized void setUpSuite() throws MalformedURLException {
        if (driver == null) {
            driver = DriverManager.initializeDriver("ios");
            Assert.assertNotNull(driver, "Driver failed to initialize");
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            waitFluent = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
        }
    }

    /**
     * Resets the app to its initial state before each test class.
     * Much faster than a new Appium session — just terminates and relaunches the app.
     */
    @BeforeClass
    public void setUp() {
        resetApp();
    }

    /**
     * Quits the driver once at the end of the entire suite.
     */
    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeMethod
    public void resetSoftAssert() {
        soft = new SoftAssert();
    }

    protected void resetApp() {
        try {
            Map<String, Object> args = new HashMap<>();
            args.put("bundleId", APP_BUNDLE_ID);
            driver.executeScript("mobile: terminateApp", args);
            Thread.sleep(1000);
            driver.executeScript("mobile: launchApp", args);
            Thread.sleep(2000); // wait for app to fully load
        } catch (Exception e) {
            System.out.println("Warning: could not reset app state: " + e.getMessage());
        }
    }
}
