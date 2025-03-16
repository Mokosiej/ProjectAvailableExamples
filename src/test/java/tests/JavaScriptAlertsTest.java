package tests;

import pages.HomePage;
import pages.JsAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertsTest extends TestBase {
    private HomePage homePage;
    private JsAlertsPage jsAlertsPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        jsAlertsPage = new JsAlertsPage(driver);
        homePage.goToJsAlerts();
    }

    @Test
    public void testJsAlertButton() {
        jsAlertsPage.clickJsAlertButton();
        String alertText = jsAlertsPage.getAlertText();
        jsAlertsPage.acceptAlert();
        assertEquals("I am a JS Alert", alertText, "Текст алерта неверный");
        assertEquals("You successfully clicked an alert", jsAlertsPage.getResultText(), "Результат после алерта неверный");
    }

    @Test
    public void testJsConfirmButton() {
        jsAlertsPage.clickJsConfirmButton();
        String alertText = jsAlertsPage.getAlertText();
        jsAlertsPage.acceptAlert();
        assertEquals("I am a JS Confirm", alertText, "Текст confirm неверный");
        assertEquals("You clicked: Ok", jsAlertsPage.getResultText(), "Результат после confirm неверный");
    }


    @Test
    public void testJsPromptButton() {
        jsAlertsPage.clickJsPromptButton();
        String alertText = jsAlertsPage.getAlertText();
        jsAlertsPage.dismissPrompt();
        assertEquals("I am a JS prompt", alertText, "Текст prompt неверный");
        assertEquals("You entered: null", jsAlertsPage.getResultText(), "Результат после prompt неверный");
    }
}