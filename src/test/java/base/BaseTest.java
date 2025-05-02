package base;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentReportsManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import java.util.Properties;
import utils.ConfigReader;


public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory driverFactory;
	 protected static ExtentReports extent;
	 protected ExtentTest test;
	 protected Properties prop;
	
	@BeforeMethod
	public void setup(Method method)
	{
		extent = ExtentReportsManager.getReport();
		driverFactory =new DriverFactory();
		driver = driverFactory.initDriver();
		driver.get("https://www.saucedemo.com/");
		
		//Read properties
		prop = ConfigReader.initProperties();
	    driver.get(prop.getProperty("url"));
		
		// Create test node for reporting
        test = extent.createTest(method.getName());
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable()); // Logs exception if failed
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}
