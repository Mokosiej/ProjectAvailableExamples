package tests;

import models.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FormAuthenticationPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormAuthenticationTest extends TestBase {
    private HomePage homePage;
    private FormAuthenticationPage formAuthenticationPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        formAuthenticationPage = new FormAuthenticationPage(driver);
        homePage.goToFormAuthentication();
    }

    @Test
    @DisplayName("Checking successful login with correct data")
    public void testSuccessfulLogin() {
        UserProfile user = UserProfile.builder()
                .username("tomsmith")
                .password("SuperSecretPassword!")
                .build();

        formAuthenticationPage.login(user.getUsername(), user.getPassword());
        String flashMessage = formAuthenticationPage.getFlashMessage();
        assertTrue(flashMessage.contains("You logged into a secure area!"),
                "Сообщение об успешном входе не отображается");
    }
}
