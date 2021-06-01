package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_BeforeClassAfterClass_Ignore {
    static WebDriver driver;

    @BeforeClass // @BeforeClass ve @AfterClass Static olmasi gerekiyor, aksi halde hata verir.
    // Static olunca driver hata veriyor. driver'i da static yapmamiz gerekiyor.
    public static void setup() {
        WebDriverManager.chromedriver().setup(); // Burasi olmadan hata verir, setup lazim.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Before Annotation'li setup() method'u calisti");
    }

    @AfterClass // @BeforeClass ve @AfterClass Static olmasi gerekiyor, aksi halde hata verir.
    // Static olunca driver hata veriyor. driver'i da static yapmamiz gerekiyor.
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("After Annotation'li tearDown() method'u calisti");
    }

    @Test
    public void test01() {
        driver.get("https://www.volvocars.com/intl");
        System.out.println("1. Method calisti ve volvoya gitti.");
    }

    @Test @Ignore // @Ignore olunca bu test asamasi yoksayildi ve calismadi.
    public void test02() {
        driver.get("http://amazon.com");
        System.out.println("2. Method calisti ve amazona gitti.");
    }

    @Test
    public void test03() {
        driver.get("http://twitter.com");
        System.out.println("3. Method calisti ve twitter'a gitti.");
    }

    /*
        BeforeClass, AfterClass olunca ne oldu ?
        AfterClass butun methodlardan SONRA 1 KEZ CALISTI.
        Bir onceki class'da yani @Before ve @After'da MER METHOD'dan sonra calisiyordu.
        Her method'da sayfayi kapatip yeniden acmak istiyorsak @Before @After kullanmaliyiz.
        Eger kapatmamiza gerek yoksa @BeforeClass @AfterClass'i kullanmaliyiz.
        @BeforeClass, @AfterClass static olmak zorunda.
        @Ignore : Yazildigi testi yoksayarak calistirmaz ve sonuc ekranina yazdirmaz.
     */
    /*
        SONUC EKRANI :
        Before Annotation'li setup() method'u calisti
        1. Method calisti ve volvoya gitti.
        2. Method calisti ve amazona gitti.
        3. Method calisti ve twitter'a gitti.
        After Annotation'li tearDown() method'u calisti.
     */

}
