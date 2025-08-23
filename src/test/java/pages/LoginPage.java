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

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public LoginPage(WebDriver driver,ExtentTest extTest) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest=extTest;
	}
	
	public boolean validateLogin(String uName,String pwd) {
		driver.findElement(Locators.username).sendKeys(uName);
		driver.findElement(Locators.password).sendKeys(pwd);
		driver.findElement(Locators.loginButton).click();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			Reporter.generateReport(driver,extTest,Status.PASS,"Login Successful");
			return true;
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Login Failure");
			return false;
		}
	}
}
