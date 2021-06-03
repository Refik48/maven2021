package GrupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_DictionaryUyeOl {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void uyeOlma() {
        driver.get("https://dictionary.cambridge.org/tr/");
        driver.findElement(By.xpath("(//span[@class='tb'])[2]")).click();
        driver.get("https://dictionary.cambridge.org/tr/auth/signup?rid=amp-qaj6VQDbN5qKJmcJlLuHbw&return=https%3A%2F%2Fcdn.ampproject.org%2Fv0%2Famp-login-done-0.1.html%3Furl%3Dhttps%253A%252F%252Fdictionary.cambridge.org%252Ftr%252F");
        WebElement emailKutusu = driver.findElement(By.xpath("(//input[@name='email'])[3]"));
        emailKutusu.sendKeys("hahahahahahgmail.com");

        WebElement isimKutusu = driver.findElement(By.xpath("(//input[@name='profile.firstName'])[2]"));
        isimKutusu.sendKeys("Godfather");

        WebElement soyisimKutusu = driver.findElement(By.xpath("(//input[@name='profile.lastName'])[2]"));
        soyisimKutusu.sendKeys("Stewie");

        WebElement pwKutusu = driver.findElement(By.xpath("(//input[@name='password'])[3]"));
        pwKutusu.sendKeys("adimCaferBoyum1.10");

        WebElement pwKutusu2 = driver.findElement(By.xpath("(//input[@name='passwordRetype'])[3]"));
        pwKutusu2.sendKeys("adimCaferBoyum1.10");

        WebElement tikKutusu = driver.findElement(By.xpath("(//input[@name='data.press.terms.v1.blnAccepted'])[3]"));
        tikKutusu.click();

        WebElement singUpButonu = driver.findElement(By.xpath("(//input[@class='gigya-input-submit'])[7]"));
        singUpButonu.click();

    }

}
