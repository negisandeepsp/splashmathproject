package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectModel.ParentSignUp;
import commonUtility.SplashmathScreenShot;
import commonUtility.WindowHandling;
import verifyPresenceOfElement.VerifyElementOnWebPage;
import basic.Base;

public class LandingPageParentSignUp extends Base
{
	private By emailErrorMsg = By.xpath("//fieldset/div[1]/span");
	private By passwordErrorMsg = By.xpath("//fieldset/div[2]/span[2]");
	private By signUpForFreeButton= By.id("signup-button");
	private By childFormPageNextButton=By.xpath("//input[@class='button rounded-button-light-orange long full']");
	private By doSignUpButton = By.id("signup-button");
	
	private By alreadySignUpMessage=By.xpath("//form[@id='main_parent_signup_form']/div[2]/div/div[1]/span");
	private By alreadySignUpPageBUtton = By.name("commit");
	private By alreadySignUpPage_emailField=By.id("user_email");
	
	private By ParentSignUpButton= By.linkText("Parents, Get Started for Free");
	private By linkTerms = By.xpath("//div[@class='terms']/p/small/a[1]");
	private By linkPrivacyPolicy=By.xpath("//div[@class='terms']/p/small/a[2]");
	private By googleSignUp = By.xpath("//div[@class='social-signups']/a[1]");
	private By facebookSignUp = By.xpath("//div[@class='social-signups']/a[2]");
	
	// On Google Page
	private By googleUserEmail = By.id("Email");
	private By googleNextButton = By.id("next");
	private By googleUserPassword = By.id("Passwd");
	private By googleSignInButton = By.id("signIn");
	
	// On facebook Page
	private By facebookPageLoginButton = By.name("login");
	
	ParentSignUp signUp;
	SplashmathScreenShot images;
	WindowHandling getWindow;
	
	VerifyElementOnWebPage findElement;
	
	@Test
	public void enterInvalidCredentials() throws InterruptedException
	{
		boolean elementStatus = false;
		try{
			
				findElement = new VerifyElementOnWebPage(driver);
				
				test = extent.startTest("Verify enterInvalidCredentials");
					
				images = new SplashmathScreenShot(driver);
				
				signUp= new ParentSignUp(driver);
				signUp.enterData("sandeep","1234");
				
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
				
				elementStatus = findElement.isElementPresent(emailErrorMsg);
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
				}
				
				
				elementStatus = findElement.isElementPresent(passwordErrorMsg);
				
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Password Field Error Msg = "+ driver.findElement(passwordErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Password field not present or is changed");
				}
				
				
	//			Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
