package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //arama kutusunun tag name'inin input olduğunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName ="input";

        if (actualTagName.equals(expectedTagName)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //arama kutusunun class attribütunun değerinin form-input olduğunu test ediniz
        String actualAtt = aramaKutusu.getAttribute("class");
        String expectedAtt = "form-input";
        if (actualAtt.equals(expectedAtt)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(3000);

        //sayfayı kapatınız
        driver.close();

    }
}
