package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxes_11 {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Boolean checkBoxStatus = d.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();
		Assert.assertFalse(checkBoxStatus);
		d.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		checkBoxStatus = d.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();
		Assert.assertTrue(checkBoxStatus);
		d.close();

	}

}
