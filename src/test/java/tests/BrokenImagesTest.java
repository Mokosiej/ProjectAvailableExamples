package tests;

import pages.BrokenImagesPage;
import pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenImagesTest extends TestBase {
    private HomePage homePage;
    private BrokenImagesPage brokenImagesPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        brokenImagesPage = new BrokenImagesPage(driver);
        homePage.goToBrokenImages();
    }

    @Test
    @DisplayName("Check for broken images on the Broken Images page")
    public void testBrokenImages() {
        List<WebElement> images = brokenImagesPage.getImages();
        int brokenCount = 0;
        for (WebElement image : images) {
            if (brokenImagesPage.isImageBroken(image)) {
                brokenCount++;
                System.out.println("Сломанное изображение: " + image.getAttribute("src"));
            }
        }

        assertEquals(2, brokenCount, "Ожидалось 2 сломанных изображения, найдено: " + brokenCount);
    }
}
