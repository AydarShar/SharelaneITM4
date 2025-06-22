import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DiscountTest {

    @Test
    public void checkDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py?page=2&zip_code=11111&first_name=Michael&" +
                "last_name=Jordan&email=MJ%40gmail.com&password1=Magic&password2=Magic");
        String email = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td[1]/b")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[1]/p/b")).getText(), "0");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[2]")).getText(), "0");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[3]")).getText(), "190");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py?page=2&zip_code=11111&first_name=Michael&" +
                "last_name=Jordan&email=MJ%40gmail.com&password1=Magic&password2=Magic");
        String email = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td[1]/b")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[1]/p/b")).getText(), "2");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[2]")).getText(), "9.8");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[3]")).getText(), "480.20");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py?page=2&zip_code=11111&first_name=Michael&" +
                "last_name=Jordan&email=MJ%40gmail.com&password1=Magic&password2=Magic");
        String email = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td[1]/b")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[1]/p/b")).getText(), "3");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[2]")).getText(), "15");
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[3]")).getText(), "485");
        driver.quit();
        softAssert.assertAll();
    }
}
