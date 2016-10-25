package pageObjectModel;

import javax.script.ScriptEngineManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.LinkOnPage;
import commonUtility.ParentSignUpCredentials;
import commonUtility.SplashmathScreenShot;
import verifyPresenceOfElement.VerifyElementOnWebPage;

public class ParentSignUpFlowType 
{
	public WebDriver driver;
	public ExtentTest test;
	public SplashmathScreenShot images;
	public LinkOnPage pagelink;
	public ParentSignUpCredentials userinfo;
	
	public VerifyElementOnWebPage pageElement;
	private By parentSignUpButton = By.linkText("Parents, Get Started for Free");
	private By parentEmail = By.id("user_email");
	private By parentPassword =By.id("user_password");
	private By doSignUp = By.id("signup-button");
	private By childFormPageNextButton=By.xpath("//input[@class='button rounded-button-light-orange long full']");
	
	
	public ParentSignUpFlowType(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	public void enterUserCredentials()
	{
		pageElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		pagelink = new LinkOnPage(driver, test);
		userinfo = new ParentSignUpCredentials();
		
		boolean elementOnWebpage = false;
		boolean linkStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		
		
		elementOnWebpage = pageElement.isElementPresent(parentSignUpButton);
		
		if(elementOnWebpage)
		{
				driver.findElement(parentSignUpButton).click();
				test.log(LogStatus.INFO, "user clicked on Parent SignUp button");
				
				WebDriverWait signUpForm = new WebDriverWait(driver,10);
				signUpForm.until(ExpectedConditions.elementToBeClickable(doSignUp));
				test.log(LogStatus.INFO, "User on Parent SignUp form Modal");
				
				
				String userCredentials[] = new String[2];
	// Calling Function to get user SignUp credentials		
				userCredentials = userinfo.giveParentSignUpDetails();
			
				driver.findElement(parentEmail).sendKeys(userCredentials[0]);
				test.log(LogStatus.INFO, "User Entered Email = " + userCredentials[0]) ;
				System.out.println(userCredentials[0]);
			
				driver.findElement(parentPassword).sendKeys(userCredentials[1]);
				test.log(LogStatus.INFO, "User Entered Password = " + userCredentials[1]) ;
				System.out.println(userCredentials[1]);
				
				driver.findElement(doSignUp).click();
				test.log(LogStatus.INFO, "User clicked on SignUp button") ;
				
				WebDriverWait nextButton = new WebDriverWait(driver, 10);
				nextButton.until(ExpectedConditions.elementToBeClickable(childFormPageNextButton));
				
				test.log(LogStatus.INFO, "User on Child Add Form Page") ;
				
				JavascriptExecutor js = (JavascriptExecutor) driver; 
		//		System.out.println(js.executeScript("return REGISTRY.currentUser.signupFlow;").toString());
				test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
				String userCurrentFlowSet = js.executeScript("return REGISTRY.currentUser.signupFlow;").toString();
				System.out.println(userCurrentFlowSet);
		
				//Flow 1 = web_subscription_trial_aug_2015:30_day:product_selection_first	
				// trial_class_50
				
		}
		
		else
		{
			test.log(LogStatus.INFO, "Parent SignUp Link not Found or is missing");
		}
	}

	
}
