package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    private WebElement dropdown;



    public void selectOption(String optionText) {
        selectDropdownOption(dropdown, optionText);
    }

    public String getSelectedOption() {
        return getSelectedDropdownOption(dropdown);
    }
}