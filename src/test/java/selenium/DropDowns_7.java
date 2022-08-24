package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns_7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(5000);
		WebElement staticDd = d.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dd = new Select(staticDd);
		dd.selectByIndex(3);
		System.out.println(dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		dd.selectByValue("AED");
		System.out.println(dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		dd.selectByVisibleText("Select");
		System.out.println(dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		d.close();

	}

}
