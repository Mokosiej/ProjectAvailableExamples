package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By header = By.tagName("h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}

