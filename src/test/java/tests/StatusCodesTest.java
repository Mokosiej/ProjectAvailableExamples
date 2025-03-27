package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.StatusCodesPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusCodesTest extends TestBase {
    private HomePage homePage;
    private StatusCodesPage statusCodesPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        statusCodesPage = new StatusCodesPage(driver);
        homePage.goToStatusCodes();
    }

    @Test
    @DisplayName("Checking status code 200")
    public void testStatusCode200() {
        Map<String, Integer> statusCodes = statusCodesPage.getStatusCodes();
        assertEquals(200, statusCodes.get("200"), "Статус-код 200 неверный");
    }

    @Test
    @DisplayName("Checking status code 301")
    public void testStatusCode301() {
        Map<String, Integer> statusCodes = statusCodesPage.getStatusCodes();
        assertEquals(301, statusCodes.get("301"), "Статус-код 301 неверный");
    }

    @Test
    @DisplayName("Checking status code 404")
    public void testStatusCode404() {
        Map<String, Integer> statusCodes = statusCodesPage.getStatusCodes();
        assertEquals(404, statusCodes.get("404"), "Статус-код 404 неверный");
    }

    @Test
    @DisplayName("Checking status code 500")
    public void testStatusCode500() {
        Map<String, Integer> statusCodes = statusCodesPage.getStatusCodes();
        assertEquals(500, statusCodes.get("500"), "Статус-код 500 неверный");
    }
}