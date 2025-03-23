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

	@Test(priority = 1)
	public void basicSlider() {
		// Actions Class
		Actions act = new Actions(driver);
		WebElement def_slider = driver.findElement(By.xpath(
				"//div[@class='jqm-demos ui-page ui-page-theme-a ui-page-footer-fixed ui-page-active']//div[1]//form[1]//div[1]//div[1]//a[1]"));
		System.out.println("current location :" + def_slider.getLocation()); // X-872,Y-436
		act.dragAndDropBy(def_slider, -700, -400).perform();
		System.out.println("location after moving :" + def_slider.getLocation());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
