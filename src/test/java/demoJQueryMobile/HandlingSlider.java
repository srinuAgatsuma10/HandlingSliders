package demoJQueryMobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

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
		System.out.println("----Basic Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement basic_slider = driver.findElement(By.xpath(
				"//div[@class='jqm-demos ui-page ui-page-theme-a ui-page-footer-fixed ui-page-active']//div[1]//form[1]//div[1]//div[1]//a[1]"));
		System.out.println("Current location :" + basic_slider.getLocation()); // X->768,Y->436
		act.dragAndDropBy(basic_slider, -75, -436).perform();
		System.out.println("Location after moving :" + basic_slider.getLocation());

	}

	@Test
	public void stepAttributeSlider() {
		System.out.println("----Step Attribute Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement sat_slider = driver.findElement(By.xpath("//a[@title='5']"));
		System.out.println("Current location :" + sat_slider.getLocation()); // X->872,Y->941
		act.dragAndDropBy(sat_slider, -220, -300).perform();
		System.out.println("Location after moving :" + sat_slider.getLocation());

	}

	@Test
	public void highlightSlider() {
		System.out.println("----Highlight Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement hilght_slider = driver.findElement(By.xpath("//div[5]//form[1]//div[1]//div[1]//a[1]"));
		System.out.println("Current location :" + hilght_slider.getLocation()); // X->872,Y->689
		act.dragAndDropBy(hilght_slider, -100, -250).perform();
		System.out.println("Location after moving :" + hilght_slider.getLocation());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
