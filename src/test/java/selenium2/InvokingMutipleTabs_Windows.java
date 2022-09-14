package selenium2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class InvokingMutipleTabs_Windows {

	@Test
	public void InvokingMutiple() throws InterruptedException, IOException {
		// Invoking Multiple Tabs or Windows and copy text from second tab and paste it
		// in element present first tab

		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		// new tab
		// d.switchTo().newWindow(WindowType.TAB);
		// new window

		d.switchTo().newWindow(WindowType.WINDOW);
		Set<String> tabs = d.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		String parent = it.next();
		String child = it.next();
		d.switchTo().window(child);
		d.get("https://rahulshettyacademy.com");
		String text = d.findElement(By.xpath("//div[@class=\"col-md-6 text-left\"]/h2")).getText();
		System.out.println(text);
		d.switchTo().window(parent);
		WebElement elementName = d.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		elementName.sendKeys(text);

		WebElement elementWithName = d.findElement(By.xpath("//div[@class=\"form-group\"][1]"));
		File src1 = elementName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("elementScreenshot4.png"));

		File src2 = elementWithName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("elementScreenshot5.png"));

		int h = elementName.getRect().getDimension().getHeight();
		int w = elementName.getRect().getDimension().width;

		System.out.println("height is " + h + "\n" + "width is " + w);

		d.quit();
	}

}
