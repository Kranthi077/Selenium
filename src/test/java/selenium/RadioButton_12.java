package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButton_12 {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Boolean checkBoxStatus = d.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		//System.out.println(checkBoxStatus);
		//Assert.assertFalse(checkBoxStatus);
		//System.out.println(d.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		
		System.out.println(d.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled());
		System.out.println(d.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

	}

}
