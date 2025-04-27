package tests;


import org.testng.Assert;
import org.testng.annotations.Test;



import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	LoginPage loginPage;
	
	@Test
	public void testValidLogin()
	{
		loginPage = new LoginPage(driver);
		 loginPage.login("standard_user", "secret_sauce");

	        // After login, we can check URL or page title to confirm successful login
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertTrue(currentUrl.contains("inventory"), "Login failed: Inventory page not loaded.");
	    
		
	}
	
	@Test
    public void testInvalidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "invalid_pass");

        // Checking if error message is displayed
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"), "Expected error message not found.");
    }

}
