package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_Webdriver_Commands_01 {
    //Các câu lệnh để thao tác với trình duyệt sẽ đứng sau driver
    // VD: driver.
    WebDriver driver;
    //-	Các câu lệnh để thao tác với element
    // element.
    WebElement element;

    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");


    @BeforeClass
    public void beforeClass() {
        //Muốn dùng được thì phải khởi tạo
        driver = new FirefoxDriver();
        System.out.println(driver.toString());
        //FirefoxDriver: firefox on windows (f90b35dc-d27a-4d27-884b-6c3e6fb17d83)
        //GUID: Global Unique Identifier Number (

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        //Selenium v 3
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01() {
        //Set truc tiep
        driver.get("https://www.facebook.com/");
        // Khai bao bien
        //Bien chi dung khi nao can dung nhieu
        String HomepageUrl = "https://www.facebook.com/";
        driver.get("HomepageUrl");//ko hơp lệ
        driver.get(HomepageUrl);

        // đóng tab
        driver.close();
        // đóng browser
        driver.quit ();

        //Tim 1 element
        driver.findElement(By.id("email"));
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));
        //Tim nhieu element
        driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkboxes']"));
        checkboxes.get(1).click();

        driver.findElement(By.cssSelector("button#login")).click();

        String loginPageUrl = driver.getCurrentUrl();
        //Dùng để lấy URL của màn hình hiện tại đang dùng:
        driver.getCurrentUrl();
        //Dùng để verify một cách tương đối
        driver.getPageSource();
        driver.getPageSource().contains("The Apple");
        Assert.assertTrue(driver.getCurrentUrl().contains("The Apple"));
        Assert.assertEquals(driver.getPageSource(),"The Apple");

        //Lấy ra cái title của page hiện tại
        driver.getTitle();

        //Lấy ra cái ID của cửa sổ, tab hiện tại
        //Handle Window/Tab
        driver.getWindowHandle();
        driver.getWindowHandles();
        System.out.println("window/Tab ID = " + driver.getWindowHandle());

        //Cookíe-Framework
        driver.manage().getCookies();

        //Get ra những log ở dev tool
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm element(find Element)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Chờ cho page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Set trước khi dùng vs thư viện JavascriptExceutor
        //Inject 1 đoạn code JS vào trong Browser/Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Selenium vs 4 trở lên mới có hàm này - ít dùng
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        // mở full màn hình - ko có thanh bar phía trên-tương ứng với F11
        driver.manage().window().fullscreen();

        // mở to màn hình
        driver.manage().window().maximize();

        //Test Reponsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().getSize();

        //Set cho browser ở vị trí nào so vs độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0,0));//góc trên cùng bên trái tọa độ là 0,0
        driver.manage().window().getPosition();

        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // Thao tác với history của page (back/forward)- ít dùng
        driver.navigate().to("https://www.facebook.com/");
        //driver.navigate().to(new URL("https://www.facebook.com/"));

        //Alert/Window(TAb), Frame
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("test");

        //Lấy ra ID của cửa sổ/tab hiện tại
        //Handle Window/Tab
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window((homePageWindowID));

        //Switch/handle fram (iFrame)
        //Index/ID(name)/Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("name");
        driver.switchTo().frame(driver.findElement(By.id("")));

        //Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        //Từ frame trong đi ra frame ngoài chứa nó
        driver.switchTo().parentFrame();




        //Nếu chỉ dùng 1 lần thì không khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Assert.assertEquals(loginPageUrl,"https://www.facebook.com/");
        driver.get(loginPageUrl);





    }

    @Test
    public void TC_02() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
