package tests;

import core.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTests {
protected AppiumDriver driver;
    SoftAssert soft=new SoftAssert();
@BeforeClass
    public void setUp() throws MalformedURLException {
    driver= DriverManager.initializeDriver("ios");
    Assert.assertNotNull(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));



}

@BeforeTest
        public  void beforeeachTest()
{
System.out.println("beforeeachclassTest turn on your mobile");
}
/*    @AfterTest
    public  void aftereachTest()
    {
        System.out.println("beforeeachclassTest turn off your mobile");
    }*/
//@AfterClass
//    public void treatdown()
//{
//    if (driver != null) {
//        driver.quit();
//    }
//}
}
