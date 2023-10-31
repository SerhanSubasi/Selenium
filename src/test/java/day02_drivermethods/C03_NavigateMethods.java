package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Techpro ana sayfasina gidelim . https://www.techproeducation.com/
        String techpro = "https://www.techproeducation.com/";
        driver.navigate().to(techpro);

        //Amazon soyfasina gidelim. https://www.amazon.com/
        String amazon = "https://www.amazon.com/";
        driver.navigate().to(amazon);

        //Tekrar Techpro sayfasina donelim
        driver.navigate().back();

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }
}
