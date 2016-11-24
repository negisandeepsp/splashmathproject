package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.WaitForSometime;

public class ParentDashboard 
{
	public WebDriver driver;
	public ExtentTest test;
	public WaitForSometime needWait;
	public ProblemTypeChoices questionType;
	
	@FindBy(id ="launch_child_dashboard_id")
	@CacheLookup
	WebElement loginStudentButton;
	
	@FindBy(id="playlist")
	@CacheLookup
	WebElement studentSkillTab;
	
	public ParentDashboard(WebDriver driver , ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void userOnStudentSkillPage()
	{
		questionType = new ProblemTypeChoices(driver, test);
		 needWait = new WaitForSometime();
		 loginStudentButton.click();
		 
		 WebDriverWait studentDashboard = new WebDriverWait(driver,10);
		 studentDashboard.until(ExpectedConditions.textToBePresentInElement(studentSkillTab, "Playlist"));
		 
		 driver.get("https://staging-1.splashmath.com/problem_types/13dd83f1-a59a-4408-8c80-32d996a6bfe0/display");
		 needWait.doWaitForSometime();
		 test.log(LogStatus.INFO, "User on Question Page");
		 questionType.giveAnswerofChoicesProblemType();
		 
	}
}
