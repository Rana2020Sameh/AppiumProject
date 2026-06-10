package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTests extends BaseTests{

    private AuthPage auth;

    @BeforeClass
    public void init()
    {
        auth=new AuthPage(driver);
    }
    @Test
    public void signin()
    {
        auth.pressloginFromHomeScreen();
        auth.signIn("ranatest@gmail.com","Aa@12345");
        boolean alertShown = auth.isSuccessAlertDisplayed();
        System.out.println("Success alert displayed: " + alertShown);
        Assert.assertTrue(alertShown, "Success alert should be displayed after login");
    }
}
