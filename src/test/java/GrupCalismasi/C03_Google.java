package GrupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_Google {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("test");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        // Arama kutusuna test yazdiktan sonra onerilenler listesinde bir kez arrow down gorevini goruyor.
        Thread.sleep(2000);
        // searchBox.sendKeys(Keys.ENTER);

        List <WebElement> results = driver.findElements(By.xpath("//li[@class='sbct']"));
        for (WebElement w : results) {
            if (w.getText().equals("testkolik")) {
                w.click();
                break;
            }
        }

    }
}
