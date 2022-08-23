package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DynamicPassword {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		WebDriver d = new ChromeDriver(co);
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Aishwarya Jangampeta/Kranthi/eclipse-workspace/Selenium/chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/locatorspractice/");
		d.findElement(By.className("forgot-pwd-container")).click();
		Thread.sleep(2000);
		d.findElement(By.className("reset-pwd-btn")).click();
		String passwordMessage = d.findElement(By.tagName("p")).getText();
		//System.out.println(passwordMessage);
		String[] passwordArray = passwordMessage.split("'");
		String password = passwordArray[1];
		d.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@id=\"inputUsername\"]")).sendKeys("Demo");
		d.findElement(By.xpath("//input[@name=\"inputPassword\"]")).sendKeys(password);
		d.findElement(By.xpath("//input[@value=\"rmbrUsername\"]")).click();
		d.findElement(By.xpath("//input[@value=\"agreeTerms\"]")).click();
		d.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(3000);
		String actualValue = d.findElement(By.tagName("p")).getText();
		//System.out.println(actualValue);
		Assert.assertEquals(actualValue, "You are successfully logged in.");
		d.close();
	}

}
