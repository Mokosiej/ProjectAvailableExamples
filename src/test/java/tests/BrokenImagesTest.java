package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Check for broken images")
    public void testBrokenImages() {
        int brokenCount = brokenImagesPage.getBrokenImagesCount();
        assertTrue(brokenCount > 0, "На странице нет сломанных изображений, что неожиданно");
    }
}
