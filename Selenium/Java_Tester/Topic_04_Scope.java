package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Scope {
    WebDriver driver;

    String homePageUrl;//Khai báo:Declare - Biến global

    String fullName = "Automation FC"; //Khởi tạo và khai báo- biến local




    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_01() {

    String homePageUrl = "https://www.facebook.com/";
    driver.get(this.homePageUrl);

    }

    @Test
    public void TC_02() {
    }

    @Test
    public void TC_03() {
    }

    @Test
    public void TC_04() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
