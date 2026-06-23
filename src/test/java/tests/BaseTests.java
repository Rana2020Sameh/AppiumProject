package tests;

import core.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTests {

    protected AppiumDriver driver;
    protected SoftAssert soft = new SoftAssert();
    protected WebDriverWait wait;
    protected Wait<AppiumDriver> waitFluent;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = DriverManager.initializeDriver("ios");
        Assert.assertNotNull(driver, "Driver failed to initialize");
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        waitFluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeMethod
    public void resetSoftAssert() {
        soft = new SoftAssert();
    }

    @BeforeTest
    public void beforeEachTest() {
        System.out.println("Before each test - ensure device is ready");
    }
}
