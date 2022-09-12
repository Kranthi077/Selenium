package selenium2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		
		// Screenshot code
		
		TakesScreenshot screenshot = (TakesScreenshot) d;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("AmazonHomePage.png");
		FileUtils.copyFile(source, destination);
		
	}

}
