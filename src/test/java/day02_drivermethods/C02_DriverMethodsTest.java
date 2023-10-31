package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Amazon sayfasina gidelim. https://www.amazon.com/
        String amazonUrl = "https://www.amazon.com/";
        driver.get(amazonUrl);

        //Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //Sayfa basliginin "Amazon" icerdigini test edin
        if (actualTitle.contains("Amazon")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(3000); //Bu bekleme özelliği javadan gelir, driver ne olursa olsun girilen değer kadar bekler.

        /*
        Test uzmanları Thread.sleep kullanmaktan kaçınmalıdır, çünkü gereksiz beklemelere neden olur.
        */

        //Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();

        //Sayfa url'inin "amazon" icerdigini test edin.
        if (actualUrl.contains("amazon")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        //Sayfa handle degerini yazdirin
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);


        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        String amazonHTML = driver.getPageSource();
        if (amazonHTML.contains("Gateway")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        //Sayfayi kapatin.
        driver.close();

        //driver.quit(); bütün sayfaları kapatır.


    }
}
