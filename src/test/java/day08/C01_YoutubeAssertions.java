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

public class C01_YoutubeAssertions {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        a. titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        b. imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        c. Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        d. wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

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
    public void titleTesti() {
        driver.get("http://youtube.com");
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
        Assert.assertEquals(expectedTitle,actualTitle);
        // Iki yontemde calisir, birbirleri ile aynidirlar.
        // Sonucu yazdirmiyoruz Test'in pass olup olmadigi ile ilgileniyoruz.

    }
    @Test
    public void resimTesti() {
        driver.get("http://youtube.com");
        WebElement logo = driver.findElement(By.xpath("//yt-icon[@id='logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void aramaKutusu() {
        driver.get("http://youtube.com");
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#search"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }
    @Test
    public void titleTest2() {
        driver.get("http://youtube.com");
        String unexpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.equals(unexpectedTitle));

    }

}
