package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basic.Base;
import commonUtility.SplashmathScreenShot;
import pageObjectModel.ParentDashboard;
import pageObjectModel.ParentSignIn;

public class ParentSignInUsingCredentials extends Base
{
	public SplashmathScreenShot images;
	public ParentSignIn userSignIn; 
	public ParentDashboard parentLogin;
	
	@Test
	public void userLogin()
	{
		test = extent.startTest("Verify Parent SignIn Flow");
		userSignIn = new ParentSignIn(driver,test);
		parentLogin = new ParentDashboard(driver, test);
	 //sn+1123092108@splashmath.com
		userSignIn.doParentSignIn("sn+1123092108@splashmath.com","123456");
		//	userSignIn.doParentSignIn("sn+1124095240@splashmath.com","123456");
		
		WebDriverWait childLoginButton = new WebDriverWait(driver,30);
		childLoginButton.until(ExpectedConditions.presenceOfElementLocated(By.id("launch_child_dashboard_id")));
		
		test.log(LogStatus.INFO, "Page Title" + driver.getTitle());
		Assert.assertEquals((driver.getTitle()), "Parent Dashboard - Splash Math");
		test.log(LogStatus.INFO, "User Lands on Parent Dashboard");
		parentLogin.userOnStudentSkillPage();
		
	}

}
