package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
public class SidemenuPage extends BasePage{
    public SidemenuPage(AppiumDriver driver)
    {
        super(driver);
    }

    @iOSXCUITFindBy (accessibility = "Menu")
    private WebElement sidemenuButton;
    @iOSXCUITFindBy (accessibility = "side-menu-item-home")
    private WebElement home;
    @iOSXCUITFindBy (accessibility = "side-menu-item-webview")
    private WebElement webView;
    @iOSXCUITFindBy (accessibility = "side-menu-item-forms")
    private WebElement forms;
    @iOSXCUITFindBy (accessibility = "side-menu-item-swipe")
    private WebElement swipe;

    @iOSXCUITFindBy (accessibility = "side-menu-item-drag")
    private WebElement drag;

    @iOSXCUITFindBy (accessibility = "side-menu-item-permissions")
    private WebElement permissions;
    @iOSXCUITFindBy (xpath = "    //XCUIElementTypeOther[@name=\"tab-side-menu-panel\"]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[20]\n")
    private WebElement data;


@iOSXCUITFindBy (accessibility = "side-menu-star-data-management")
    private WebElement staricon;
@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"WEBDRIVER\"])[2]")
private WebElement textinHome;
public void pressHomeScreen() {
    sidemenuButton.click();
    home.click();
    String nam = textinHome.getText();
    System.out.printf("you are in Home: %s%n", nam);
}

public void navigateToForms() {
    sidemenuButton.click();
    forms.click();
}

public void navigateToSwipe() {
    sidemenuButton.click();
    swipe.click();
}

public void navigateToWebView() {
    sidemenuButton.click();
    webView.click();
}

public void navigateToDrag() {
    sidemenuButton.click();
    drag.click();
}
}
