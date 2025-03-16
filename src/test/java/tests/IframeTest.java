package tests;

import pages.HomePage;
import pages.IframePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IframeTest extends TestBase {
    private HomePage homePage;
    private IframePage iframePage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        iframePage = new IframePage(driver);
        homePage.goToIframe();
    }

    @Test
    @DisplayName("Проверка текста внутри iframe на странице")
    public void testIframe() {
        iframePage.switchToIframe();
        String iframeText = iframePage.getIframeText();
        assertEquals("Your content goes here.", iframeText, "Текст внутри iframe неверный");
    }
}