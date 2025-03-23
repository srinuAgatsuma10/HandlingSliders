package demoJQueryMobile;

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
		driver.get("https://demos.jquerymobile.com/1.4.5/slider/");
		driver.manage().window().maximize();
	}

	@Test
	public void basicSlider() {
		Actions act = new Actions(driver); // Actions Class
		WebElement basicSlider = driver.findElement(By.xpath(
				"//div[@class='jqm-demos ui-page ui-page-theme-a ui-page-footer-fixed ui-page-active']//div[1]//form[1]//div[1]//div[1]//a[1]"));
		System.out.println("Current location :" + basicSlider.getLocation()); // X-872,Y-436
		act.dragAndDropBy(basicSlider, -700, -400).perform();
		System.out.println("Location after moving :" + basicSlider.getLocation());
	}

	@Test
	public void stepAttributeSlider() {
		Actions act = new Actions(driver); // Actions Class
		WebElement saSlider = driver
				.findElement(By.xpath("//a[@class=\"ui-slider-handle ui-btn ui-shadow\" and @aria-valuemax=\"10\"]"));
		System.out.println("Current location :" + saSlider.getLocation()); // X->872, Y->689
		act.dragAndDropBy(saSlider, -550, -600);
		System.out.println("Location after moving :" + saSlider.getLocation());
	}

	@Test
	public void highlightSlider() {
		Actions act = new Actions(driver); // Actions Class
		WebElement hilghtSlider = driver
				.findElement(By.xpath("//a[@class=\"ui-slider-handle ui-btn ui-shadow\" and @aria-valuemax=\"10\"]"));
		System.out.println("Current location :" + hilghtSlider.getLocation()); // X->872, Y->689
		act.dragAndDropBy(hilghtSlider, 872, -600);
		System.out.println("Location after moving :" + hilghtSlider.getLocation());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
