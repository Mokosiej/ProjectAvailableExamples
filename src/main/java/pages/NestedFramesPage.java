package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    private WebElement topFrame;

    @FindBy(name = "frame-left")
    private WebElement leftFrame;

    @FindBy(name = "frame-middle")
    private WebElement middleFrame;

    @FindBy(name = "frame-right")
    private WebElement rightFrame;

    @FindBy(name = "frame-bottom")
    private WebElement bottomFrame;

    @FindBy(tagName = "body")
    private WebElement body;



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