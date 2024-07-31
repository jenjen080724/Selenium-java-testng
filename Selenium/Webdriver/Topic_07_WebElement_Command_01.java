package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_07_WebElement_Command_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

    }
    @Test
    public void TC_01() {
        //Dùng để xóa dữ liệu trong 1 field cho phép nhập (editable)
        //Textbox/Text area/Dropdown (Editable)
        //Thường được sử dụng trước hàm Sendkey để đảm bảo tính toàn vẹn của dữ liệu
        driver.findElement(By.id("")).clear();

        // Dùng để nhập liệu vào các field bên trên
        driver.findElement((By.id(""))).sendKeys("");

        // Dùng để click lên element
        driver.findElement(By.id("")).click();

        //Tìm từ node cha vào node con
        driver.findElement(By.id("")).findElement(By.id(""));
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));

        //Trả về 1 element khớp với đk
        WebElement fullNameTextbox = driver.findElement(By.id(""));

        //Trả về nhiều element khớp vs đk
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));

        //Dùng để verify checkbox/radio/dropdown đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dùng để verify 1 element bất kỳ có hiển thị hay không
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //Dropdown (default/custom)
        Select select = new Select(driver.findElement(By.id("")));

        //Dùng để verify 1 element có được thao tác lên hay không (không phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        //HTML//lấy ra giá trị của attribue được truyền, VD title ="First name"-> lấy ra Firstname
        driver.findElement(By.id("")).getAttribute("title");

        //Tab Assesability và Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        //driver.findElement(By.id("")).getDomProperty();

        //Stype trong Element
        driver.findElement(By.id("")).getCssValue("background-color");
        //rgp (46,138,184)
        driver.findElement(By.id("")).getCssValue("font-size");

        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();

        //Location vs Size
        Rectangle nameTextboxRec = driver.findElement(By.id("")).getRect();
        //Location
        Point namePoint= nameTextboxRec.getPoint();
        //Size
        Dimension nameSize = nameTextboxRec.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        //Shadow Element
        driver.findElement(By.id("")).getShadowRoot();

        //Từ Id/clas/name/css/xpath
        driver.findElement(By.cssSelector("#firstname")).getTagName();//input
        driver.findElement(By.id("firstname")).getTagName();//input
        driver.findElement(By.className("form-instructions")).getTagName();//p
        driver.findElement(By.xpath("//[@class='form-list']")).getTagName();//ul

        //Lấy text
        driver.findElement(By.cssSelector("address.copyright")).getText();

        //Chụp hình bị lỗi và lưu dưới dạng nào
        //BYTE
        //FILE (Lưu thành 1 hình có kích thuước ở trong ổ cứng: .png/.jpg..)
        //BASE64 (Hình dạng text)
        driver.findElement((By.cssSelector("address.copyright"))).getScreenshotAs(OutputType.FILE);
        driver.findElement((By.cssSelector("address.copyright"))).getScreenshotAs(OutputType.BASE64);
        driver.findElement((By.cssSelector("address.copyright"))).getScreenshotAs(OutputType.BYTES);

        //Element nào là thẻ form hoặc nằm trong thẻ form/giống nhấn Enter
        driver.findElement(By.id("")).submit();

        //HTML Element: Textbox/TextArea/Dropdown/Checkbox/Link/Button/...

        //Tìm chưa tương tác lên
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys("");

        //Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
        //Khi dùng cái biến này ít nhất từ 2 lần trở lên
       // WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("sfsd");
        fullNameTextbox.getAttribute("value");
    }

    @Test
    public void TC_02() {
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
