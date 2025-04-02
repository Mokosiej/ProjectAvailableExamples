package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public WebDriver startTest() {

        switch (browser){
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
                driver= new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
                driver= new FirefoxDriver();
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", "C:/Tools/msedgedriver.exe");
                driver= new EdgeDriver();
            }

        }

        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }

    public void stopTest(){
        driver.quit();
    }
}

