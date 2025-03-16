package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {

    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(id = "tinymce")
    private WebElement textArea;



    public void switchToIframe() {
        switchToFrame(iframe);
        wait.until(d -> !getText(textArea).isEmpty());
    }

    public String getIframeText() {
        return getText(textArea);
    }
}