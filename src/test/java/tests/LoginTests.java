package tests;

import models.LoginData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthPage;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;

public class LoginTests extends BaseTests {

    private AuthPage auth;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before test Suite");
    }

    @BeforeClass
    public void init() {
        auth = new AuthPage(driver);
    }

    // @DataProvider بيقرأ البيانات من الـ JSON ويرجعها للـ test
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {
        List<LoginData> dataList = JsonUtils.getLoginData();

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }

    // الـ test بيتشغل تلقائياً لكل record في الـ JSON
    @Test(dataProvider = "loginData")
    public void signin(LoginData loginData) {
        auth.pressloginFromHomeScreen();
        auth.signIn(loginData.getEmail(), loginData.getPassword());

        boolean alertShown = auth.isSuccessAlertDisplayed();
        System.out.println("Email: " + loginData.getEmail());
        System.out.println("Expected: " + loginData.getExpectedResult());
        System.out.println("Success alert displayed: " + alertShown);

        if (loginData.getExpectedResult().equals("success")) {
            soft.assertTrue(alertShown, "Success alert should be displayed for valid credentials");
        } else {
            soft.assertFalse(alertShown, "Success alert should NOT be displayed for invalid credentials");
        }
        soft.assertAll();
    }
}
