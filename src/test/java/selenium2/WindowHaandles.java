package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHaandles {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/loginpagePractise/#");
		d.findElement(By.xpath("//a[@target='_blank']")).click();

		Set<String> windows = d.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String Parent = it.next();
		String child = it.next();
		d.switchTo().window(child);
		String text = d.findElement(By.xpath("(//div[@class=\"col-md-8\"]/p)[2]")).getText();
		System.out.println(text);
		String email = d.findElement(By.xpath("(//div[@class=\"col-md-8\"]/p)[2]")).getText().split("at")[1].trim()
				.split(" ")[0];
		System.out.println(email);
		d.switchTo().window(Parent);
		d.findElement(By.name("username")).sendKeys(email);
		d.close();

	}

}
