package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/loginpagePractise/#");
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[@target='_blank']")).click();
		Set<String> windows = d.getWindowHandles();
		Iterator<String> it = windows.iterator();
		System.out.println(windows);
		System.out.println(it);
		String parent = it.next();
		String child = it.next();
		d.switchTo().window(child);
		Thread.sleep(2000);
		System.out.println(d.findElement(By.xpath("(//div[@class=\"col-md-8\"]/p)[2]")).getText());
		Thread.sleep(2000);
		String text = d.findElement(By.xpath("(//div[@class=\"col-md-8\"]/p)[2]")).getText();
		String email = d.findElement(By.xpath("(//div[@class=\"col-md-8\"]/p)[2]")).getText().split(" ")[4];
		d.switchTo().window(parent);	
		Thread.sleep(2000);
		d.findElement(By.name("username")).sendKeys(email);
		Thread.sleep(2000);
		d.quit();
		

		

	}

}
