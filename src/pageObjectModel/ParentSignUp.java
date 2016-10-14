package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import verifyPresenceOfElement.VerifyElementOnWebPage;

public class ParentSignUp 
{
	public WebDriver driver;
	public VerifyElementOnWebPage findElement;
	
	private By ParentSignUpButton= By.linkText("Parents, Get Started for Free");
	private By userEmail = By.id("user_email");
	private By userPassword = By.id("user_password");
	private By doSignUpButton = By.id("signup-button");
	
	
	
	public ParentSignUp(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public void enterData(String email, String password) throws InterruptedException
	{
		boolean elementStatus = false;
		findElement = new VerifyElementOnWebPage(driver);
		elementStatus=findElement.isElementPresent(ParentSignUpButton);
		if(elementStatus)
		{
			driver.findElement(ParentSignUpButton).click();
			System.out.println("Parent SignUp Button Clicked");

		}
		
		else
		{
			System.out.println("Parent SignUp Button not found");
		}
		
		
		elementStatus=findElement.isElementPresent(userEmail);
		if(elementStatus)
		{
			driver.findElement(userEmail).sendKeys(email);
			System.out.println("User Email field Present");
	

		}
		
		else
		{
			System.out.println("User Email field not found");
		}
		
		elementStatus=findElement.isElementPresent(userPassword);
		if(elementStatus)
		{
		
			driver.findElement(userPassword).sendKeys(password);
			System.out.println("User Password field Present");
			
		}
		
		else
		{
			System.out.println("User Password field not found");
		}
		
		elementStatus=findElement.isElementPresent(doSignUpButton);
		if(elementStatus)
		{
			driver.findElement(doSignUpButton).click();
			System.out.println("Parent DoSignUp Button Present");
		}
		
		else
		{
			System.out.println("Parent DoSignUp button not found");
		}
		
	}
	
}
