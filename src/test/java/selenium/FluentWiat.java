package selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWiat {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().window().maximize();
		d.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		d.findElement(By.xpath("//div[@id=\"start\"]/button")).click();

		FluentWait wait = new FluentWait(d);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(3));
		wait.ignoring(NoSuchElementException.class);

		WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver d) {
				if (d.findElement(By.xpath("//div[@id=\"finish\"]/h4")).isDisplayed())
					return d.findElement(By.xpath("//div[@id=\"finish\"]/h4"));
				else
					return null;
			}
		});

		System.out.println(foo.isDisplayed());
		System.out.println(foo.getText());
		d.close();
	}

}
