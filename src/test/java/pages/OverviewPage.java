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

public class OverviewPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public OverviewPage(WebDriver driver,ExtentTest extTest) {
		this.driver=driver;
		this.extTest=extTest;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public boolean clickFinish() {
		driver.findElement(Locators.finishButton).click();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Complete!']")));
			Reporter.generateReport(driver,extTest,Status.PASS,"Product overview Successful");
			return true;
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Product overview Failure");
			return false;
		}
	}
}
