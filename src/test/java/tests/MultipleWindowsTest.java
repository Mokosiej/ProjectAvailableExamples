package tests;

import pages.HomePage;
import pages.MultipleWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleWindowsTest extends TestBase {
    private HomePage homePage;
    private MultipleWindowsPage multipleWindowsPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        multipleWindowsPage = new MultipleWindowsPage(driver);
        homePage.goToMultipleWindows();
    }

    @Test
    @DisplayName("Проверка открытия нового окна и текста в нем")
    public void testNewWindow() {
        String originalWindowHandle = driver.getWindowHandle();
        multipleWindowsPage.clickToOpenNewWindow();
        String newWindowText = multipleWindowsPage.getNewWindowText(originalWindowHandle);
        assertEquals("New Window", newWindowText, "Текст в новом окне неверный");
    }
}