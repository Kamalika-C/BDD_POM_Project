package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public AddToCart(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.extTest = extTest;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean clickAddToCart() {
		driver.findElement(Locators.addtocartButton).click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
			Reporter.generateReport(driver, extTest, Status.PASS, "Product added Successful");
			return true;
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Product add Failure");
			return false;
		}
	}

	public boolean clickCartIcon() {
		driver.findElement(Locators.cartButton).click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart']")));
			Reporter.generateReport(driver, extTest, Status.PASS, "Open Cart Successful");
			return true;
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Open Cart Failure");
			return false;
		}
	}
}
