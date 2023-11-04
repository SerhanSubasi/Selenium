package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ÖDEV {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin ve  cookies uyarisi cikarsa kabul ederek kapatin
        driver.get("https://google.com");

        //  Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // Arama cubuguna “Selenium” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium");
        aramaKutusu.submit();

        // Bulunan sonuc sayisini yazdirin
        WebElement sonuclar = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String [] sonucSayisi = sonuclar.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[1]);

        // Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String noktasiz = sonucSayisi[1].replaceAll("\\.","");
        int sonuclarinSayiHali = Integer.parseInt(noktasiz);
        int expectedSayi = 10000000;

        if (sonuclarinSayiHali>expectedSayi) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // Sayfayı kapatın
        driver.close();
    }
}
