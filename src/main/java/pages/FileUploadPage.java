package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileInput;

    @FindBy(id = "file-submit")
    WebElement uploadButton;

    public void uploadFile(String filePath) {
        uploadFile(fileInput, filePath);
        click(uploadButton);
    }

    @FindBy(id = "uploaded-files")
    WebElement uploadedFileName;

    public String getUploadedFileName() {
        return getText(uploadedFileName);
    }
}
