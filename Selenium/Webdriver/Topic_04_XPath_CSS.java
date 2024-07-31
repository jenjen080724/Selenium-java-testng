package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_XPath_CSS {
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
    }
    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

       //String emailAdresserrormessage = driver.findElement(By.id("txtFirstname-error")).getText();
        //Assert.assertEquals(emailAdresserrormessage,"Vui lòng nhập họ tên");
        //2 dòng nay giong dong duoi

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");


    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("1124@123@123");
        driver.findElement(By.id("txtCEmail")).sendKeys("1124@123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtPhone")).sendKeys("0985675677");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("sfd@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("1124@123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtPhone")).sendKeys("0985675677");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("sdfsd@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("sdfsd@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0985675677");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("sdfsd@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("sdfsd@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0985675677");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

        //MK ko khop
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtCPassword")).sendKeys("1235678");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Invalid_Phone_number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Bidden");
        driver.findElement(By.id("txtEmail")).sendKeys("sfsdf@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("sfsdf@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA@22423");
        driver.findElement(By.id("txtPhone")).sendKeys("098777887");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify - less than 10 numbers
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        //>10 so
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("09856756774353");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        //Dau so ko hop le
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234774353");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        //Nhap chu
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("ewf");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập con số");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
