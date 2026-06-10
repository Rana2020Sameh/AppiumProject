package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.SidemenuPage;

public class NavigationTests extends BaseTests{

    private SidemenuPage sidemenuPage;
    @BeforeClass
    public void init()
    {
        sidemenuPage=new SidemenuPage(driver);
    }

    @Test
    public void validateHomePageNAvigation()
    {
        sidemenuPage.pressHomeScreen();

    }
}
