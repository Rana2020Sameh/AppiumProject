package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.SidemenuPage;

public class FormsTests extends BaseTests {

    private SidemenuPage sidemenuPage;
    private FormsPage formsPage;

    @BeforeClass
    public void init() {
        sidemenuPage = new SidemenuPage(driver);
        formsPage = new FormsPage(driver);
        sidemenuPage.navigateToForms();
    }

    @Test
    public void validateTextInputReflectsTypedText() {
        String testText = "Hello Appium";
        formsPage.typeInInputField(testText);
        String result = formsPage.getInputResultText();
        System.out.println("Typed: " + testText + " | Result shown: " + result);
        soft.assertEquals(result, testText, "Input result should match typed text");
        soft.assertAll();
    }

    @Test
    public void validateToggleSwitchBecomesActive() {
        formsPage.tapToggleSwitch();
        boolean active = formsPage.isActiveLabelDisplayed();
        System.out.println("Toggle active label displayed: " + active);
        soft.assertTrue(active, "Active label should appear after tapping toggle");
        soft.assertAll();
    }

    @Test
    public void validateToggleSwitchBecomesInactive() {
        // Tap twice: first ON, then OFF
        formsPage.tapToggleSwitch();
        formsPage.tapToggleSwitch();
        boolean inactive = formsPage.isInactiveLabelDisplayed();
        System.out.println("Toggle inactive label displayed: " + inactive);
        soft.assertTrue(inactive, "Inactive label should appear after toggling off");
        soft.assertAll();
    }

    @Test
    public void validateDropdownSelectionAppium() {
        formsPage.selectDropdownOption("Appium");
        String selected = formsPage.getSelectedDropdownOption();
        System.out.println("Selected dropdown option: " + selected);
        soft.assertEquals(selected, "Appium", "Dropdown should show 'Appium' after selection");
        soft.assertAll();
    }

    @Test
    public void validateDropdownSelectionCucumber() {
        formsPage.selectDropdownOption("Cucumber");
        String selected = formsPage.getSelectedDropdownOption();
        System.out.println("Selected dropdown option: " + selected);
        soft.assertEquals(selected, "Cucumber", "Dropdown should show 'Cucumber' after selection");
        soft.assertAll();
    }
}
