import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {

    @Test
    public void signUpTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Michael");
        driver.findElement(By.name("last_name")).sendKeys("Jordan");
        driver.findElement(By.name("email")).sendKeys("MJ@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("Magic");
        driver.findElement(By.name("password2")).sendKeys("Magic");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String confirmationMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(confirmationMessage, "Account is created!");
        driver.quit();
    }
}
