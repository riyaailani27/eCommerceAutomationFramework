package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	//Locators
	 private By productsTitle = By.className("title");
	 private By inventoryList = By.className("inventory_list");
	 
	 //Constructor
	 public HomePage (WebDriver driver)
	 {
		 this.driver = driver;
	 }
	 
	 //Actions
	 
	 public String getProductsTitle()
	 {
		 return driver.findElement(productsTitle).getText();
	 }
	 
	 public boolean isInventoryDisplayed()
	 {
		 return driver.findElement(inventoryList).isDisplayed();
	 }
	

}
