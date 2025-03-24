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

	@Test(priority = 1)
	public void priceRangeSlider() {
		Actions act = new Actions(driver); // Actions Class
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Min_Slider Current location : " + min_slider.getLocation()); // X->59,Y->250
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Max_Slider Current location : " + max_slider.getLocation()); // X->546,Y->250

		act.dragAndDropBy(min_slider, 175, 250); // Moving Min_Slider
		act.dragAndDropBy(max_slider, -220, 250); // Moving Max_Slider

		System.out.println("Min_Slider location after moving : " + min_slider.getLocation());
		System.out.println("Max_Slider location adter moving : " + max_slider.getLocation());

		driver.findElement(By.xpath("//button[@id='price-range-submit']")).click();
		WebElement result_text = driver.findElement(By.xpath("//div[@id='searchResults']"));
		System.out.println(result_text.getText());
	}

	@Test(priority = 2)
	public void byUpdatingValues() {
		WebElement min_price = driver.findElement(By.xpath("//input[@id='min_price']"));
		WebElement max_price = driver.findElement(By.xpath("//input[@id='max_price']"));
		if (min_price.isEnabled() && max_price.isEnabled()) {
			min_price.clear();
			max_price.clear();
			min_price.sendKeys("2500");
			max_price.sendKeys("8000");
		}
		driver.findElement(By.xpath("//button[@id='price-range-submit']")).click();
		WebElement result_text = driver.findElement(By.xpath("//div[@id='searchResults']"));
		System.out.println(result_text.getText());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
