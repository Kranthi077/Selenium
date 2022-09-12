package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DatePicker_Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");

		WebDriver d = new ChromeDriver(co);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.manage().window().maximize();
		d.get("https://www.redbus.in/");
		d.findElement(By.id("onward_cal")).click();
		String month = d.findElement(By.className("monthTitle")).getText();
		while (!month.contains("Sept")) {
			Thread.sleep(2000);
			d.findElement(By.className("next")).click();
			Thread.sleep(2000);
			month = d.findElement(By.className("monthTitle")).getText();
		}

		List<WebElement> days = d.findElements(By.className("day"));
		System.out.println(days.size());
		for (int i = 0; i < days.size(); i++) {
			String day = days.get(i).getText();
			if (day.equalsIgnoreCase("5")) {
				Thread.sleep(2000);
				days.get(i).click();
				break;
			}
		}
		d.close();
	}

}
