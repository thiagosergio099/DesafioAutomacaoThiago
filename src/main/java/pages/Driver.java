package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SILVANA\\Desktop\\chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");


        WebElement BotaoSignIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        BotaoSignIn.click();

        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        element.click();
        WebElement LoginEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        LoginEmail.sendKeys("thiagosergio099@gmail.com");

        WebElement LoginPwd = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        LoginPwd.sendKeys("thiago123");



        WebElement botaoSubmit = driver.findElement(By.xpath("//*[@id='SubmitLogin']/span"));
        botaoSubmit.click();


        WebElement resultadoPesquisa = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
        String resultado = resultadoPesquisa.getText();
        resultado = resultado.toLowerCase();

        if (resultado.equals("my account")) {
            System.out.println("Sucesso");
        } else {
            System.out.println("Email ou senha incorreto");
            System.out.println("O resultado foi: " + resultado);
        }


        driver.close();
    }

}