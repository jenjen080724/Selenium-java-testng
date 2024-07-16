package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class Topic_02_Selenium_Locator{
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register/");
    }
    @Test
    public void TC_01_ID() {
        // Tìm element có id là Firstname
        driver.findElement(By.id("FirstName")).sendKeys("Kean");
    }

    @Test
    public void TC_02_class() {
        //Tìm element có class
        driver.findElement(By.className("header-logo"));

    }
    @Test
    public void TC_03_name() {
        //Tìm element có name
        driver.findElement(By.name("DateOfBirthDay"));

    }
    @Test
    public void TC_04_tagname() {
        //Tìm element có tagname,
        driver.findElements(By.tagName("input"));
    }
    @Test
    public void TC_05_Linktext() {
        //Tìm element có linktext,
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_Linktext() {
        //Tìm element có linktext,
        driver.findElement(new By.ByPartialLinkText("Apply for"));
    }
    @Test
    public void TC_07_Css() {
        //CSS vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css vs tagname
        driver.findElement(By.cssSelector("input"));

        //Css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        //Css vs partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
        //driver.findElement(By.cssSelector("a[href$='addresses']"));
    }
    public void TC_08_Css() {
        //Xpath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //Xpath vs Class
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //Xpath vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //Xpath vs tagname
        driver.findElement(By.xpath("//input"));

        //Xpath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        //Xpath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
//    driver.quit();
    }
}