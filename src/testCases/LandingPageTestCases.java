package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;
import commonUtility.SplashmathScreenShot;
import pageObjectModel.LandingPageActions;
import verifyPresenceOfElement.VerifyElementOnWebPage;

public class LandingPageTestCases extends Base
{
	public VerifyElementOnWebPage verifyElement;
	public SplashmathScreenShot images;
	public LandingPageActions landingPage;
	
	@Test
	public void verifyCurriculumLink()
	{
		test = extent.startTest("Verify CurriculumPage on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickCurriculumLink();
 
	}

	
	@Test
	 public void verifyFeatureAndPlanLink()
	 {
		 	test = extent.startTest("Verify Feature And Plan Link on Splashmath Page");
			landingPage = new LandingPageActions(driver,test);
			landingPage.clickFeaturesAndPlanLink();
	 }
	
	@Test
	public void verifyCaseStudiesLink()
	{
		test = extent.startTest("Verify Case Studies Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickCaseStudies();
	}
	
	@Test 
	public void verifySignInLink()
	{
		test = extent.startTest("Verify User SignIn Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickUserSignInLink();
	}
	
	@Test
	public void verifyParentSignUpButton()
	{
		test = extent.startTest("Verify Parent SignUp Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickParentSignUpLink();
	}
	
	@Test
	public void verifyTeacherSignUpButton()
	{
		test = extent.startTest("Verify Teacher SignUp Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickTeacherSignUpButton();
	}
	
	@Test
	public void verifyPremiumSplashmathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Splashmath App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumSplashmathAppLink();
	}
	
	@Test
	public void verifyKinderGartenMathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium KinderGarten_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumKinderGartenMathAppLink();
	}
	
	@Test
	public void verifyGrade1MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Grade1_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumGrade1MathAppLink();
	}
	@Test
	public void verifyGrade2MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Grade2_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumGrade2MathAppLink();
	}
	
	@Test
	public void verifyGrade3MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Grade3_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumGrade3MathAppLink();
	}
	
	@Test
	public void verifyGrade4MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Grade4_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumGrade4MathAppLink();
	}
	
	@Test
	public void verifyGrade5MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Premium Grade5_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickPremiumGrade5MathAppLink();
	}
	
	@Test
	public void verifyFreeKindergartenMathAppLink() throws Exception
	{
		test = extent.startTest("Verify Kindergarten_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickKindergartenFreeMathLink();
	}
	
	@Test
	public void verifyFreeGrade1MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Grade1_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickGrade1FreeMathLink();
	}
	
	@Test
	public void verifyFreeGrade2MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Grade2_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickGrade2FreeMathLink();
	}
	
	@Test
	public void verifyFreeGrade3MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Grade3_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickGrade3FreeMathLink();
	}
	
	@Test
	public void verifyFreeGrade4MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Grade4_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickGrade4FreeMathLink();
	}
	
	@Test
	public void verifyFreeGrade5MathAppLink() throws Exception
	{
		test = extent.startTest("Verify Grade5_Free_Math App Link on Splashmath Page");
		landingPage = new LandingPageActions(driver,test);
		landingPage.clickGrade5FreeMathLink();
	}
}
