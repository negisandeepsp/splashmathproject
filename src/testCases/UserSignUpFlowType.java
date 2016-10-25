package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public void verifySignUpFlow()
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
			//web_subscription_trial_aug_2015:30_day:product_selection_first
			productpage.productAvialableForUser();
			
		}
		
		else
		{
			test.log(LogStatus.INFO, "Trial Class Flow user");
			// trial_class_50
		}
		
		
		
	}

}
