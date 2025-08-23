package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AddToCart;
import pages.CheckOutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;

public class PlaceOrderDef {
	
	WebDriver driver=Hooks.driver;
	ExtentTest extTest=Hooks.extTest;
	
	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCart addToCart;
	CheckOutPage checkOut;
	CustomerInformationPage customerInformation;
	OverviewPage overviewPage; 
	LogoutPage logoutPage;
	
	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
		String expResult="https://www.saucedemo.com/";
		String actResult=driver.getCurrentUrl();
		Assert.assertEquals(actResult, expResult);
	}
	
	@When("the user enter username as {string} and password as {string} and click login button")
	public void the_user_enter_username_as_and_password_as_and_click_login_button(String UserName, String Password) {
		loginPage=new LoginPage(driver,extTest);
		boolean actResult=loginPage.validateLogin(UserName,Password);
		Assert.assertTrue(actResult);
	}
	
	@When("the user selelcts product")
	public void the_user_selelcts_product() {
		selectProductPage = new SelectProductPage(driver,extTest);
		boolean actResult=selectProductPage.selectProduct();
		Assert.assertTrue(actResult);
	}
	
	@When("the user click add to cart button")
	public void the_user_click_add_to_cart_button() {
		addToCart=new AddToCart(driver,extTest);
		boolean actResult=addToCart.clickAddToCart();
		Assert.assertTrue(actResult);
	}
	
	@When("the user click cart icon")
	public void the_user_click_cart_icon() {
		addToCart=new AddToCart(driver,extTest);
		boolean actResult=addToCart.clickCartIcon();
		Assert.assertTrue(actResult);
	}
	
	@When("the user click add to checkout button")
	public void the_user_click_add_to_checkout_button() {
		checkOut=new CheckOutPage(driver, extTest);
		boolean actResult=checkOut.clickCheckout();
		Assert.assertTrue(actResult);
	}
	
	@When("the user customer information anf click continue button")
	public void the_user_customer_information_anf_click_continue_button() {
		customerInformation=new CustomerInformationPage(driver, extTest);
		boolean actResult=customerInformation.addCustomerDetails("kamali", "c", "621212");
		Assert.assertTrue(actResult);
	}
	
	@When("the user verifies the product and click finish button")
	public void the_user_verifies_the_product_and_click_finish_button() {
		overviewPage=new OverviewPage(driver, extTest);
		boolean actResult=overviewPage.clickFinish();
		Assert.assertTrue(actResult);
	}
	
	@When("the user click logout button")
	public void the_user_click_logout_button() {
		logoutPage=new LogoutPage(driver, extTest);
		boolean actResult=logoutPage.logout();
		Assert.assertTrue(actResult);
	}
	
}
