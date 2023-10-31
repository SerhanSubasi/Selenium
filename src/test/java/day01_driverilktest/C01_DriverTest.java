package day01_driverilktest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_DriverTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://google.com");


/*
WebDriverManager sayesinde istediğimiz browsera rahatlıkla setup yaparak otomasyonda kullanabiliriz.
Bu sayede gerekli olan browserı bilgisayarımıza indirmek, yapılandırmak... zorunda kalmayız.
 */


    }
}
