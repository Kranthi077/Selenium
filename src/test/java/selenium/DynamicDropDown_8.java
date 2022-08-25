package selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown_8 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Thread.sleep(5000);
		d.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(2000);
		d.findElement(By.xpath("//a[@value=\"IXG\"]")).click();
		//Thread.sleep(2000);
		d.findElement(By.xpath("(//a[@value=\"HYD\"])[2]")).click();
		d.close();
	}
}
