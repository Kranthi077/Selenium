package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {

		// To disable notification
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		// It will create an object for Chrome driver().
		WebDriver d = new ChromeDriver(co);
		// It will tell system where your diver is located
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Aishwarya Jangampeta/Kranthi/eclipse-workspace/Selenium/chromedriver.exe");
		d.manage().window().maximize();
		d.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[1]")).sendKeys("Agra (AGR)");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).clear();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).sendKeys("Ahmedabad (AMD)");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript(
				"document.getElementsByClassName(\"css-76zvg2 css-bfa6kz r-homxoj r-ubezar\")[0].innerText='Thu, 15 Dec 2022';");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Return Date']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Return Date']")).click();
		js.executeScript(
				"document.getElementsByClassName(\"css-76zvg2 css-bfa6kz r-homxoj r-ubezar\")[1].innerText='Thu, 22 Dec 2022';");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Search Flight']")).click();
		Thread.sleep(5000);
		d.close();

	}

}
