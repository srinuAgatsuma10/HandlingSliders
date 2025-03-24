package demoJQueryMobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class HandlingRangeSlider {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demos.jquerymobile.com/1.4.5/rangeslider/");
		driver.manage().window().maximize();
	}

	@Test
	public void basicSlider() {
		System.out.println("----Basic Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement min_slider = driver.findElement(By.xpath("//a[@title='40']"));
		System.out.println("Current location :" + min_slider.getLocation()); // X->768,Y->407
		act.dragAndDropBy(min_slider, -75, -407).perform();
		System.out.println("Location after moving :" + min_slider.getLocation());

		WebElement max_slider = driver.findElement(By.xpath("//div[1]//form[1]//div[1]//div[1]//div[2]//a[2]"));
		System.out.println("Current location :" + max_slider.getLocation()); // X->1077,Y->407
		act.dragAndDropBy(max_slider, -350, -407).perform();
		System.out.println("Location after moving :" + max_slider.getLocation());

	}

	@Test
	public void stepAttributeSlider() {
		System.out.println("----Step Attribute Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement min_slider = driver.findElement(By.xpath("//a[@title='2.6']"));
		System.out.println("Current location :" + min_slider.getLocation()); // X->614,Y->912
		act.dragAndDropBy(min_slider, -150, -200).perform();
		System.out.println("Location after moving :" + min_slider.getLocation());

		WebElement max_slider = driver.findElement(By.xpath("//a[@title='5.4']"));
		System.out.println("Current location :" + max_slider.getLocation()); // X->1077,Y->912
		act.dragAndDropBy(max_slider, -450, -250).perform();
		System.out.println("Location after moving :" + max_slider.getLocation());
	}

	@Test
	public void no_highlightSlider() {
		System.out.println("----No Highlight Slider----");
		Actions act = new Actions(driver); // Actions Class
		WebElement min_slider = driver.findElement(By
				.xpath("//div[@class='ui-slider-track ui-shadow-inset ui-bar-inherit ui-corner-all']//a[@title='20']"));
		System.out.println("Current location :" + min_slider.getLocation()); // X->660,Y->660
		act.dragAndDropBy(min_slider, -100, -250).perform();
		System.out.println("Location after moving :" + min_slider.getLocation());

		WebElement max_slider = driver.findElement(By.xpath("//div[@data-highlight='false']//a[@title='80']"));
		System.out.println("Current location :" + max_slider.getLocation()); // X->876,Y->660
		act.dragAndDropBy(max_slider, -420, -150).perform();
		System.out.println("Location after moving :" + max_slider.getLocation());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
