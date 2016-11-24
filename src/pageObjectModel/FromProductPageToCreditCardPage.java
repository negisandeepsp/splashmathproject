package pageObjectModel;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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
		
		@FindBy(xpath="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/div[3]/div/div/div[1]/a")
		@CacheLookup
		WebElement selectExpirationMonthDropDown;
		
		@FindBy(xpath="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/div[3]/div/div/div[1]/ul/li[5]/a")
		@CacheLookup
		WebElement selectExpirationMonth;
		
		@FindBy(xpath="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/div[3]/div/div/div[2]/a")
		@CacheLookup
		WebElement selectExpirationYearDropDown;
		
		@FindBy(xpath="//*[@id='subscription-welcome-flow']/div[3]/div/div[2]/div/div[1]/form/div[3]/div/div/div[2]/ul/li[4]/a")
		@CacheLookup
		WebElement selectExpirationYear;
		
		@FindBy(name="commit")
		@CacheLookup
		WebElement userSubmitCard;
		
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
	
	public void toCreditCardPage() throws InterruptedException
	{
		images = new SplashmathScreenShot(driver);
		
		test.log(LogStatus.INFO, "User Landed on Credit Card Page");
		String pageHeadingInfo = pageHeading.getText();
		test.log(LogStatus.INFO, "Credit Card Page Heading = "+ pageHeadingInfo);
	
		String creditCardBoxHeadingInfo = creditCardHeaderInfo.getText();
		test.log(LogStatus.INFO, "Credit Card Container Heading = "+ creditCardBoxHeadingInfo);
		
		String userCreditCardSubBoxInfo = userCreditCardSubInfo.getText();
		test.log(LogStatus.INFO, "Credit Card Sub Heading = "+ userCreditCardSubBoxInfo);
		
		userCardNumber.sendKeys("4242");
		userCardNumber.sendKeys("4242");
		userCardNumber.sendKeys("4242");
		userCardNumber.sendKeys("4242");
		
		test.log(LogStatus.INFO, "User Enters Credit Card Number");
		
		selectExpirationMonthDropDown.click();
		selectExpirationMonth.click();

		selectExpirationYearDropDown.click();
		selectExpirationYear.click();
		test.log(LogStatus.INFO, "User Selects Card Expiry Month");

		test.log(LogStatus.INFO, "User Selects Card Expiry Year");
		
		cardSecurityCode.sendKeys("123");
		test.log(LogStatus.INFO, "User Enters Card Security Code");
		Thread.sleep(3000);
		
		images.takeScreenshot("UserCreditCardPage", "CreditCardPage_AfterProductFirst");
		userSubmitCard.click();
		test.log(LogStatus.INFO, "User Clicked Submit Card");	
		
	}
	
	

}
