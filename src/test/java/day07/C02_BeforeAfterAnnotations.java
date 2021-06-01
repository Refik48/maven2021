package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeAfterAnnotations {
    WebDriver driver;

    @Before // Yani tum method'lardan once calismali o yuzden before annotation'i olmali.
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Burasi olmadan hata verir, setup lazim.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Before Annotation'li setup() method'u calisti");
    }

    @After // Butun method'lardan sonra calismasi icin after annotation'i olmali.
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("After Annotation'li tearDown() method'u calisti");
    }

    @Test
    public void test01() {
        driver.get("https://www.volvocars.com/intl");
        System.out.println("1. Method calisti ve volvoya gitti.");
    }
    // Before Annotation'li setup() method'u calisti
    // 1. Method calisti ve volvoya gitti.
    // After Annotation'li tearDown() method'u calisti

    @Test
    public void test02() {
        driver.get("http://amazon.com");
        System.out.println("2. Method calisti ve amazona gitti.");
    }
    // Before Annotation'li setup() method'u calisti
    // 2. Method calisti ve amazona gitti.
    // After Annotation'li tearDown() method'u calisti

    @Test
    public void test03() {
        driver.get("http://twitter.com");
        System.out.println("3. Method calisti ve twitter'a gitti.");
    }
    // Before Annotation'li setup() method'u calisti
    // 3. Method calisti ve twitter'a gitti.
    // After Annotation'li tearDown() method'u calisti

    /*
        Before, After olunca ne oldu ?
        @Before ve @After'da MER METHOD'dan sonra calisiyor.
        Bir sonraki class'da @AfterClass ve @BeforeClass var.
        AfterClass butun methodlardan SONRA 1 KEZ CALISTI.
     */
}
