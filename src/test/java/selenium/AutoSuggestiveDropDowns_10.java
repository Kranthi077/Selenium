package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDowns_10 {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		d.findElement(By.className("inputs")).sendKeys("in");

		List<WebElement> results = d.findElements(By.xpath("//a[@class=\"ui-corner-all\"]"));
		for (int i = 0; i < results.size(); i++) {
			String option = results.get(i).getText();
			if (option.equalsIgnoreCase("India")) {
				results.get(i).click();
				break;
			}

		}
		d.close();
	}

}
