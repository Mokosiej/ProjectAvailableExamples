package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.ApplicationManager;

public class TestBase {
    public WebDriver driver;
    protected ApplicationManager app;
    protected String browser;

    @BeforeEach
    public void init() {
        browser = System.getProperty("browser", "chrome");
        app = new ApplicationManager(browser);
        driver = app.startTest();
    }

    @AfterEach
    public void tearDown() {
        app.stopTest();
    }
}
