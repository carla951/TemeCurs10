package Curs10HW1;

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

@Test
public class Tema1 {

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
	 public void testWait() throws InterruptedException {
		 WebElement anchor = driver.findElement(By.cssSelector("a[href='life-in-the-garden']"));
		 anchor.click();
		 
		 Thread.sleep(2000);
		 JavascriptExecutor jse = ((JavascriptExecutor) driver);
		 jse.executeScript("scroll(0, 500);");
		 Thread.sleep(3000);
		 
		 driver.findElement(By.id("tab-title-reviews"));
		 WebElement anchor1 = driver.findElement(By.cssSelector("a[href='#tab-reviews']"));
		 anchor1.click();
		 Thread.sleep(2000);
		 
		 WebElement submitButton = driver.findElement(By.id("submit"));
		 submitButton.click();
		 Thread.sleep(2000);
		
		 Alert jsAlert = driver.switchTo().alert();
		 jsAlert.accept();
		 Thread.sleep(2000);
		
 		 WebElement cartButton = driver.findElement(By.className("single_add_to_cart_button"));
		 cartButton.submit();
		 Thread.sleep(6000);
		 	
		 	
		 	
	 }
	
		@AfterClass
		public void tearDown() {
		if(driver != null) {
			driver.quit();
	}
	}
	
}
