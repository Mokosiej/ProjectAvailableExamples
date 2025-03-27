package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusCodesPage extends BasePage {

    @FindBy(css = ".example li a")
    private List<WebElement> statusCodeLinks;

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, Integer> getStatusCodes() {
        Map<String, Integer> statusCodes = new HashMap<>();
        for (WebElement link : statusCodeLinks) {
            String codeText = link.getText(); // Например, "200"
            String href = link.getAttribute("href");
            int statusCode = getHttpStatusCode(href);
            statusCodes.put(codeText, statusCode);
            System.out.println("Ссылка " + href + " вернула статус: " + statusCode);
        }
        return statusCodes;
    }
}
