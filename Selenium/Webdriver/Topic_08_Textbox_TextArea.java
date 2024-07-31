package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void Login_TC_01_Empty_email_and_password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void Login_TC_02_Invalid_email () {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("123456@123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Login_TC_03_Invalid_password () {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_TC_04_Incorrect_Email_Or_Password () {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123123123");

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");
    }

    @Test
    public void Login_TC_05_Sucess() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        //1 Đăng ký trước bằng tay-> khi có xóa h

        driver.findElement(By.cssSelector("div.buttons-set a.button")).click();
        sleepInSeconds(2);

        //Register
        String firstName = "Automation", middleName = "FF", lastName = "CC", emailAddress = getEmailAddress(), password = "123456";

        String fullName = firstName + " " + middleName + " " + lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#middlename")).sendKeys(middleName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello,"+" "+ fullName + "!");

        String contactinfo = driver.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactinfo.contains(fullName));
        Assert.assertTrue(contactinfo.contains(emailAddress));

        //Logout
        driver.findElement(By.cssSelector("a.skip-link.skip-account span.label")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("div.footer-container a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        //Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello,"+" "+ fullName + "!");

        contactinfo = driver.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactinfo.contains(fullName));
        Assert.assertTrue(contactinfo.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(2);


        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#middlename")).getAttribute("value"), middleName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"), emailAddress);

    }
    @AfterClass
    public void afterClass() {
        //driver.quit();
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


