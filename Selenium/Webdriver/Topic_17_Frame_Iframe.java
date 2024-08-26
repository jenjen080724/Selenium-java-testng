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

public class Topic_17_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Frame(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
        sleepInSeconds(5);

        //Iframe Element
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(formIframe.isDisplayed());

        //Switch vao fram trươc khi thao tac voi cac element
/*        //Dung index-> co the ko chinh xac
        driver.switchTo().frame(0);

        //Dung id-> co the bi thay doi
        driver.switchTo().frame("frame-one85593366");*/

        //Dung element->chinh xac nhat
        driver.switchTo().frame(formIframe);

        //Ko tim thay element (element nam trong ifram)
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        sleepInSeconds(2);

        driver.switchTo().defaultContent();
        sleepInSeconds(2);

        //driver.findElement(By.xpath("//nav[@class='header header--desktop']/div/a[text()=' Log in ']")).click();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();

        driver.findElement(By.cssSelector("button#login")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }
        @Test
        public void TC_02_Kyna () throws InterruptedException {
        driver.get("https://kynaenglish.vn/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb-page.fb_iframe_widget iframe")));
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Kyna English 1 kèm 1']/parent::div/following-sibling::div")).getText(),"50K followers");


        }

        @Test
        public void TC_03_Form ()  {

        }
        @AfterClass
        public void afterClass () {
            driver.quit();
        }
        public void sleepInSeconds ( long timeInSecond){
            try {
                Thread.sleep(timeInSecond * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
