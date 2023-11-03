package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://testcenter.techproeducation.com/index.php adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php");

        // "Back to TechProEducation.com" butonunun kullanici erisimi icin etkin olup olmadigini test edin
        WebElement backToButton = driver.findElement(By.partialLinkText("Back to TechProEducation.com"));
        System.out.println(backToButton.isEnabled() ? "TEST PASSED" : "TEST FAILED");

        // "Applications lists" basligini tagname ile locate ederek görünür  olup olmadigini test ediniz
        WebElement applicationsLists =  driver.findElement(By.tagName("h1"));
        if (applicationsLists.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        
    }
}
