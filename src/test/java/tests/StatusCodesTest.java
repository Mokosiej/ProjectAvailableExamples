package tests;

import pages.HomePage;
import pages.StatusCodesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Checking the validity of status codes without clicking on links")
    public void testStatusCodesValidity() {
        Map<String, String> statusCodeLinks = statusCodesPage.getStatusCodeLinks();
        assertEquals(4, statusCodeLinks.size(), "Ожидалось 4 ссылки на статус-коды");


        for (Map.Entry<String, String> entry : statusCodeLinks.entrySet()) {
            String code = entry.getKey();
            String url = entry.getValue();
            int expectedCode = Integer.parseInt(code);
            int actualCode = statusCodesPage.getHttpStatusCode(url);
            assertEquals(expectedCode, actualCode, "URL " + url + " вернул неверный статус-код");
        }


        String description = statusCodesPage.getDescriptionText();
        assertFalse(description.contains("This page returned a"),
                "Текст описания не содержит ожидаемой информации");
    }
}
