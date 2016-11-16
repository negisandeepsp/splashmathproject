package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ParentDashboard 
{
	public WebDriver driver;
	public ExtentTest test;
	
	
	ParentDashboard(WebDriver driver , ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void userOnParentDashboard()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 test.log(LogStatus.INFO, " Is Tour Pop Up Visible on Parent Dashboard After SignUp => " + js.executeScript("return REGISTRY.tourShown;").toString()) ;
		//REGISTRY.tourShown
		// REGISTRY.assessmentsEnabled
		// REGISTRY.engagementChanges
		// REGISTRY.weeklyGoalsEnabled
	}
}
