package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ödev {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");
        String expectedTitle = "Facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title 'Facebook' içeriyor");
        } else {
            System.out.println("Olması gereken Title: " + driver.getTitle());
        }

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i  yazdirin.
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Sayfa URL'si 'facebook' içeriyor");
        } else {
            System.out.println(actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartExpectedTitle = "Walmart.com";
        String walmartActualTitle = driver.getTitle();

        if (walmartActualTitle.contains(walmartExpectedTitle)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        // Sayfayi yenileyin
        driver.navigate().refresh();
        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // Sayfayi kapatin
        driver.close();


    }
}
