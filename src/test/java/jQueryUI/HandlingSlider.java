package jQueryUI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingSlider {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
	}

	@Test
	public void handlingSlider() throws Exception{
		// Action Class
		Actions ac = new Actions(driver);
		WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(demoFrame);
		WebElement sliderPionter = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		System.out.println("Current slider location : "+sliderPionter.getLocation());
		ac.dragAndDropBy(sliderPionter, 500, 3);
		Thread.sleep(3000);
		System.out.println("Location after moving : "+sliderPionter.getLocation());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
