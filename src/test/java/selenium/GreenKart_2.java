package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(5000);
		List<WebElement> items = d.findElements(By.className("product-name"));
		System.out.println(items.size());
		// String item = "Beetroot";
		String[] itemsList = { "Cucumber", "Beetroot", "Banana", "Almonds" };

		for (int i = 0; i < items.size(); i++) {
			String actual = items.get(i).getText();
			String[] actualArray = actual.split("-");
			String actual1 = actualArray[0].trim();
			List itemsArrayList = Arrays.asList(itemsList);
			if (itemsArrayList.contains(actual1)) {
				d.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				Thread.sleep(3000);
				System.out.println(actual);
				System.out.println(actual1);
				System.out.println(itemsArrayList);
				Thread.sleep(10000);
			}
		}
		d.close();
	}

}
