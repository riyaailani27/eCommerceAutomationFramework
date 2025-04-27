package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory driverFactory;
	
	@BeforeMethod
	public void setup()
	{
		driverFactory =new DriverFactory();
		driver = driverFactory.initDriver();
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		 if (driver != null) {
	            driver.quit();
	        }
	}

}
