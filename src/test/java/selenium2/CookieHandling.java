package selenium2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(10000);
		Set<Cookie> cooks = d.manage().getCookies();
		System.out.println("size is" + cooks.size());
		for (Cookie cookie : cooks) {
			System.out.println(cookie.getValue());
		}
		
		
		d.manage().deleteAllCookies();
		System.out.println("size is" +d.manage().getCookies().size());
		d.manage().deleteCookieNamed("262-4101273-5488159");
		d.close();
	}
}
