package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FileUploadPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadTest extends TestBase {
    private HomePage homePage;
    private FileUploadPage fileUploadPage;

    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        fileUploadPage = new FileUploadPage(driver);
        homePage.goToFileUpload();
    }

    @Test
    @DisplayName("Checking file download")
    public void testFileUpload() {
        String filePath = "C:/Tools/1.jpg";
        fileUploadPage.uploadFile(filePath);
        String uploadedFileName = fileUploadPage.getUploadedFileName();
        assertEquals("1.jpg", uploadedFileName, "Имя загруженного файла неверное");
    }
}
