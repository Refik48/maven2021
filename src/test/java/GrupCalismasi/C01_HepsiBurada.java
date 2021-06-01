package GrupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_HepsiBurada {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
        driver.findElement(By.id("myAccount")).click();
        driver.findElement(By.id("register")).click();
        WebElement uyeOl= driver.findElement(By.id("btnSignUpSubmit"));
        System.out.println("isDisplayed "+uyeOl.isDisplayed());
        System.out.println("isEnabled "+uyeOl.isEnabled());
        System.out.println("isSelected "+uyeOl.isSelected());
        if (uyeOl.isEnabled()) {
            System.out.println("Üye Ol butonu Aktif");
        } else {
            System.out.println("Üye Ol butonu Aktif değil");
        }
        driver.findElement(By.id("txtName")).sendKeys("Automation");
        driver.findElement(By.id("txtSurname")).sendKeys("Tester");
        driver.findElement(By.id("txtEmail")).sendKeys("automationtester@mailinator.com");
        driver.findElement(By.id("txtNewPassEmail")).sendKeys("Automation01");
        System.out.println("isDisplayed "+uyeOl.isDisplayed());
        System.out.println("isEnabled "+uyeOl.isEnabled());
        System.out.println("isSelected "+uyeOl.isSelected());
        if (uyeOl.isEnabled()) {
            System.out.println("Üye Ol butonu Aktif");
        } else {
            System.out.println("Üye Ol butonu Aktif değil");
        }
        System.out.println(driver.findElement(By.id("checkSubscribeEmail")).isSelected());
        driver.findElement(By.id("checkSubscribeEmail")).click();
        System.out.println(driver.findElement(By.id("checkSubscribeEmail")).isSelected());
    }
}
