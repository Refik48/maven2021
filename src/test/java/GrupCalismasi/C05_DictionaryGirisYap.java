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

public class C05_DictionaryGirisYap {

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
    public void test01() {
        driver.get("https://dictionary.cambridge.org/tr/");
        WebElement oturumAc = driver.findElement(By.xpath("(//span[@class='tb'])[1]"));
        oturumAc.click();

        driver.get("https://dictionary.cambridge.org/tr/auth/signin?rid=amp-gvfkl736V9BqE1u3I1TTSw&return=https%3A%2F%2Fcdn.ampproject.org%2Fv0%2Famp-login-done-0.1.html%3Furl%3Dhttps%253A%252F%252Fdictionary.cambridge.org%252Ftr%252F");
        WebElement emailBox = driver.findElement(By.xpath("(//input[@name='username'])[3]"));
        emailBox.sendKeys("hahahaha@gmail.com");

        WebElement pwBox = driver.findElement(By.xpath("(//input[@type='password'])[6]"));
        pwBox.sendKeys("aboneyimabone");
        pwBox.submit();
    }
}
