package day04_WebElements_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {
    public static void main(String[] args) throws InterruptedException {

         /*

        XPath
        => / bu direkt bir çocuğu seçer
        /html/body
        => // bu da öncekilerin hepsini atlar ve istediğimizden başlatır.
        //div

        => @ bir web elementin attribute'unu seçmek için kullanılır.
        //input[@name='field-keywords']

        => [] koşullar veya index belirtmek için kullanılır.
        //input [2]

        => * Hepsini seçer, all demektir.

            SYNTAX
            //tagname[@attributeName='attributeText']

            //*[@*='attributeText']
            -> eğer bu kullanımda birden fazla sonuc verirse * koyduğumuz yerlere tagname ve attributename'i belirtebiliriz.
            -> buna rağmen birden fazla sonuc verirse  (//tagname[@attributeName='attributeText']) [index] gireriz.
          */



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://amazon.com ");

        //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike");
        aramaKutusu.submit();

        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
         WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
            System.out.println(aramaSonucu.getText());

        //Sadece sonuc sayısını yazdırınız
        String [] sonucSayisi = aramaSonucu.getText().split(" "); //String array oldu
        System.out.println("sonucSayisi = " + sonucSayisi[2]);

        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
         driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

         /*
         => xpath alırken direkt tagları kullanarak unique sonuc vermezse, yukarıda yaptığımız gibi index ile locate edebiliriz.
         önemli olan unique elde etmektir.
          */


        //sayfayi kapatınız
        driver.close();


    }
}
