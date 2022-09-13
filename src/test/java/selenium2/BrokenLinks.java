package selenium2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// Finding out broken links in a webpage

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		//softAssert
		SoftAssert sa = new SoftAssert();
		List<WebElement> footerLinks = d.findElements(By.xpath("//div[@id=\"gf-BIG\"]/table/descendant::a"));
		for (int i = 0; i < footerLinks.size(); i++) {

			String url = footerLinks.get(i).getAttribute("href");

			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();

			/*
			 * if (respCode > 400) { System.out.println(url); System.out.println(respCode);
			 * 
			 * }
			 */
			// is called as hard assert
			sa.assertTrue(respCode < 400, "Link is broken = " + url + " because of response code = " + respCode);
			System.out.println(url);
		}
		d.close();
		sa.assertAll();
	}

}
