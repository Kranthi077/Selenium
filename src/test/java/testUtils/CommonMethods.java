package testUtils;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	public static void addToCart(WebDriver d, String[] itemsList) {

		List<WebElement> items = d.findElements(By.className("product-name"));
		for (int i = 0; i < items.size(); i++) {
			String actual = items.get(i).getText();
			String[] actualArray = actual.split("-");
			String actual1 = actualArray[0].trim();
			List itemsArrayList = Arrays.asList(itemsList);
			if (itemsArrayList.contains(actual1)) {
				d.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();

			}
		}

	}

}
