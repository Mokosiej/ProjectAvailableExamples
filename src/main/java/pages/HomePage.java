package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "JavaScript Alerts")
    private WebElement jsAlertsLink;

    public void goToJsAlerts() {
        click(jsAlertsLink);
    }


    @FindBy(linkText = "WYSIWYG Editor")
    private WebElement iframeLink;

    public void goToIframe() {
        click(iframeLink);
    }


    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesLink;

    public void goToNestedFrames() {
        click(nestedFramesLink);
    }


    @FindBy(linkText = "Multiple Windows") // Новая ссылка
    private WebElement multipleWindowsLink;

    public void goToMultipleWindows() {
        click(multipleWindowsLink);
    }


    @FindBy(linkText = "Dropdown") // Новая ссылка
    private WebElement dropdownLink;

    public void goToDropdown() {
        click(dropdownLink);
    }

}




