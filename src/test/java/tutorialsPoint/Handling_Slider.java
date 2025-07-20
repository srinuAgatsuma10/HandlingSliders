package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handling_Slider {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void handlingSlider()throws Exception {
		Actions act = new Actions(driver); // Actions Class
		WebElement slidePointer = driver.findElement(By.xpath("//input[@id='ageInputId']"));
		System.out.println("Current location :" + slidePointer.getLocation()); // X->525,Y->198
		act.dragAndDropBy(slidePointer, -200, -100).perform();
		Thread.sleep(3000);
		System.out.println("Location after moving :" + slidePointer.getLocation());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
