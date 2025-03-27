package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        jsExecutor.executeScript("window.location = '" + url + "';");
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", waitForElement(element));
    }

    public String getTitle() {
        return (String) jsExecutor.executeScript("return document.title;");
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(waitForElement(frameElement));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getText(WebElement element) {
        return (String) jsExecutor.executeScript("return arguments[0].innerText;", waitForElement(element));
    }

    public void switchToNewWindow(String originalWindowHandle) {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(originalWindowHandle);
        String newWindowHandle = windowHandles.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

    public void selectDropdownOption(WebElement dropdown, String optionText) {
        Select select = new Select(waitForElement(dropdown));
        select.selectByVisibleText(optionText);
    }

    public String getSelectedDropdownOption(WebElement dropdown) {
        Select select = new Select(waitForElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    public int getHttpStatusCode(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            return -1; // Ошибка подключения
        }
    }
}