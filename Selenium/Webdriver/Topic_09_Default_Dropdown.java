package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    String firstName = "Kevin", lastName="Lamping", emailAddress = getEmailAddress();

    String companyName= "Selenium Webdriver",passWord= "123456";

    String day = "15", month = "October", year = "1950";
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
    driver.findElement(By.cssSelector("a.ico-register")).click();

    driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
    driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);

    //Day dropdown
    Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
    //Chọn ngay
    day.selectByVisibleText(this.day);

    //Verify dropdown la single
        Assert.assertFalse(day.isMultiple());

    //Verify so luong dropdown la 32 item
        Assert.assertEquals(day.getOptions().size(),32);

    new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
    new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

    //Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
    //year.selectByVisibleText("1935");

    driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
    driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
    driver.findElement(By.cssSelector("input#Password")).sendKeys(passWord);
    driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(passWord);

    driver.findElement(By.cssSelector("button#register-button")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    driver.findElement(By.cssSelector("a.ico-logout")).click();
    sleepInSeconds(3);
    }

    @Test
    public void TC_02_Login() {
    driver.get("https://demo.nopcommerce.com/");


    //Login
    driver.findElement(By.xpath("//a[@class='ico-login']")).click();
    driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
    driver.findElement(By.cssSelector("input#Password")).sendKeys(passWord);
    driver.findElement(By.cssSelector("button.button-1.login-button")).click();
    sleepInSeconds(3);

    //Verify
    driver.findElement(By.cssSelector("a.ico-account")).click();
    sleepInSeconds(3);

    Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
    Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

    Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
    Assert.assertEquals(new Select (driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
    Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);


    Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
    Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);
    }

    @Test
    public void TC_03_Form() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress(){
        Random rand = new Random();
        return "automation" + rand.nextInt(99999)+ "@gmail.com";

    }

}