//	 To verify SignUp button present on Form page 			
				if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
				{
					test.log((LogStatus.PASS), " Verified InvalidCredentials on Parent SignUp Form Page ");
					images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_InvalidCredentials");
				}
				else
				{
					test.log((LogStatus.FAIL), "InvalidCredentials on Parent SignUp Form is Failed");
				}
				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankCredentials() throws InterruptedException
	{
		boolean elementStatus = false;
		try{
			
			findElement = new VerifyElementOnWebPage(driver);
				test = extent.startTest("Verify enterBlankCredentials");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData(" "," ");
				
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
	
				elementStatus = findElement.isElementPresent(emailErrorMsg);
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
				}
				
				
				elementStatus = findElement.isElementPresent(passwordErrorMsg);
				
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Password Field Error Msg = "+ driver.findElement(passwordErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Password field not present or is changed");
				}
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
			
				if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
				{
					test.log((LogStatus.PASS), " Verified BlankCredentials on Parent SignUp Form Page ");
					images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterBlankCredentials");
				}
				else
				{
					test.log((LogStatus.FAIL), "BlankCredentials on Parent SignUp Form is Failed");
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankUserEmail() throws InterruptedException
	{ 
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
				test = extent.startTest("Verify enterBlankUserEmail");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData(" ","123456");
				
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
	
				elementStatus = findElement.isElementPresent(emailErrorMsg);
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
				}
				

				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				
				if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
				{
					test.log((LogStatus.PASS), " Verified BlankUserEmail on Parent SignUp Form Page ");
					images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterBlankUserEmail");
				}
				else
				{
					test.log((LogStatus.FAIL), "EnterBlankUserEmail on Parent SignUp Form is Failed");
				}
				
				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterBlankUserPassword() throws InterruptedException
	{
		boolean elementStatus = false;
		try{
			findElement = new VerifyElementOnWebPage(driver);
				test = extent.startTest("Verify enterBlankUserPassword");
				images = new SplashmathScreenShot(driver);
				signUp= new ParentSignUp(driver);
				signUp.enterData("sandeep@splashmath.com"," ");
	
	
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
				
			//		System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
				
				elementStatus = findElement.isElementPresent(passwordErrorMsg);
				
				if (elementStatus)
				{
					test.log(LogStatus.INFO, "Showing Password Field Error Msg = "+ driver.findElement(passwordErrorMsg).getText());
				}
				
				else
				{
					test.log(LogStatus.INFO, "Error message below Password field not present or is changed");
				}
				Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
				
				
				if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
				{
					test.log((LogStatus.PASS), " Verified BlankUserPassword on Parent SignUp Form Page ");
					images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterBlankUserPassword");
				}
				else
				{
					test.log((LogStatus.FAIL), "EnterBlankUserPassword on Parent SignUp Form is Failed");
				}			
		
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterInvalidEmailFormatTypeOne()
	{
		boolean elementStatus = false;
		try{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify enterInvalidEmailFormatTypeOne_without.com");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			signUp.enterData("sandeep@splashmath","123456");
	
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
			
			elementStatus = findElement.isElementPresent(emailErrorMsg);
			if (elementStatus)
			{
				test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
			}
			
			else
			{
				test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
			}
			
				System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
			
			Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
			
			
			if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
			{
				test.log((LogStatus.PASS), " Verified InvalidEmailFormatTypeOne_without.com on Parent SignUp Form Page ");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterInvalidEmailFormatTypeOne_without.com");
			}
			else
			{
				test.log((LogStatus.FAIL), "EnterInvalidEmailFormatTypeOne_without.com on Parent SignUp Form is Failed");
			}
	
}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterInvalidEmailFormatTypeTwo()
	{
		boolean elementStatus = false;
		try{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify enterInvalidEmailFormatTypeTwo_multiple@@");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			signUp.enterData("sandeep@@splashmath.com","123456");
	
	
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
			
			//	System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
			
			elementStatus = findElement.isElementPresent(emailErrorMsg);
			if (elementStatus)
			{
				test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
			}
			
			else
			{
				test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
			}
			
			
			Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
			

			if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
			{
				test.log((LogStatus.PASS), " Verified InvalidEmailFormatTypeTwo_multiple@@ on Parent SignUp Form Page ");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterInvalidEmailFormatTypeTwo_multiple@@");
			}
			else
			{
				test.log((LogStatus.FAIL), "EnterInvalidEmailFormatTypeTwo_multiple@@ on Parent SignUp Form is Failed");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterInvalidEmailFormatTypeThree()
	{
		boolean elementStatus = false;
		try{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify enterInvalidEmailFormatTypeThree_EmailStartingWith@");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			signUp.enterData("@splashmath.com","123456");
	
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
		//		System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
			
			elementStatus = findElement.isElementPresent(emailErrorMsg);
			if (elementStatus)
			{
				test.log(LogStatus.INFO, "Showing Email Field Error Msg = "+ driver.findElement(emailErrorMsg).getText());
			}
			
			else
			{
				test.log(LogStatus.INFO, "Error message below Email field not present or is changed");
			}
			
			Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
			
			if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
			{
				test.log((LogStatus.PASS), " Verified InvalidEmailFormatTypeThree_EmailStartingWith@ on Parent SignUp Form Page ");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterInvalidEmailFormatTypeThree_EmailStartingWith@");
			}
			else
			{
				test.log((LogStatus.FAIL), "EnterInvalidEmailFormatTypeThree_EmailStartingWith@ on Parent SignUp Form is Failed");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void enterUserPassword_InvalidPasswordLength()
	{
		boolean elementStatus = false;
		try{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify enterUserPassword_InvalidPasswordLength");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			signUp.enterData("sn+@splashmath.com","12345");
	
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
	
		//		System.out.println(driver.findElement(By.id("signup-button")).getAttribute("value"));
			
			elementStatus = findElement.isElementPresent(passwordErrorMsg);
			
			if (elementStatus)
			{
				test.log(LogStatus.INFO, "Showing Password Field Error Msg = "+ driver.findElement(passwordErrorMsg).getText());
			}
			
			else
			{
				test.log(LogStatus.INFO, "Error message below Password field not present or is changed");
			}
	//		Assert.assertEquals(driver.findElement(By.id("signup-button")).getAttribute("value"), "Sign up for FREE");
			
			if(driver.findElement(signUpForFreeButton).getAttribute("value").contains("Sign up"))
			{
				test.log((LogStatus.PASS), " Verified UserPassword_InvalidPasswordLength_LessThan_6_Characters on Parent SignUp Form Page ");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_EnterUserPassword_InvalidPasswordLength_LessThan_6_Characters");
			}
			else
			{
				test.log((LogStatus.FAIL), "InvalidPasswordLength on Parent SignUp Form is Failed");
			}
			

		}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void verifyAlreadySignUpUserEmailAccount()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify AlreadySignUpUserEmailAccount");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			//sandeep.negi+pg012@splashmath.com
			signUp.enterData("sandeep.negi+pg012@splashmath.com","123456");
			
			WebDriverWait alreadySignUpPage = new WebDriverWait(driver, 10);
			alreadySignUpPage.until(ExpectedConditions.elementToBeClickable(alreadySignUpPageBUtton));
			
			elementStatus = findElement.isElementPresent(alreadySignUpPage_emailField);
			
			if (elementStatus)
			{
				test.log(LogStatus.INFO, "On Already SignUp Form Page");
				test.log(LogStatus.PASS, "Verified AlreadySignUpUserEmailAccount ");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_verifyAlreadySignUpUserEmailAccount");
			}
			
			else
			{
				test.log(LogStatus.FAIL, "AlreadySignUpUserEmailAccount...Failed");
			}
			
			
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void validSignUpTypeOne_usingSmallCharaters()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify validSignUpTypeOne_usingSmallCharaters");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			
		
	//	 to generate random number in Parent Email
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
			String dateAsString = simpleDateFormat.format(new Date());
			
			String parentEmail= "sn+" + dateAsString + "@splashmath.com";
			String password = "123456";
			
			signUp.enterData(parentEmail,password);
			test.log(LogStatus.INFO, "Parent SignUp form Filled");
			
			WebDriverWait addChildPage= new WebDriverWait(driver,20);
			addChildPage.until(ExpectedConditions.presenceOfElementLocated(childFormPageNextButton));
			
			elementStatus = findElement.isElementPresent(childFormPageNextButton); 
			if(elementStatus)
			{
				
				test.log(LogStatus.INFO, "On Add child Form Page");
				test.log(LogStatus.PASS, "Verified Parent SignUp usingSmallCharaters");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_validSignUpTypeOne_usingSmallCharaters");
			}
			
			else
			{
				
				test.log(LogStatus.FAIL, "Parent SignUp Failed");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void validSignUpTypeTwo_usingCapitalCharaters()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify validSignUpTypeTwo_usingCapitalCharaters");
			images = new SplashmathScreenShot(driver);
			signUp= new ParentSignUp(driver);
			
		
		// to generate random number in Parent Email
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
			String dateAsString = simpleDateFormat.format(new Date());
			
			String parentEmail= "SN+" + dateAsString + "@SPLASHMATH.COM";
			String password = "123456";
			
			signUp.enterData(parentEmail,password);
			test.log(LogStatus.INFO, "Parent SignUp form Filled");
			
			WebDriverWait addChildPage= new WebDriverWait(driver,20);
			addChildPage.until(ExpectedConditions.presenceOfElementLocated(childFormPageNextButton));
			
			elementStatus = findElement.isElementPresent(childFormPageNextButton); 
			if(elementStatus)
			{
				
				test.log(LogStatus.INFO, "On Add child Form Page");
				test.log(LogStatus.PASS, "Verified Parent SignUp usingCapitalCharaters");
				images.takeScreenshot("LandingPage_ParentSignUP", "SignUp_validSignUpTypeTwo_usingCapitalCharaters");
			}
			
			else
			{
				
				test.log(LogStatus.FAIL, "Parent SignUp Failed");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//       Link Terms and Privacy policy
	
	@Test
	public void verifyLinkTerms()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify Link_Terms");
			images = new SplashmathScreenShot(driver);
			
			elementStatus=findElement.isElementPresent(ParentSignUpButton);
			if(elementStatus)
			{
				driver.findElement(ParentSignUpButton).click();
				test.log(LogStatus.INFO, "Clicked on Parent SignUP button on Landing Page");
				
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
				
			    	elementStatus=findElement.isElementPresent(linkTerms);
			    	  if(elementStatus)
			    	  {
			    		  getWindow = new WindowHandling(driver);
			    		  test.log(LogStatus.INFO, "Link Terms present on Parent SignUp form Page");    		
			  // calling Windowhandling method and Passing 3 arguements, third one is Weblement		  
			    		  getWindow.onWindow("LandingPage_ParentSignUP","Terms_of_use", linkTerms);
			    		  test.log(LogStatus.INFO, "Clicked on Link Terms of Use");
			    		  
			    		  test.log(LogStatus.PASS, "Verified Terms of Use Page");
			    		  
			    		  
			    	  }
			    	  
			    	  else
			    	  {
			    			test.log(LogStatus.INFO, "Links Terms not present on Parent SignUp form page");
			    	  }
				

			}
			
			else
			{
				test.log(LogStatus.INFO, "Parent SignUP button on Landing Page not Present");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void verifyLinkPrivacyPolicy()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify Link_PrivacyPolicy");
			images = new SplashmathScreenShot(driver);
			
			elementStatus=findElement.isElementPresent(ParentSignUpButton);
			if(elementStatus)
			{
				driver.findElement(ParentSignUpButton).click();
				test.log(LogStatus.INFO, "Clicked on Parent SignUP button on Landing Page");
			    
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
				
				elementStatus=findElement.isElementPresent(linkPrivacyPolicy);
			    	  if(elementStatus)
			    	  {
			    		  getWindow = new WindowHandling(driver);
			    		  
			    		  test.log(LogStatus.INFO, "Link Privacy Policy present on Parent SignUp form Page");    		
			
			    		  // calling Windowhandling method and Passing 3 arguements, third one is Weblement		  
			    		  getWindow.onWindow("LandingPage_ParentSignUP","PrivacyPolicy",linkPrivacyPolicy);
			    		  test.log(LogStatus.INFO, "Clicked on Link PrivacyPolicy");
			    		  test.log(LogStatus.PASS, "Verified PrivacyPolicy Page");
			    		  
			    		  
			    	  }
			    	  
			    	  else
			    	  {
			    			test.log(LogStatus.INFO, "Links PrivacyPolicy not present on Parent SignUp form page");
			    	  }
				

			}
			
			else
			{
				test.log(LogStatus.INFO, "Parent SignUP button on Landing Page not Present");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void verifyGoogleSignUp()
	{
		boolean elementStatus = false;

		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify ParentSignUpForm_GoogleSignUp");
			images = new SplashmathScreenShot(driver);
			
			elementStatus=findElement.isElementPresent(ParentSignUpButton);
			if(elementStatus)
			{
				driver.findElement(ParentSignUpButton).click();
				test.log(LogStatus.INFO, "Clicked on Parent SignUP button on Landing Page");
			    
				WebDriverWait signUpButton= new WebDriverWait(driver,20);
				signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
				
				//googleSignUp
				elementStatus=findElement.isElementPresent(googleSignUp);
				if(elementStatus)
				{
					test.log(LogStatus.INFO, "Google SignUp Button present on page");
					driver.findElement(googleSignUp).click();
					test.log(LogStatus.INFO, "Cliked on Google SignUp button");
					// Google Title = "Sign in - Google Accounts"
					// Already SignUp user = omnitest100@gmail.com
					
		// To check whether User lands on Google Page or not			
							if(driver.getTitle().contains("Sign in - Google Accounts"))
										{
											WebDriverWait googlePage=new WebDriverWait(driver,20);
											googlePage.until(ExpectedConditions.elementToBeClickable(googleNextButton));
											test.log(LogStatus.INFO, "On Google SignUp Page");
											images.takeScreenshot("LandingPage_ParentSignUP", "Google_SignUp_Page");
											
											driver.findElement(googleUserEmail).sendKeys("omnitest90@gmail.com");
											driver.findElement(googleNextButton).click();
											driver.findElement(googleUserPassword).sendKeys("splashmath");
											driver.findElement(googleSignInButton).click();
											Thread.sleep(2000);
									// User may have already Signed up using Existing Credential, this we will check using Page Title	
											if(driver.getTitle().contains("Parent"))
											{
												test.log(LogStatus.INFO,"Page After Google SignUp = " + driver.getTitle());
												test.log(LogStatus.INFO, "URL =" + driver.getCurrentUrl());
												images.takeScreenshot("LandingPage_ParentSignUP", "Parent SignUp via Google");
												test.log(LogStatus.PASS, "Google SignUp Page verified");
											}
											
											else
											{
												test.log(LogStatus.INFO,"User already SignUp as an Teacher using existing Credential, use different Credentials");
												test.log(LogStatus.INFO, "URL =" + driver.getCurrentUrl());
												images.takeScreenshot("LandingPage_ParentSignUP", "Teacher SignUp via Google");
												test.log(LogStatus.PASS, "Google SignUp Page verified");
											}
								// Page title checked			
										}
							
							else
							{
								String currentPage=driver.getTitle();
								test.log(LogStatus.INFO, "User on Page " + currentPage);
								test.log(LogStatus.INFO, "URL =" + driver.getCurrentUrl());
								images.takeScreenshot("LandingPage_ParentSignUP", currentPage);
							}
					
				}
				else
				{
					test.log(LogStatus.INFO, "Google SignUp Button not Present or is missing");
				}
				
			}
			
			else
			{
				test.log(LogStatus.INFO, "Parent SignUp button not present");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void verifyFacebookSignUp()
	{
		boolean elementStatus = false;
		try
		{
			findElement = new VerifyElementOnWebPage(driver);
			test = extent.startTest("Verify ParentSignUpForm_FacebookSignUp");
			images = new SplashmathScreenShot(driver);
			
			elementStatus=findElement.isElementPresent(ParentSignUpButton);
			if(elementStatus)
			{
			test.log(LogStatus.INFO, "ParentSignUpButton present on page");
			driver.findElement(ParentSignUpButton).click();
			test.log(LogStatus.INFO, "Clicked on ParentSignUpButton");
			
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
			
			elementStatus=findElement.isElementPresent(facebookSignUp);
			if(elementStatus)
				{
					test.log(LogStatus.INFO, "Facebook SignUp Button present on page");
					driver.findElement(facebookSignUp).click();
					test.log(LogStatus.INFO, "Clicked on Facebook Button");
				if(driver.getTitle().contains("Facebook"))
				{
						elementStatus=findElement.isElementPresent(facebookPageLoginButton);
				
						if(elementStatus)
						{
							test.log(LogStatus.INFO, "User on FacebookPage");
							test.log(LogStatus.INFO, "URL = " +driver.getCurrentUrl());
							test.log(LogStatus.PASS, "Verfied Facebook SignUp");
							images.takeScreenshot("LandingPage_ParentSignUP", "FacebookPage");
						}
						else
						{
							test.log(LogStatus.INFO, "URL = " +driver.getCurrentUrl());
							test.log(LogStatus.FAIL, "Something Wrong on this Page");
							images.takeScreenshot("LandingPage_ParentSignUP", "SomethingWrongOnFacebookPage");
						}
					
				}
				
				else
				{
					test.log(LogStatus.INFO, "User not on Facebook Page");
					test.log(LogStatus.INFO, "URL = " +driver.getCurrentUrl());
					images.takeScreenshot("LandingPage_ParentSignUP", "Incorrect FacebookPage");
				}
			}
			
			else
			{
				test.log(LogStatus.INFO, "Facebook Button Not present on Page");
				images.takeScreenshot("LandingPage_ParentSignUP", "Facebook Button missing on Page");
				
			}
			}
			
			else
			{
				test.log(LogStatus.INFO, "Parent SignUp Button not present on page");
			}
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.INFO, e.getMessage());
		}
	}
}
