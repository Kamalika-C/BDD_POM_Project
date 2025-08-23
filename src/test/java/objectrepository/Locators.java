package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	//login page locators
	public static By username=By.id("user-name");
	public static By password=By.id("password");
	public static By loginButton=By.id("login-button");
	
	//select product locator
	public static By product=By.id("item_4_title_link");
	
	//add to cart locator
	public static By addtocartButton=By.id("add-to-cart");
	public static By cartButton=By.id("shopping_cart_container");
	
	//checkout locator
	public static By checkoutButton=By.id("checkout");
	
	//customer details
	public static By firstname=By.id("first-name");
	public static By lastname=By.id("last-name");
	public static By postalcode=By.id("postal-code");
	public static By continueButton=By.id("continue");
	
	//Overview locator
	public static By finishButton=By.id("finish");
	
	//logout locator
	public static By menuButton=By.id("react-burger-menu-btn");
	public static By logoutButton=By.id("logout_sidebar_link");
	
	
}
