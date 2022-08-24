package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Navigate_6 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		//d.get("https://rahulshettyacademy.com/locatorspractice/");
		
		d.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		
		d.findElement(By.xpath("//input[@id=\"inputUsername\"]")).sendKeys("Demo");
		d.findElement(By.xpath("//input[@name=\"inputPassword\"]")).sendKeys("rahulshettyacademy");
		d.findElement(By.xpath("//input[@value=\"rmbrUsername\"]")).click();
		d.findElement(By.xpath("//input[@value=\"agreeTerms\"]")).click();
		d.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(3000);
		String actualValue = d.findElement(By.tagName("p")).getText();
		System.out.println(actualValue);
		
		System.out.println(d.getTitle());
		System.out.println(d.getCurrentUrl());
		
		d.navigate().back();
		Thread.sleep(3000);
		d.navigate().forward();
		Thread.sleep(3000);
		d.navigate().refresh();
		Thread.sleep(3000);
		d.close();
		
		


		
	}

}
