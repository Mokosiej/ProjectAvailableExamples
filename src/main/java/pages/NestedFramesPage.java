package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    WebElement topFrame;

    @FindBy(name = "frame-left")
    WebElement leftFrame;

    @FindBy(name = "frame-middle")
    WebElement middleFrame;

    @FindBy(name = "frame-right")
    WebElement rightFrame;

    @FindBy(name = "frame-bottom")
    WebElement bottomFrame;

    @FindBy(tagName = "body")
    WebElement body;

    public String getLeftFrameText() {
        switchToFrame(topFrame);
        switchToFrame(leftFrame);
        String text = getText(body);
        switchToDefaultContent();
        return text;
    }

    public String getMiddleFrameText() {
        switchToFrame(topFrame);
        switchToFrame(middleFrame);
        String text = getText(body);
        switchToDefaultContent();
        return text;
    }

    public String getRightFrameText() {
        switchToFrame(topFrame);
        switchToFrame(rightFrame);
        String text = getText(body);
        switchToDefaultContent();
        return text;
    }

    public String getBottomFrameText() {
        switchToFrame(bottomFrame);
        String text = getText(body);
        switchToDefaultContent();
        return text;
    }

}