package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        WebElement nameBox = driver.findElement(By.name("q"));
        nameBox.sendKeys("selenium");

        // Aramayı yapalim
        nameBox.submit();

        //Başlığın selenium içerdiğini test edelim
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("selenium")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("linklerin sayisi = " + links.size());

        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        for (WebElement w : links) {
            if (!w.getText().isEmpty()) {  //artık string oldu ve isEmpty kullanılabilir
                System.out.println(w.getText());
            }

        }


        //sayfayı kapatalım
        driver.close();

        /*
        Eğer birden fazla webelemnti locate etmek istiyorsak, findElements methodu kullanırız. Bu method bize elemanları
        WebElement olan bir list return eder.

        Bir WebElement'e sahip yazıyı alabilmek için getText() methodunu kullanırız.
         */

    }
}
