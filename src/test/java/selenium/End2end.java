package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class End2end {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		d.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		d.findElement(By.xpath("//a[@value=\"IXG\"]")).click();
		
		d.findElement(By.xpath("(//a[@value=\"HYD\"])[2]")).click();
		
		d.findElement(By.className("ui-datepicker-today")).click();

		d.findElement(By.id("divpaxinfo")).click();

		int i = 0;
		while (i < 4) {
			d.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		d.findElement(By.id("btnclosepaxoption")).click();

		WebElement staticDd = d.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dd = new Select(staticDd);
		dd.selectByIndex(3);
		System.out.println(dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		dd.selectByValue("AED");
		System.out.println(dd.getFirstSelectedOption().getText());
		d.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
