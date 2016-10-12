package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectModel.ParentSignUp;
import screenShot.SplashmathScreenShot;
import verifyPresenceOfElement.VerifyElementOnWebPage;
import basic.Base;

public class LandingPageParentSignUp extends Base
{
	ParentSignUp signUp;
	
	SplashmathScreenShot images;
	VerifyElementOnWebPage findElement;
	
	@Test
	public void enterInvalidCredentials() throws InterruptedException
	{
		try{
			
				test = extent.startTest("Verify enterInvalidCredentials");
					
				images = new SplashmathScreenShot(driver);
				
				signUp= new ParentSignUp(driver);
				signUp.enterData("sandeep","1234");
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				test.log(LogStatus.INFO, "SignUp_InvalidCredentials = Pass");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_InvalidCredentials");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankCredentials() throws InterruptedException
	{
		try{
			
				test = extent.startTest("Verify enterBlankCredentials");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData(" "," ");
				
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				
				test.log(LogStatus.INFO, "SignUp_enterBlankCredentials = Pass");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_enterBlankCredentials");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankUserEmail() throws InterruptedException
	{ 
		try
		{
				
				test = extent.startTest("Verify enterBlankUserEmail");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData(" ","1234");
				
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				test.log(LogStatus.INFO, "SignUp_EnterBlankUserEmail = Pass");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterBlankUserEmail");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankUserPassword() throws InterruptedException
	{
		try{
				test = extent.startTest("Verify enterBlankUserPassword");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData("sandeep@splashmath.com"," ");
				//	System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
				
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				test.log(LogStatus.INFO, "SignUp_EnterBlankUserPassword = Pass");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterBlankUserPassword");
		
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
