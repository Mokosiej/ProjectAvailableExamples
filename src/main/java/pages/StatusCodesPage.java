package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusCodesPage extends BasePage {
    @FindBy(css = ".example ul li a")
    private List<WebElement> statusCodeLinks;

    @FindBy(css = ".example p")
    private WebElement descriptionText;

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    public void openStatusCodesPage() {
        open("https://the-internet.herokuapp.com/status_codes");
    }

    public Map<String, String> getStatusCodeLinks() {
        Map<String, String> links = new HashMap<>();
        for (WebElement link : statusCodeLinks) {
            String code = link.getText();
            String href = link.getAttribute("href");
            links.put(code, href);
        }
        return links;
    }

    public String getDescriptionText() {
        return getText(descriptionText);
    }
}
