package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsPage extends BasePage {

    public FormsPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "text-input")
    private WebElement inputField;

    @iOSXCUITFindBy(accessibility = "input-text-result")
    private WebElement inputResult;

    @iOSXCUITFindBy(accessibility = "switch")
    private WebElement toggleSwitch;

    @iOSXCUITFindBy(accessibility = "active")
    private WebElement activeLabel;

    @iOSXCUITFindBy(accessibility = "inactive")
    private WebElement inactiveLabel;

    @iOSXCUITFindBy(accessibility = "dropdown")
    private WebElement dropdown;

    @iOSXCUITFindBy(accessibility = "Appium")
    private WebElement dropdownOptionAppium;

    @iOSXCUITFindBy(accessibility = "Cucumber")
    private WebElement dropdownOptionCucumber;

    @iOSXCUITFindBy(accessibility = "selected-dropdown-option")
    private WebElement selectedDropdownOption;

    // --- Actions ---

    public void typeInInputField(String text) {
        inputField.clear();
        inputField.sendKeys(text);
    }

    public String getInputResultText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inputResult));
        return inputResult.getText();
    }

    public void tapToggleSwitch() {
        toggleSwitch.click();
    }

    public boolean isActiveLabelDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(activeLabel));
            return activeLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInactiveLabelDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(inactiveLabel));
            return inactiveLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDropdownOption(String option) {
        dropdown.click();
        if (option.equalsIgnoreCase("Appium")) {
            dropdownOptionAppium.click();
        } else if (option.equalsIgnoreCase("Cucumber")) {
            dropdownOptionCucumber.click();
        }
    }

    public String getSelectedDropdownOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(selectedDropdownOption));
        return selectedDropdownOption.getText();
    }
}
