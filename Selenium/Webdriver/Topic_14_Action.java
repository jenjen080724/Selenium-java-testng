package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_14_Action {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);
    }

    /**/@Test
    public void TC_01() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip//");

        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        action.moveToElement(ageTextbox).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
    }
        @Test
    public void TC_02_Jquery() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageBox = driver.findElement(By.cssSelector("input#age"));
        action.moveToElement(ageBox).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
        }

    @Test
    public void TC_03_Fahasa () throws InterruptedException {
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.xpath("//span[text()='Sách Trong Nước']"))).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='dropdown-menu-inner']//a[text()='Tiểu Thuyết']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='category201']/strong[text()='Tiểu thuyết']")).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

