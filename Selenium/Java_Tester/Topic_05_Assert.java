package Java_Tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;

    @Test
    public void verifyTestNG() {
        driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");

    //Trong java có nhiều thư viện để verify dữ liệu
    //Testing Framework (Uni/Intergrantion/UI Automation Test)
    //Junit 4/TestNG/Junit 5/Hamcreast/AssertJ/..

    //Kiểu dữ liệu nhận vào là boolean (true/false)
    // Khi mong muốn điều kiện trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        // Thường dùng cho Unit Test
        Object name = null;
        Assert.assertNull(name);

        //Name = "testing";
       // Assert.assertNotNull(Name);

        //Mong đợi điều kiện giống như thực tế
        //Actual = Expected
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")),"Test case");






    }
    }