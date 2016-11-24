package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.WaitForSometime;

public class ParentSignIn 
{
	public WebDriver driver;
	public ExtentTest test;
	public WaitForSometime needWait;
	
	@FindBy(linkText="Sign In")
	WebElement userSignInButton;
	
	@FindBy(xpath="//*[@id='login-modal']/div/div/div[1]/div[2]/ul/li[2]/a/img")
	WebElement parentSignInButton;
	
	@FindBy(id="user_login")
	WebElement userEmail;
	
	@FindBy(id="modal_login_password")
	WebElement userPassword;
	
	@FindBy(id="login-button")
	WebElement userSignIn;
	
	public ParentSignIn(WebDriver driver , ExtentTest test)
	{
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	public void doParentSignIn(String userName, String password)
	{
		needWait = new WaitForSometime();
		
		userSignInButton.click();
		test.log(LogStatus.INFO, " User Clicks on Landing Page SignIn Button");
		needWait.doWaitForSometime();
		parentSignInButton.click();
		test.log(LogStatus.INFO, " User Clicks on Parent SignIn Button");
		needWait.doWaitForSometime();
		userEmail.sendKeys(userName);
		test.log(LogStatus.INFO, " User Enters Parent Email");
		userPassword.sendKeys(password);
		test.log(LogStatus.INFO, " User Enters Parent Password");
		userSignIn.click();
		test.log(LogStatus.INFO, " User Clicks on Sign In Submit Buttom");
		
	}
}
