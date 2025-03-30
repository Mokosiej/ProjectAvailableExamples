package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLink;

    public void goToFileUpload() {
        click(fileUploadLink);
    }

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;

    public void goToFormAuthentication() {
        click(formAuthenticationLink);
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

    @FindBy(linkText = "Multiple Windows")
    private WebElement multipleWindowsLink;

    public void goToMultipleWindows() {
        click(multipleWindowsLink);
    }

    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;

    public void goToDropdown() {
        click(dropdownLink);
    }

    @FindBy(linkText = "Broken Images") // Новая ссылка
    private WebElement brokenImagesLink;

    public void goToBrokenImages() {
        click(brokenImagesLink);
    }

    @FindBy(linkText = "Status Codes") // Новая ссылка
    private WebElement statusCodesLink;

    public void goToStatusCodes() {
        click(statusCodesLink);
    }
}