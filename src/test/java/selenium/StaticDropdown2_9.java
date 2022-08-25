package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticDropdown2_9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/dropdownsPractise/");
		d.findElement(By.id("divpaxinfo")).click();
		
		int i =0;
		while(i<4)
		{
			d.findElement(By.id("hrefIncAdt")).click();	
			i++;
		}
		
		/*
		 * for(int i=0 ; i<4; i++) { d.findElement(By.id("hrefIncAdt")).click(); }
		 */
		
/*		d.findElement(By.id("hrefIncAdt")).click();
		d.findElement(By.id("hrefIncAdt")).click();
		d.findElement(By.id("hrefIncAdt")).click();
		d.findElement(By.id("hrefIncAdt")).click();
		*/
		d.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(d.findElement(By.id("divpaxinfo")).getText());
		d.quit();
		
	}

}
