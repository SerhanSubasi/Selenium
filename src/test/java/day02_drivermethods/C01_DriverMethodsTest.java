package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodsTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Amazon sayfasina gidelim
        String amazonUrl = "https://www.amazon.com";

        driver.get(amazonUrl);

        //Sayfa başlığını konsola yazdıralım
        String actualTitle = driver.getTitle(); //gidilen sayfanın başlığını verir
        System.out.println("Amazon Sayfasının Başlık Bilgisi = " +actualTitle);

        //Sayfanın Url'ini konsola yazdıralım
        String actualUrl = driver.getCurrentUrl(); //gidilen sayfanın url'ini verir
        System.out.println("Amazon Sayfası Url'i = " + actualUrl);

        //-----------------------------------------------------------------------------------


        //Techproeducation sayfasına gidelim
        String techProUrl = "https://www.techproeducation.com";
        driver.get(techProUrl);

        //Sayfa başlığını konsola yazdıralım
        String TechProTittle = driver.getTitle();
        System.out.println("TechPro Sayfasının Başlık Bilgisi = " + TechProTittle);

        //Sayfanın Url'ini konsola yazdıralım
        String techProEduUrl = driver.getCurrentUrl();
        System.out.println("techProEdu Sayfası Url'i = " + techProEduUrl);


    }
}
