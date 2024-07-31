package Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Run_More_Browser {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        //Dành cho version Selenium 2., 3., vs duoi 4.11
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }
    }

    @Test
    public void TC_01_Run_on_Firefox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        driver.quit();
    }

    @Test
    public void TC_02_Run_on_Chrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_03_Run_on_Edge() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        driver.quit();
    }
    @Test
    //Nếu la he dieu hanh Mac se chay case nay, ko chay neu he dieu hanh la window
    public void TC_04_Run_on_Safari() {
        if(osName.contains("Mac")){
            driver = new SafariDriver();
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            driver.get("https://www.facebook.com");
            driver.quit();
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}