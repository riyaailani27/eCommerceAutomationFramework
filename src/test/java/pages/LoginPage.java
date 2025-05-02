package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {
	
	private WebDriver driver;
	WaitUtils wait;
	
	//1. Locators
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("h3[data-test='error']");
	
	
	//2.Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WaitUtils(driver);
	}
	
	//3. Page Actions
	public void enterUsername(String username)
	{
		wait.waitForElementVisible(usernameField, 10).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		wait.waitForElementVisible(passwordField, 10).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Full login flow
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
	
	

}
