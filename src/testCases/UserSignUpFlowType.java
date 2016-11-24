package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic.Base;
import pageObjectModel.AddChildPage;
import pageObjectModel.ParentSignUpFlowType;
import pageObjectModel.ProductSelectionFirstPage;

public class UserSignUpFlowType extends Base 
{
	public ParentSignUpFlowType parentSignUp;
	public AddChildPage childDetails;
	public ProductSelectionFirstPage productpage;
	
	@Test
	public void verifySignUpFlow() throws InterruptedException
	{
		test = extent.startTest("Verify User SignUp Flow");
		parentSignUp = new ParentSignUpFlowType(driver, test);
		childDetails = new AddChildPage(driver, test);
		productpage = new ProductSelectionFirstPage(driver, test);
		
		String userFlowType=" ";
		
		parentSignUp.enterUserCredentials();
		
		WebElement addChildFormPage = driver.findElement(By.xpath("//*[@id='subscription-welcome-flow']/div[2]/div/h1"));
		String pageHeading = addChildFormPage.getText();
	// To verify that user is on Add child Form Page	
		Assert.assertEquals(pageHeading, "Share Your Child's Details");
		userFlowType= childDetails.fillChildDetails();
		test.log(LogStatus.INFO, "Current User SignUp Flow set is = " + userFlowType);
		
		if(userFlowType.equals("web_subscription_trial_aug_2015:30_day:product_selection_first"))
		{
			test.log(LogStatus.INFO, "Product Selection first page");
	
			productpage.productAvialableForUser();
			WebDriverWait childLoginButton = new WebDriverWait(driver,30);
			childLoginButton.until(ExpectedConditions.presenceOfElementLocated(By.id("launch_child_dashboard_id")));
			Assert.assertEquals((driver.getTitle()), "Parent Dashboard - Splash Math");
			test.log(LogStatus.INFO, "User on Parent Dashboard");
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			test.log(LogStatus.INFO, " Is Tour Pop Up Visible on Parent Dashboard After SignUp => " + js.executeScript("return REGISTRY.tourShown;").toString()) ;
			test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
		}
		
		else if(userFlowType.equals("trial_class_25"))
		{
			WebDriverWait childLoginButton = new WebDriverWait(driver,30);
			childLoginButton.until(ExpectedConditions.presenceOfElementLocated(By.id("launch_child_dashboard_id")));
			Assert.assertEquals((driver.getTitle()), "Parent Dashboard - Splash Math");
			
			test.log(LogStatus.INFO, "User on Parent Dashboard");
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			test.log(LogStatus.INFO, " Is Tour Pop Up Visible on Parent Dashboard After SignUp => " + js.executeScript("return REGISTRY.tourShown;").toString()) ;
			test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
		}
		
		else if(userFlowType.equals("trial_class_50"))
		{
			WebDriverWait childLoginButton = new WebDriverWait(driver,30);
			childLoginButton.until(ExpectedConditions.presenceOfElementLocated(By.id("launch_child_dashboard_id")));
			Assert.assertEquals((driver.getTitle()), "Parent Dashboard - Splash Math");
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			test.log(LogStatus.INFO, " Is Tour Pop Up Visible on Parent Dashboard After SignUp => " + js.executeScript("return REGISTRY.tourShown;").toString()) ;
				test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
		}
		
		else
		{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			test.log(LogStatus.INFO, " Is Tour Pop Up Visible on Parent Dashboard After SignUp => " + js.executeScript("return REGISTRY.tourShown;").toString()) ;
				test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
			test.log(LogStatus.INFO, "UNknown Flow user");
		}
		
		
		
	}

}
