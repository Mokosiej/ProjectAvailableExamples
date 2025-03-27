package tests;

import pages.DropdownPage;
import pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends TestBase {
    private HomePage homePage;
    private DropdownPage dropdownPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);
        homePage.goToDropdown();
    }

    @Test
    @DisplayName("Checking that Option 1 is selected in the dropdown list")
    public void testSelectOption1() {
        dropdownPage.selectOption("Option 1");
        String selectedOption = dropdownPage.getSelectedOption();
        assertEquals("Option 1", selectedOption, "Выбранная опция неверная");
    }

    @Test
    @DisplayName("Checking that Option 2 is selected in the dropdown list")
    public void testSelectOption2() {
        dropdownPage.selectOption("Option 2");
        String selectedOption = dropdownPage.getSelectedOption();
        assertEquals("Option 2", selectedOption, "Выбранная опция неверная");
    }
}