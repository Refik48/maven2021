package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05_RadioButton {
    /*
        1. Bir class oluşturun : RadioButtonTest
        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        https://www.facebook.com adresine gidin
        “Create an Account” button’una basin
        “radio buttons” elementlerini locate edin
        Secili degilse cinsiyet butonundan size uygun olani secin
     */

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
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // id neden kullanamadim ? Cunku her sayfa yenilendiginde id degisiyor.
        // Bu yuzden xpath ile sectim.

        // Secili degilse cinsiyet butonundan size uygun olani secin
        // Bu cumle olmasaydi asagidaki gibi yapacaktim
        // driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        // AMA soruda bizden "SECILI DEGILSE" diyor.
        WebElement radioErkek = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if (!radioErkek.isSelected()) {
            radioErkek.click();
        }
    }
}
