package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthPage;

public class RegistrationTests extends BaseTests{
    private AuthPage auth;

    @BeforeClass
    public void init()
    {
        auth=new AuthPage(driver);
    }

    @Test
    public void signUp()
    {
        auth.pressloginFromHomeScreen();
        auth.signUp("ranatestww8@gmail.com","Aa@12345","Aa@12345");
        boolean alertShown = auth.isSignedUpAlertDisplayed();
        System.out.println("Signed Up alert displayed: " + alertShown);
        Assert.assertTrue(alertShown, "Signed Up alert should be displayed");
    }

}
