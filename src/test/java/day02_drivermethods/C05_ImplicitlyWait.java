package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ImplicitlyWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //max 15 saniye yüklenme süresi

        /*
        Bir sayfaya gittiğimizde internetten kaynaklı işlem yapılmak istenen web elementler hemen yüklenmeyebilir.
        Dolayısıyla işlem yapılmak istenen web element henüz oluşmamış ise kodlarımız elementleri bulamaz ve hata alırız.
        Bu nedenle implicitlyWait kullanırız.
         */


//techpro sayfasına gidiniz
       driver.get("https://www.techproeducation.com");

//sayfa başlığının TechPro Education olduğunu test ediniz
        String expectedTitle = "TechPro Education";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle.equals(expectedTitle) ? "TEST PASSED" : "TEST FAILED");

//facebook sayfasına gidiniz
     driver.get("https://facebook.com");

//sayfa url'inin facebook içerdiğini test ediniz

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("facebook")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

//techpro sayfasına geri dönününüz
        driver.navigate().back();

//Geri döndüğünüzü test ediniz
        actualTitle= driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


//sayfayı kapatınız
        driver.close();


    }
}
