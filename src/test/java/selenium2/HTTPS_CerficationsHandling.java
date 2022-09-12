package selenium2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPS_CerficationsHandling {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver d = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://expired.badssl.com");
		System.out.println(d.getTitle());
		d.close();
		
	}

}
