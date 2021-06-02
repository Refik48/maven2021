package day07;

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

public class C06_BestBuyAssertion {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        a. Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        b. titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        c. logoTest => BestBuy logosunun görüntülendigini test edin
        d. FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    // Assertion fail olursa icinde bulundugu testin kalan kismini calistirmaz.
    // Hata vermiyorsa dogrudur.
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
        driver.get("http://bestbuy.com");

        // a. Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        // Ister boyle yazariz istersek tek satirda direkt olarak Assert icinde halledebiliriz.
        // Fakat boyle daha profesyonel ve okunabilir haldedir.

        // b. titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unexpectedWordRest = "Rest";
        String actualTitle = driver.getTitle();

        // actualTitle.contains(unexpectedWordRest); // Bu kelime Title'da olmadigi icin false doner.
        Assert.assertFalse(actualTitle.contains(unexpectedWordRest));
        // Icermedigini aradigimiz icin "ASSERTFALSE" yazdik.

        // title'in Best icerdigi kelimeyi test edin.
        String istenenKelime = "Best"; // Icerdigi kelimeyi test ettigimiz icin "ASSERTTRUE" yazdik.
        Assert.assertTrue(actualTitle.contains(istenenKelime));
        System.out.println("test sonuna kadar calisti");
        // Assert failed oldugunda Kodun calismasini durdurur

        // c. logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo=driver.findElement(By.xpath("(// img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLinki=driver.findElement(By.xpath("// button[@lang='fr']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());


    }

}
