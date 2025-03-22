package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePage {

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    public void clickToOpenNewWindow() {
        click(clickHereLink);
    }

    @FindBy(tagName = "h3")
    private WebElement headerText;

    public String getNewWindowText(String originalWindowHandle) {
        switchToNewWindow(originalWindowHandle);
        return getText(headerText);
    }
}