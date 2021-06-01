package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_TestAnnotation {
    WebDriver driver;

    @Test
    public void test01() {
        // Test annotation'i yazinca test01'in yaninda 1 tane yesil ok cikti, class'in icinde 2 ok cikti.
        // Class'i run edince hepsini calistirir, method'u run edince sadece o method calisir.
        WebDriverManager.chromedriver().setup(); // Burasi olmadan hata verir, setup lazim.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // implicitlyWait en fazla verilen sure kadar bekler. Islem o sureden once yapilirsa beklemez.

        driver.get("http://https://www.volvocars.com/intl");

    }

    // Birden fazla test method'u olacaksa class level'da WebDriver olusturmaliyiz.
    // Aksi halde her method'a ozgu WebDriver olusturmaliyiz.
    @Test
    public void test02() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Burasi olmadan hata verir, setup lazim.
        driver = new ChromeDriver();
        driver.get("http://amazon.com");
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void test03() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Burasi olmadan hata verir, setup lazim.
        driver = new ChromeDriver();
        driver.get("http://facebook.com");
        Thread.sleep(5000);
        driver.close();
    }


}
