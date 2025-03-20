package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MultipleWindowsPage extends BasePage {
    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    @FindBy(tagName = "h3")
    private WebElement headerText;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void openMultipleWindowsPage() {
        open("https://the-internet.herokuapp.com/windows");
    }

    public void clickToOpenNewWindow() {
        click(clickHereLink);
    }

    public String getNewWindowText() {
        String originalWindow = driver.getWindowHandle();
        switchToNewWindow(originalWindow);
        String text = getText(headerText);
        driver.close(); // Закрываем новое окно
        driver.switchTo().window(originalWindow); // Возвращаемся в исходное окно
        return text;
    }
}
