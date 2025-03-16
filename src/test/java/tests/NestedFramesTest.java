package tests;

import pages.HomePage;
import pages.NestedFramesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFramesTest extends TestBase {
    private HomePage homePage;
    private NestedFramesPage nestedFramesPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
        homePage.goToNestedFrames();
    }

    @Test
    public void testNestedFramesLeft() {
        String leftText = nestedFramesPage.getLeftFrameText();
        assertEquals("LEFT", leftText, "Текст в левом фрейме неверный");
    }

    @Test
    public void testNestedFramesMiddle() {
        String middleText = nestedFramesPage.getMiddleFrameText();
        assertEquals("MIDDLE", middleText, "Текст в среднем фрейме неверный");
    }

    @Test
    public void testNestedFramesRight() {
        String rightText = nestedFramesPage.getRightFrameText();
        assertEquals("RIGHT", rightText, "Текст в правом фрейме неверный");
    }

    @Test
    public void testNestedFramesBottom() {
        String bottomText = nestedFramesPage.getBottomFrameText();
        assertEquals("BOTTOM", bottomText, "Текст в нижнем фрейме неверный");
    }
}