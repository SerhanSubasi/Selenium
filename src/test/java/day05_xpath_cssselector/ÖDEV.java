package day05_xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ÖDEV {
    public static void main(String[] args) throws InterruptedException {


        /*
ÖDEV:
https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
Add Element butonuna basin 100 kez basınız
Delete butonuna 90 kez basınız
Ve 90 kez basıldığını doğrulayınız
*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna basin 100 kez basınız
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i <= 100 ; i++) {
            addElementButton.click();
        }
        Thread.sleep(2000);


        // Delete butonuna 90 kez basınız
        int sayac = 0;
        for (int i = 0; i < 90 ; i++) {
            WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
            deleteButton.click();
            sayac++;
        }

        // Ve 90 kez basıldığını doğrulayınız

       if (sayac==90) {
           System.out.println("TEST PASSED");
       } else {
           System.out.println("TEST FAILED");
       }

       driver.close();


    }
}
