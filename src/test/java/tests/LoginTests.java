package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AuthPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTests extends BaseTests{

    private AuthPage auth;
    @BeforeSuite
    public void beforesuite()
    {
        System.out.printf("Before test Suite");
    }

    @BeforeClass
    public void init()
    {
        auth=new AuthPage(driver);
    }


    @Parameters({"platformName"})
    @Test
    public void signin(String plat)
    {
        auth.pressloginFromHomeScreen();
        auth.signIn("ranatest@gmail.com","Aa@12345");
        boolean alertShown = auth.isSuccessAlertDisplayed();
        System.out.println("Success alert displayed: " + alertShown);
        soft.assertTrue(alertShown, "Success alert should be displayed after login");
        soft.assertAll();
        System.out.println(plat);

    }
}
