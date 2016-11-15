package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.SplashmathScreenShot;
import commonUtility.WaitForSometime;
import commonUtility.WebElementLocationOnPage;

public class FromProductPageToCreditCardPage 
{
	
	/*
	 * @FindBy(how=How.NAME, using="username")
	   @CacheLookup
	   private WebElement user_name;
	   //*[@id="subscription-welcome-flow"]/div[3]/div/div[2]/div/div[1]/form/h5/span
	    * //*[@id="subscription-welcome-flow"]/div[3]/div/div[2]/div/div[1]/form/p
	 */
	
		@FindBy(xpath ="//*[@class='header-text']")
		@CacheLookup
		WebElement pageHeading;
		
		@FindBy(xpath ="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/h5/span")
		@CacheLookup
		WebElement creditCardHeaderInfo;
		
		@FindBy(xpath ="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/p")
		@CacheLookup
		WebElement userCreditCardSubInfo;
		
		@FindBy(id="card_number")
		@CacheLookup
		WebElement userCardNumber;
	
		@FindBy(id="card_code")
		@CacheLookup
		WebElement cardSecurityCode;
		
		@FindBy(xpath="//*[@class='date-field js-date-field month dropdown']/a")
		@CacheLookup
		WebElement expirationMonth;
		
		@FindBy(xpath="//*[@class='date-field js-date-field year dropdown']/a")
		@CacheLookup
		WebElement expirationYear;
		
		@FindBy(name="commit")
		@CacheLookup
		WebElement selectFreeMonth;
		
		public WebDriver driver;
		public ExtentTest test;
		public SplashmathScreenShot images;
		public WaitForSometime needWait;
		public WebElementLocationOnPage pageElement;
		
	public FromProductPageToCreditCardPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void toCreditCardPage()
	{
		images = new SplashmathScreenShot(driver);
		
		test.log(LogStatus.INFO, "User Landed on Credit Card Page");
		String pageHeadingInfo = pageHeading.getText();
		test.log(LogStatus.INFO, "Credit Card Page Heading = "+ pageHeadingInfo);
	
		String creditCardBoxHeadingInfo = creditCardHeaderInfo.getText();
		test.log(LogStatus.INFO, "Credit Card Container Heading = "+ creditCardBoxHeadingInfo);
		
		String userCreditCardSubBoxInfo = userCreditCardSubInfo.getText();
		test.log(LogStatus.INFO, "Credit Card Sub Heading = "+ userCreditCardSubBoxInfo);
		
		userCardNumber.sendKeys("4242424242424242");
		test.log(LogStatus.INFO, "User Enters Credit Card Number");
		
		Select selectMonth= new Select(expirationMonth);
		selectMonth.selectByVisibleText("10");
		test.log(LogStatus.INFO, "User Selects Card Expiry Month");
		
		Select selectYear= new Select(expirationYear);
		selectYear.selectByVisibleText("2016");
		test.log(LogStatus.INFO, "User Selects Card Expiry Year");
		
		cardSecurityCode.sendKeys("123");
		test.log(LogStatus.INFO, "User Enters Card Security Code");
		
		selectFreeMonth.click();
		test.log(LogStatus.INFO, "User Enters Card Security Code");
		
		images.takeScreenshot("UserCreditCardPage", "CreditCardPage");
		
		
	}
	
	

}
