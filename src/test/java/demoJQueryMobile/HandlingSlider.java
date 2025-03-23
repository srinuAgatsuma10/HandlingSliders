package demoJQueryMobile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingSlider {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("");
		driver.manage().window().maximize();
	}
	
	@Test
	public void handlingSlider() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
