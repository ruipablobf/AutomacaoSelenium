package br.com.vivo.primeiraAutomacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CartTests {
        @Test
        public void testCreateCart(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Acessa o site
            driver.get("https://store.vivo.com.br/");
            //Clicar no botão "Continuar e fechar"
            driver.findElement(By.xpath("//button[@id='consent']")).click();
            //clicar no menu celulares
            driver.findElement(By.xpath("//a[@title='Celulares']")).click();
            //clica no produto
            driver.findElement(By.xpath("(//a[@class='product-card product-card--grid'])[1]")).click();




            // driver.quit(); //Encerra o processo de chromeDriver no windows
        }
}
