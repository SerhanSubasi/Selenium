package day05_xpath_cssselector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
/*
        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        WebElement singInButton = driver.findElement(By.cssSelector("button[type='button']"));
        singInButton.click();

        //Login alanine  "username" yazdirin
        WebElement loginButton = driver.findElement(By.cssSelector("input[name='user_login']"));
        loginButton.click();
        loginButton.sendKeys("username");

        //Password alanine "password" yazdirin
        WebElement passwordButton = driver.findElement(By.cssSelector("input[name='user_password']"));
        passwordButton.click();
        passwordButton.sendKeys("password");


        //Sign in buttonuna tiklayin
        WebElement SignInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        singInButton.click();
        driver.navigate().back(); //sayfadaki oluşan güvenlik uyarısını aşmak için back kullandık.

        //Online Banking altındaki Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();
        WebElement payBills = driver.findElement(By.xpath("//span[text()='Pay Bills']"));

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountButton = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountButton.click();
        amountButton.sendKeys("50");

        //tarih kismina "2020-09-10" yazdirin
        WebElement dateButton = driver.findElement(By.xpath("//input[@name='date']"));
        WebElement bir =    driver.findElement(By.xpath("//a[@class='ui-state-default']"));
        bir.sendKeys("2023-11-23");

        //Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //"The payment was successfully submitted." mesajinin ciktigini control edin
        //sayfayı kapatınız
*/

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();

        //Login alanine  "username" yazdirin
        //Password alanine "password" yazdirin
        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB , "password", Keys.ENTER );
        Thread.sleep(3000);
        driver.navigate().back();//sayfadaki olusan güvenlik uyarisini asmak icin back kullandik

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Pay Bills']")).click();
        Thread.sleep(2000);


        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina "2020-09-10" yazdirin
        //Pay buttonuna tiklayin
        WebElement amount =driver.findElement(By.cssSelector("input[name='amount']"));
        amount.sendKeys("500" , Keys.TAB ,"2020-09-10", Keys.TAB , Keys.TAB );
        Thread.sleep(3000);
        amount.sendKeys(Keys.ENTER);

        //"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement message= driver.findElement(By.xpath("(//span)[1]"));
        String actualSuccesMessage = message.getText();
        String expectedSuccesMessage="The payment was successfully submitted.";
        if(actualSuccesMessage.equals(expectedSuccesMessage)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        //sayfayı kapatınız
        driver.close();

    }
}
