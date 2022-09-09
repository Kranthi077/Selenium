package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollBy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		List<WebElement> table = d.findElements(By.xpath("(//table)[2]/descendant::td"));

		int sum = 0;
		System.out.print("digit");
		System.out.print("---");
		System.out.println("sum");
		for (int i = 0; i < table.size(); i++) {

			if (((i + 1) % 4) == 0) {
				String col4 = table.get(i).getText();
				int digit = Integer.parseInt(col4);
				sum = sum + digit;
				System.out.print(digit);
				System.out.print("---");
				System.out.println(sum);
			}
		}

		String actual = d.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		int actualSum = Integer.parseInt(actual);
		Assert.assertEquals(actualSum, sum);

	}

}
