package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    @FindBy(css = ".example img")
    private List<WebElement> images;

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public void openBrokenImagesPage() {
        open("https://the-internet.herokuapp.com/broken_images");
    }

    public List<WebElement> getImages() {
        return images;
    }

    public boolean isImageBroken(WebElement image) {
        String src = image.getAttribute("src");
        int statusCode = getHttpStatusCode(src);
        // Изображение считается сломанным, если статус ≠ 200 или размеры нулевые
        String naturalWidth = image.getAttribute("naturalWidth");
        return statusCode != 200 || (naturalWidth != null && naturalWidth.equals("0"));
    }
}