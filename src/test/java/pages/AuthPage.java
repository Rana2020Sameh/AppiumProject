package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage extends BasePage{

    public AuthPage(AppiumDriver driver)
    {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "button-LOGIN")
    private WebElement confirmLogin;

    @iOSXCUITFindBy(accessibility = "Sign up")
    private WebElement signUpButton;

    @iOSXCUITFindBy(accessibility = "button-SIGN UP")
    private WebElement confirmSignUpButton;

    @iOSXCUITFindBy(accessibility = "input-email")
    private WebElement emailfiled;

    @iOSXCUITFindBy(accessibility = "input-password")
    private WebElement passwordfiled;

    @iOSXCUITFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordfiled;

    private final By signedUpAlertLocator = By.xpath("//XCUIElementTypeAlert[@name=\"Signed Up!\"]");
    private final By successAlertLocator = By.xpath("//XCUIElementTypeAlert[@name=\"Success\"]");

    public boolean isSignedUpAlertDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(signedUpAlertLocator));
            return alert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSuccessAlertDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertLocator));
            return alert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void pressloginFromHomeScreen() {
        loginButton.click();
    }
public void signIn(String email,String pass)
{
    emailfiled.clear();
    emailfiled.sendKeys(email);
    passwordfiled.clear();
    passwordfiled.sendKeys(pass);
    confirmLogin.click();

}
    public void signUp(String email, String pass, String confirmPass) {
        signUpButton.click();
        emailfiled.sendKeys(email);
        passwordfiled.sendKeys(pass);
        confirmPasswordfiled.sendKeys(confirmPass);
        confirmSignUpButton.click();
    }
}
