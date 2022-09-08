package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		d.manage().window().maximize();
		d.get("http://qaclickacademy.com/practice.php");
		// 1st
		System.out.println(d.findElements(By.tagName("a")).size());

		// 2nd
		WebElement footer = d.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// 3rd
		WebElement column1 = d.findElement(By.xpath("(//table[@class='gf-t']/descendant::td/ul)[1]"));
		System.out.println(column1.findElements(By.tagName("a")).size());
		List<WebElement> elements = column1.findElements(By.tagName("a"));

		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
			Thread.sleep(5000);
		}

		Set<String> windows = d.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			d.switchTo().window(it.next());
			System.out.println(d.getTitle());
		}

		d.close();

	}

}
