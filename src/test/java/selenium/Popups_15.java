package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups_15 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@value='Alert']")).click();
		Thread.sleep(3000);
		System.out.println(d.switchTo().alert().getText());
		d.switchTo().alert().accept();

		d.findElement(By.xpath("//input[@value='Confirm']")).click();
		Thread.sleep(3000);
		System.out.println(d.switchTo().alert().getText());
		d.switchTo().alert().dismiss();

	}

}
