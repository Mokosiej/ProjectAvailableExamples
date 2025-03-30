package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthenticationPage extends BasePage {

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement flashMessage;



    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        click(loginButton);
    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }
}
