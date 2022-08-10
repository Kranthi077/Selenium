package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {


		// To disable notification
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		
		// It will create an object for Chrome driver().
		WebDriver d = new ChromeDriver(co);
		//It will tell system where your diver is located
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Aishwarya Jangampeta/Kranthi/eclipse-workspace/Selenium/chromedriver.exe");
		
		
		d.manage().window().maximize();
		d.get("https://www.spicejet.com/");
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[1]")).sendKeys("Agra (AGR)");
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).clear();
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).sendKeys("Belagavi (IXG)");
		d.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(5000);
		d.close();
		
		
	}

}
