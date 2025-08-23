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
import utils.Base;
import utils.Reporter;

public class LogoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public LogoutPage(WebDriver driver,ExtentTest extTest) {
		this.driver=driver;
		this.extTest=extTest;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public boolean logout() {
		driver.findElement(Locators.menuButton).click();
		Base.sleep();
		driver.findElement(Locators.logoutButton).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
			Reporter.generateReport(driver,extTest,Status.PASS,"Logout Successful");
			return true;
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Logout Failure");
			return false;
		}
	}
}
