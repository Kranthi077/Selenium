package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class isEnabledonCalender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		/*
		 * String attributeValue =
		 * d.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("class");
		 * System.out.println(attributeValue);
		 * d.findElement(By.id("ctl00_mainContent_view_date2")).click(); attributeValue
		 * = d.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("class");
		 * System.out.println(attributeValue);
		 */
		d.findElement(By.xpath("//div[@id=\"Div1\"]")).click();
		String attributeValue = d.findElement(By.xpath("//div[@id=\"Div1\"]")).getAttribute("style");
		System.out.println(attributeValue);

		if (attributeValue.contains("1"))
			System.out.println("Return date option is enabled");
		else
			System.out.println("Return date option is dis-abled");
		d.close();
	}

}
