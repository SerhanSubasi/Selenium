package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

/*
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"); //yazı yazdırır
        aramaKutusu.submit();   //enter tuşuna basar

        //sayfayı kapatınız
        driver.close();
*/

        /*
        // 2. YOL -WebElement kutusuna koymadan
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //sayfayı kapatınız
        driver.close();
          */
/*
Locate ettiğimiz WebElement <input> tagına sahipse, o WebElement'e sendKeys mehtodu ile istediğimiz texti gönderebiliriz.
Eğer bir arama kutusunu locate edip text gönderirsek bunu iki şekilde enter yaptırabiliriz.
1) submit() methodu
2) Keys.ENTER
 */

//3. YOL Name ile alma
        driver.get("https://amazon.com");
        WebElement name = driver.findElement(By.name("field-keywords"));
        name.sendKeys("iphone");
        name.submit();
        driver.close();

    }
}
