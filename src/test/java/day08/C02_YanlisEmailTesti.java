package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_YanlisEmailTesti {
    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
        // driver.close();
    }

    @Test
    public void Test01() {
        driver.get("http://automationpractice.com/index.php");

        // Sign in butonuna basiniz.
        driver.findElement(By.xpath("//a[@class='login']")).click();

        // @ isareti olmayan mail yollayin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        String yanlisEmail = "hahaha";
        emailKutusu.sendKeys(yanlisEmail);
        emailKutusu.submit();

        // Uyari ciktigini test edelim.
        WebElement hataYazisiWebElementi = driver.findElement(By.xpath("//li[.='Invalid email address.']"));
        String expectedHataYazisi = "Invalid email address";
        // Invalid email address. olmaliydi . olmadigi icin hata verdi
        String actualHataYazisi = hataYazisiWebElementi.getText();
        Assert.assertEquals(expectedHataYazisi,actualHataYazisi);

    }
}
