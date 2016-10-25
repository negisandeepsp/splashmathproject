package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.WaitForSometime;

public class AddChildPage 
{
			public WebDriver driver;
			public ExtentTest test;
			public WaitForSometime needWait;
			
			private By childName = By.xpath("//*[@id='add_child_form']/div[1]/input");
			private By boyOrGirl = By.xpath("//*[@id='add_child_form']/div[2]/div/div/div/ul/li[1]/a");
			private By ChildGrade=By.xpath("//*[@id='add_child_form']/div[3]/div/select");
	
			private By isChildHomeSchooled = By.xpath("//*[@id='add_child_form']/div[4]/div/div/div/ul/li[1]/a");
			private By childLearningGoal=By.xpath("//*[@id='add_child_form']/div[5]/div/div/select");
			private By childHaveiPad=By.xpath("//*[@id='add_child_form']/div[6]/div/div/div/ul/li[1]/a");
			private By submitChildDetails=By.xpath("//*[@id='add_child_form']/div[7]/input");
			
			
	public AddChildPage(WebDriver driver, ExtentTest test)
	{
		this.driver= driver;
		this.test= test;
		
	}
	
	public String fillChildDetails()
	{
		String userFlow=" ";
		
		needWait = new WaitForSometime();
		
		driver.findElement(childName).sendKeys("sandeep");
		test.log(LogStatus.INFO, "User entertered Child's Name");
		driver.findElement(boyOrGirl).click();
		test.log(LogStatus.INFO, "User select Child's Gender");
		
		Select childGrade= new Select(driver.findElement(ChildGrade));
		childGrade.selectByVisibleText("Grade 1");
		
		test.log(LogStatus.INFO, "User Selects Child's Grade");
		
		driver.findElement(isChildHomeSchooled).click();
		test.log(LogStatus.INFO, "User Selects Child Home School option");
		
		Select childGoalType=new Select(driver.findElement(childLearningGoal));
		childGoalType.selectByVisibleText("Get Ahead");
		
		test.log(LogStatus.INFO, "User Selects Child's Goal");
		driver.findElement(childHaveiPad).click();
		test.log(LogStatus.INFO, "User select do Child Have iPad at Home option");
		
		driver.findElement(submitChildDetails).click();
		test.log(LogStatus.INFO, "User have filled form and selected Next Button");
	//	needWait.doWaitForSometime();
		
				JavascriptExecutor js = (JavascriptExecutor) driver; 
		//		test.log(LogStatus.INFO, " UserSignUp Flow Set => " + js.executeScript("return REGISTRY.currentUser.signupFlow;").toString()) ;
				userFlow = js.executeScript("return REGISTRY.currentUser.signupFlow;").toString();
	//			System.out.println(userFlow);
	
		return userFlow;
	}
}
