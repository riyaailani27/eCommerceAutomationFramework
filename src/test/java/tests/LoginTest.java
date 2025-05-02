package tests;


import org.testng.Assert;
import org.testng.annotations.Test;



import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	LoginPage loginPage;
	
	@Test
	public void testValidLogin()
	{
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

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
	
	@Test
	public void testValidHomePage() {
	    loginPage = new LoginPage(driver);
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	    HomePage homePage = new HomePage(driver);
	    Assert.assertEquals(homePage.getProductsTitle(), "Products", "Login failed: Products page not displayed.");
	    Assert.assertTrue(homePage.isInventoryDisplayed(), "Inventory list is not displayed.");
	}

}
