package Curs10HW1;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Curs10HW2 {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.get("https://keybooks.ro/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		


		
	}
	
	@Test
	public void Test() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='About']")).click();
		
		WebElement anchor = driver.findElement(By.cssSelector("a[href='/margaret-robins/']"));
		anchor.click();
		Thread.sleep(4000);
		
		String result = driver.findElement(By.className("sc_skills_total")).getText();
		
		assertEquals(result, "95%");
	}
	
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}

	}
}
