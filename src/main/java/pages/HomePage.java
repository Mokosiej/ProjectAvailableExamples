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

    @FindBy(linkText = "WYSIWYG Editor")
    private WebElement iframeLink;

    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesLink;

    public void goToJsAlerts() {
        click(jsAlertsLink);
    }

    public void goToIframe() {
        click(iframeLink);
    }

    public void goToNestedFrames() {
        click(nestedFramesLink);
    }
}




