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
		
		TakesScreenshot screenshot = (TakesScreenshot) d; // we have to typecast driver object to TakesScreenshot type
		File source = screenshot.getScreenshotAs(OutputType.FILE);// with the help of getScreenshotAs method available in TakesScreenshot, we can screen shot in the form of FILE type
		File destination = new File("AmazonHomePage.png");// we will create a destination file of type .png or .jpg
		FileUtils.copyFile(source, destination); // we will paste source to destination using file utils from apache.com.io
		d.quit();
		
	}

}
