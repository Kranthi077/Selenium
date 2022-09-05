package selenium2;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://www.amazon.in/");

		WebElement sign = d.findElement(By.xpath("//a[@data-csa-c-content-id=\"nav_ya_signin\"]"));

		Actions a = new Actions(d);
		// mouse hover
		// a.moveToElement(sign).build().perform();

		String text = d.findElement(By.xpath("(//div[@id=\"nav-xshop\"]/a)[1]")).getText();

		// Enter capital letters
		WebElement searchBar = d.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(text).build().perform();

		// Double click
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(text).doubleClick().build().perform();

		a.moveToElement(sign).contextClick().build().perform();

		d.close();

	}
}
