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

public class Topic_07_WebElement_Command_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_Displayed() {
    driver.get("https://automationfc.github.io/basic-form/");
    if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
        driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
        System.out.println("Email Textbox is displayed");
    } else {
        System.out.println("Email Textbox is not displayed");
    }

    if (driver.findElement(By.xpath("//label[text()='Under 18']")).isDisplayed()){
        driver.findElement(By.xpath("//label[text()='Under 18']")).click();
        System.out.println("Under 18 Radio is displayed");
    } else {
        System.out.println("Under 18 Radio is not displayed");
    }
    if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
        driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
        System.out.println("Education TextArea is displayed");
    } else {
        System.out.println("Education TextArea is not displayed");
    }

    if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
        System.out.println("Name user 5 text is displayed");
    } else {
        System.out.println("Name user 5 text is not displayed");
    }
    }

    @Test
    public void TC_02_Enabled () {
        driver.get("https://automationfc.github.io/basic-form/");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email Textbox is enabled");
        } else {
            System.out.println("Email Textbox is disabled");
        }
        driver.get("https://automationfc.github.io/basic-form/");
        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password Textbox is enabled");
        } else {
            System.out.println("Password Textbox is disabled");
        }
    }
    @Test
    public void TC_03_Selected () {
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.cssSelector("input#under_18")).click();

        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        driver.findElement(By.cssSelector("input#java")).click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());

    }

   @Test
   public void TC_04_MailChimp () {
       driver.get("https://login.mailchimp.com/signup/");
       driver.findElement(By.cssSelector("input#email")).sendKeys("Automationfc123@gmail.com");

/*       //Case 1- Number

       driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        //Case 2-lower case
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("input#new_password")).sendKeys("Auto");
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

       //Case - upper case
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("input#new_password")).sendKeys("AUTO");
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

       //Case-special chracter
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("input#new_password")).sendKeys("!@#");
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

       // Max length
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());

       //Valid password
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("input#new_password")).sendKeys("Auto123@");
       sleepInSeconds(2);

       Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
       Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
       Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
       Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
       Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());*/

    //Case 7: Empty Data
       driver.findElement(By.cssSelector("input#new_password")).clear();
       driver.findElement(By.cssSelector("button#create-account-enabled")).click();
       sleepInSeconds(2);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

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
}


