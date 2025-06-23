import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class DiscountTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @DataProvider(name = "discount")
    public Object[][] provideDiscountData() {
        return new Object[][] {
                {"19", "0", "0", "190"},
                {"49", "2", "9.8", "480.20"},
                {"50", "3", "15", "485"}
        };
    }

    @Test(dataProvider = "discount")
    public void checkDiscount0(String booksQuantity, String discountPercent, String discountUsd, String total) {
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
        driver.findElement(By.name("q")).sendKeys(booksQuantity);
        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[1]/p/b")).getText(), discountPercent);
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[2]")).getText(), discountUsd);
        softAssert.assertEquals(driver.findElement(By.xpath("//td[text()='10.00']/following-sibling::td[3]")).getText(), total);
        driver.quit();
        softAssert.assertAll();
    }
}
