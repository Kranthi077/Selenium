package selenium;

import java.time.Duration;
import testUtils.CommonMethods;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsList = { "Cucumber", "Beetroot", "Banana", "Almonds", "Pista", "Walnuts" };
		CommonMethods.addToCart(d, itemsList);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Cart']")));	
		d.findElement(By.xpath("//img[@alt='Cart']")).click();
		d.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		d.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		d.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(d.findElement(By.className("promoInfo")).getText());
		d.close();
	}

}
