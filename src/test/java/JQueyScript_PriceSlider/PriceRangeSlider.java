package JQueyScript_PriceSlider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriceRangeSlider {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
	}

	@Test
	public void priceRangeSlider() {
		Actions act = new Actions(driver); // Actions Class
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Min_Slider Current location : " + min_slider.getLocation()); // X->59,Y->250
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Max_Slider Current location : " + max_slider.getLocation()); // X->546,Y->250

		act.dragAndDropBy(min_slider, 175, 250); // Moving Min_Slider
		act.dragAndDropBy(max_slider, -220, 250); // Moving Max_Slider

		System.out.println("Min_Slider Current location after moving : " + min_slider.getLocation());
		System.out.println("Max_Slider Current location adter moving : " + max_slider.getLocation());
	}

	@Test
	public void byUpdatingValues() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
