package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JsAlertsPage extends BasePage {

    public JsAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

    @FindBy(id = "result")
    private WebElement resultText;


    public void clickJsAlertButton() {
        click(jsAlertButton);

    }
        public void clickJsConfirmButton () {
            click(jsConfirmButton);
        }

        public void clickJsPromptButton () {
            click(jsPromptButton);
        }

    public void enterPromptText(String text) {
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(text);
        acceptAlert();
    }


        public String getResultText () {
            wait.until(d -> !getText(resultText).isEmpty());
            return getText(resultText);
        }

    public void dismissPrompt() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
}
