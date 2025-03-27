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

    public int getBrokenImagesCount() {
        int brokenCount = 0;
        for (WebElement image : images) {
            if (isImageBroken(image)) {
                brokenCount++;
                System.out.println("Сломанное изображение: " + image.getAttribute("src"));
            }
        }
        return brokenCount;
    }
}