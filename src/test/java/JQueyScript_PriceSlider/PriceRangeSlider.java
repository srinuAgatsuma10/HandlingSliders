package JQueyScript_PriceSlider;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
		
	}
	
	@Test
	public void byUpdatingValues() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
