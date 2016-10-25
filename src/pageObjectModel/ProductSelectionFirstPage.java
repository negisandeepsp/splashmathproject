package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.SplashmathScreenShot;
import commonUtility.WaitForSometime;

	public class ProductSelectionFirstPage 
	{
	public WebDriver driver;
	public ExtentTest test;
	public SplashmathScreenShot images;
	public WaitForSometime needWait;

	private By productPageHeading = By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/h5/span");
	private By subHeading = By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/p/span");
	
	private By products = By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li");
	private By productName= By.xpath(" //*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li");
	private By productAccessDuration=By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li");
	private By monthlyCharge=By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li");
	private By yearlyCharge = By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li");
	private By chargeAfterTrialPeriod=By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li");
// Select Monthly PLan	
	private By selectPlan=By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li[1]/div/div/div/div/div[6]/a[2]");
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/div/div[6]/a[1]
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/div/div[6]/a[2]
/*
	// Header Data
	  //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/header/h1
	  //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[2]/div/div/div[2]/header/h1
	  //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[3]/div/div/div/header/h1
	// Body Data

	BodyTitle

	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[1]/div/div/div/div/div[2]/span
	* //*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[2]/div/div/div/div/div[2]/span
	* //*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[3]/div/div/div/div/div[2]/span

	Body > Monthly Charge
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[1]/div/div/div/div/div[3]
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[2]/div/div/div/div/div[3]
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[3]/div/div/div/div/div[3]

	Body > Yearly Charge
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[1]/div/div/div/div/div[4]
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[2]/div/div/div/div/div[4]
	//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[3]/div/div/div/div/div[4]
	Body > Charged After trial
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/div/div[5]
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[2]/div/div/div/div/div[5]
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[3]/div/div/div/div/div[5]

	 Product > Select Plan button
	//*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/div/div[6]/a
	* //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[2]/div/div/div/div/div[6]/a
	* //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[3]/div/div/div/div/div[6]/a
	     */
	public ProductSelectionFirstPage(WebDriver driver, ExtentTest test)
	{
	this.driver=driver;
	this.test=test;
	}
		/*
		 //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[1]/div/div/div/header/h1
		  //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[2]/div/div/div[2]/header/h1
		  //*[@id="subscription-welcome-flow"]/div[3]/div[1]/div/ul/li[3]/div/div/div/header/h1
		*/
	public void productAvialableForUser()
	{
		
		int productCount=0;
		needWait = new WaitForSometime();
		
		images= new SplashmathScreenShot(driver);
		List<WebElement> allProducts = driver.findElements(products);
		needWait.doWaitForSometime();
		
		test.log(LogStatus.INFO, "Product Page Heading ======================== "+ driver.findElement(productPageHeading).getText());
		test.log(LogStatus.INFO, "Product Page SubHeading ======================== "+ driver.findElement(subHeading).getText());
		for(WebElement eachProduct:allProducts)
		 {
			productCount++;
			
			WebElement pName;
			WebElement pDescription;
			WebElement mCharge;
			WebElement yCharge;
			WebElement cAfterTrial;
			
			String prodName=" ";
			String productDescription=" ";
			String monthlyCharge=" ";
			String yearlyChargee=" ";
			String chargeAfterTrial=" ";
// //*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li[1]/div/div/div/header/h1
			if(productCount!=2)
			 {
	//			pName=eachProduct.findElement(By.xpath(productName+"["+productCount+"]/div/div/div/header/h1"));
				
				pName=eachProduct.findElement(By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li[" + productCount + "]/div/div/div/header/h1"));
				prodName=pName.getText();
				test.log(LogStatus.INFO, "Product Plan ==================================================== " +prodName);
				
				pDescription=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[2]/span"));
				productDescription=pDescription.getText();
				test.log(LogStatus.INFO, "Product Description = " +productDescription);
				
				mCharge=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[3]"));
				monthlyCharge=mCharge.getText();
				test.log(LogStatus.INFO, "Product Monthly Charge = " +monthlyCharge);
			
				yCharge=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[4]"));
				yearlyChargee = yCharge.getText();
				test.log(LogStatus.INFO, "Product Total Charge = " +yearlyChargee);
				
				cAfterTrial = eachProduct.findElement(By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li["+productCount+"]/div/div/div/div/div[5]"));
				chargeAfterTrial =cAfterTrial.getText();
				test.log(LogStatus.INFO, "User will be Charged = " +chargeAfterTrial);
			 }

			else
			{
				pName=eachProduct.findElement(By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li[" + productCount + "]/div/div/div/header/h1"));
				prodName=pName.getText();
				test.log(LogStatus.INFO, "Product Plan ==================================================== " +prodName);
				
				pDescription=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[2]/span"));
				productDescription=pDescription.getText();
				test.log(LogStatus.INFO, "Product Description = " +productDescription);
				
				mCharge=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[3]"));

				monthlyCharge=mCharge.getText();
				test.log(LogStatus.INFO, "Product Monthly Charge = " +monthlyCharge);
				
				yCharge=eachProduct.findElement(By.xpath("//*[@class='products-container-list-wrap clearfix product-container-lists pull-left']/li[" +productCount+"]/div/div/div/div/div[4]"));
				yearlyChargee = yCharge.getText();
				test.log(LogStatus.INFO, "Product Total Charge = " +yearlyChargee);
				
				cAfterTrial = eachProduct.findElement(By.xpath("//*[@id='subscription-welcome-flow']/div[3]/div[1]/div/ul/li["+productCount+"]/div/div/div/div/div[5]"));
				chargeAfterTrial =cAfterTrial.getText();
				test.log(LogStatus.INFO, "User will be Charged = " +chargeAfterTrial);

			}
				
		 }
		
				test.log(LogStatus.INFO, "Total Product Shown on Product Page = " +productCount);
				images.takeScreenshot("ProductPageAfterSignUp", "ProductFirstPage");
			
				driver.findElement(selectPlan).click();
		 
		
			// https://staging-1.splashmath.com/?ab_override_signup_flow=web_subscription_trial_aug_2015:30_day:product_selection_first

		}
	
	}