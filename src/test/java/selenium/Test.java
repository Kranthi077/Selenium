package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		// To disable notification
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		WebDriver d = new ChromeDriver(co);
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Aishwarya Jangampeta/Kranthi/eclipse-workspace/Selenium/chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://www.spicejet.com/");
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[1]")).clear();
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[1]")).sendKeys("Agra (AGR)");
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).clear();
		d.findElement(By.xpath("(//input[@autocapitalize=\"sentences\"])[2]")).click();
		d.findElement(By.xpath("//div[text()='Sardar Vallabhbhai Patel International Airport']")).click();

		WebElement fromDate = d.findElement(By.xpath("//div[@data-testid=\"departure-date-dropdown-label-test-id\"]"));
		SelectDateByJS(d, fromDate, "Mon, 15 Aug 2023");	
		Thread.sleep(5000);
		// d.close();
	}

	public static void SelectDateByJS(WebDriver driver, WebElement element, String date) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
		js.executeScript("arguments[0].value='" + date + "'", element);

	}

}
