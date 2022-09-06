package selenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

public class FrameTest {

	public static void main(String[] args) {

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://jqueryui.com/droppable/");

		// name
		// d.switchTo().frame(name);
		// index
		// d.switchTo().frame(0);
		// webelement
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		Actions a = new Actions(d);

		WebElement Source = d.findElement(By.id("draggable"));
		WebElement Target = d.findElement(By.id("droppable"));

		a.dragAndDrop(Source, Target).build().perform();

		d.switchTo().parentFrame();
		d.findElement(By.xpath("(//li[@class=\"menu-item\"])[1]")).click();

	}

}
