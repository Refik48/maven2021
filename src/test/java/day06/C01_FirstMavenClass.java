package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C01_FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        // Keys.ENTER ile submit gorevini gormus oluyoruz.

        // **** Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiWebElementi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiWebElementi.getText());
        // sadece sonuc adedini istersek sonuc yazisini String'e atayip string manipulation yapabiliriz.

        // **** Ilk urunu tiklayalim
        Thread.sleep(3000);
        // Sleep kodumuzu bekletir. Alti kirmizi cizgili oldu throw exception yapiyoruz.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // 1. urun icin [1], 2. urun icin [2]...

        // **** Geri giderek arama sayfasindaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> basliklarListesi =
                driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        // 58 tane baslik oldugunu gorduk. Yani 58 tane eleman var,
        // bunlari bir listeye koyup yazdirmam gerekiyor.

        for (WebElement w : basliklarListesi) {
            System.out.println(w.getText());
        }

        driver.close();

    }
}
