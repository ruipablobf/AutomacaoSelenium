package br.com.vivo.primeiraAutomacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTests {

        private WebDriver driver;

        @Before
        public void start() {}

        @Test
        public void testCreateCart(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Acessa o site
            driver.get("https://store.vivo.com.br/");
            //Clicar no botão "Continuar e fechar"
            driver.findElement(By.xpath("//button[@id='consent']")).click();
            //clicar no menu celulares
            driver.findElement(By.xpath("//a[@title='Celulares']")).click();
            //clica no produto

            driver.findElement(By.xpath("(//a[@class='product-card product-card--grid'])[2]")).click();

            //captura o preço do produto
            String precoProduto = driver.findElement(By.xpath("(//div[@aria-label='new item price']//p[contains(text(),'R$')])[1]")).getText();
            System.out.println("Preço do produto: " + precoProduto);

            //clicar no botão colocar no carrinho
            driver.findElement(By.xpath("//span[normalize-space()='Colocar no carrinho']")).click();

            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));

            WebElement itemNoCarrinho = espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item-description']")));

            assertTrue("O produto deve estar visível no carrinho", itemNoCarrinho.isDisplayed());

            //captura o preço do produto no carrinho
            String precoProdutoCarrinho = driver.findElement(By.xpath("//div[@id='total-value']")).getText();
            System.out.println("Valor total carrinho: " + precoProdutoCarrinho);

            assertEquals("O valor total do carrinho deve ser igual ao preço do produto", precoProdutoCarrinho, precoProduto);

        }
        @Test
        public void abrirGoogle(){
            driver.get("https://google.com/");
        }

        @After
        public void quitDriver(){
            driver.quit();
        }
}
