package tests;

import core.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTests {
protected AppiumDriver driver;
@BeforeClass
    public void setUp() throws MalformedURLException {
    driver= DriverManager.initializeDriver("ios");
    Assert.assertNotNull(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));


}


//@AfterClass
//    public void treatdown()
//{
//    if (driver != null) {
//        driver.quit();
//    }
//}
}
