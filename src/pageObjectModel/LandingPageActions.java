package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonUtility.SplashmathScreenShot;
import commonUtility.WindowHandling;
import verifyPresenceOfElement.VerifyElementOnWebPage;

public class LandingPageActions 
{
	public WebDriver driver;
	
	private By CurriculumLink = By.xpath("//li[@class='dropdown web-link curriculum-link-cont']");
	private By FeatureAndPlans =By.linkText("Features & Plans");
	private By FeaturePlan_AllLinks = By.xpath("//ul[@class='dropdown-menu header-dropdown-menu edition-wrapper']/li");
//	private By FeaturePlan_HomeEdition = By.xpath("//ul[@class='dropdown-menu header-dropdown-menu edition-wrapper']/li[1]");
//	private By FeaturePlan_ClassroomEdition = By.xpath("//ul[@class='dropdown-menu header-dropdown-menu edition-wrapper']/li[3]");
	
	private By CaseStudies = By.linkText("Case Studies");
	private By caseStudy_parentLink= By.linkText("Parents");
	
	private By UserSignIn = By.linkText("Sign In");
	private By ParentSignUpButton = By.linkText("Parents, Get Started for Free");
	private By TeacherSignUpButton = By.linkText("Teachers, Get Started for Free");
	private By doSignUpButton = By.id("signup-button");
	private By teacherSignUpPage_createAccount=By.id("submit");
	
	private By footer_SplashmathGradeApp=By.linkText("Splash Math Grades 1-5 App");
	private By footer_KinderGartenMathApp=By.linkText("Kindergarten Math App");
	private By footer_Grade1MathApp=By.linkText("Grade 1 Math App");
	private By footer_Grade2MathApp=By.linkText("Grade 2 Math App");
	private By footer_Grade3MathApp=By.linkText("Grade 3 Math App");
	private By footer_Grade4MathApp=By.linkText("Grade 4 Math App");
	private By footer_Grade5MathApp=By.linkText("Grade 5 Math App");
	
	private By footer_KinderGartenMathFreeApp=By.linkText("Kindergarten Free Math App");
	private By footer_Grade1MathFreeApp=By.linkText("Grade 1 Free Math App");
	private By footer_Grade2MathFreeApp=By.linkText("Grade 2 Free Math App");
	private By footer_Grade3MathFreeApp=By.linkText("Grade 3 Free Math App");
	private By footer_Grade4MathFreeApp=By.linkText("Grade 4 Free Math App");
	private By footer_Grade5MathFreeApp=By.linkText("Grade 5 Free Math App");
	
	private By footer_KinderGartenMathWorksheet=By.linkText("Kindergarten Math Worksheets");
	private By footer_Grade1Worksheet=By.linkText("First Math Worksheets");
	private By footer_Grade2Worksheet=By.linkText("Second Grade Math Worksheets");
	private By footer_Grade3Worksheet=By.linkText("Third Grade Math Worksheets");
	private By footer_Grade4Worksheet=By.linkText("Fourth Grade Math Worksheets");
	private By footer_Grade5Worksheet=By.linkText("Fifth Grade Math Worksheets");

	private By footer_AboutUs=By.linkText("About Us");
	private By footer_ContactUs=By.linkText("Contact Us");
	private By footer_SplashmathBlog=By.linkText("Splash Math Blog");
	private By footer_SplashmathReviews=By.linkText("Splash Math Reviews");
	private By footer_SplashmathApps=By.linkText("Splash Math Apps");
	private By footer_Affiliates=By.linkText("Affiliates");
	private By footer_Help=By.linkText("Help");
	private By footer_customerCare=By.linkText("help@splashmath.com");
	
	private By footer_FacebookIcon=By.linkText("Facebook");
	private By footer_GooglePlusIcon_=By.linkText("Google Plus");
	private By footer_TwitterIcon=By.linkText("Twitter");
	private By footer_PinterestIcon=By.linkText("Pinterest");
	private By footer_PrivacyPolicyIcon=By.linkText("PRIVACY POLICY");
	private By footer_TermsOfUseIcon=By.linkText("Terms of Use");
	
	// To find All Grade and its content in Curriculum section
	private By allGradeContent=By.xpath("//div[@class='curriculum-cloud-wrap clearfix js-curriculum-cloud-wrap']/ul");
	private By allGradeContentData=By.xpath("//div[@class='curriculum-cloud-wrap clearfix js-curriculum-cloud-wrap']/ul/li");
	
	
	//Teacher SignIn button on SignIn modal
	private By signInModal_teacherSignInButton= By.xpath("//div[@id='login-modal']/div/div/div/div[2]/ul/li[1]/a");
	private By SignInModal_allSignInLinks=By.xpath("//div[@id='login-modal']/div/div/div/div[2]/ul/li");
	
	private By Footer_KidSafeCertificateLogo ;
	
	public VerifyElementOnWebPage verifyElement;
	public SplashmathScreenShot images;
	public ExtentTest test;
	public WindowHandling windowTab;
	
	public LandingPageActions(WebDriver driver, ExtentTest test)
	{
		this.driver= driver;
		this.test=test;
	}

	public void clickCurriculumLink()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		elementStatus = verifyElement.isElementPresent(CurriculumLink);
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		
		if(elementStatus)
		{
			driver.findElement(CurriculumLink).click();
			test.log(LogStatus.INFO, "User clicked on  Curriculum Link");
			
			WebDriverWait gradePage= new WebDriverWait(driver,10);
			gradePage.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='curriculum-cloud-wrap clearfix js-curriculum-cloud-wrap']/ul/li[2]/a"))));
			
			images.takeScreenshot("Curriculum", "CurriculumPage");
			  elementStatus=verifyElement.isElementPresent(allGradeContent);
			  	if(elementStatus)
			  		{
			  			try
			  			{
			  			test.log(LogStatus.INFO, "User on Curriculum Page");
			  			int gradeCount=0;
			  			List<WebElement> allGrades= driver.findElements(allGradeContentData);
			  			  for(WebElement eachGrade : allGrades)
			  			  {
			  				 gradeCount++;
			  				WebElement	name= driver.findElement(By.xpath("//div[@class='curriculum-cloud-wrap clearfix js-curriculum-cloud-wrap']/ul/li[" + gradeCount +"]/a/p"));
			  				test.log(LogStatus.INFO, +gradeCount+ ") " + "Grade Name = " + name.getText());
			  				WebElement	skillCount= driver.findElement(By.xpath("//div[@class='curriculum-cloud-wrap clearfix js-curriculum-cloud-wrap']/ul/li[" + gradeCount +"]/a/span"));
			  				test.log(LogStatus.INFO, "Skill Count = " + skillCount.getText());
			  			  }
			  			  
			  			}
			  			catch(Exception e)
			  			{
			  				test.log(LogStatus.INFO, e.getMessage());
			  			}
			  		}
			  	else
			  	{
			  		test.log(LogStatus.INFO, "Element to find content related data has changed");
			  	  test.log(LogStatus.FAIL, "Some Issue hs occured with Curriculum Link on Splashmath page");
			  	}
			
			
		}
		else
		{
	  		test.log(LogStatus.INFO, "Curriculum Link not found on Parent Landing Page");
	  		 test.log(LogStatus.FAIL, "Curriculum Link is missing or link has changed now");
		}
	}
	
	
	public void clickFeaturesAndPlanLink()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(FeatureAndPlans);
		
		if(elementStatus)
		{
			driver.findElement(FeatureAndPlans).click();
			test.log(LogStatus.INFO, "User clicked on Feature and Plan Link");
			images.takeScreenshot("FeatureAndPlan", "Feature and Plan");
			
			int linkCount =0;
			List<WebElement> AllLinksInFeaturePlan = driver.findElements(FeaturePlan_AllLinks);
			 for(WebElement eachLink : AllLinksInFeaturePlan)
			 {
				 linkCount ++;
				 if(linkCount % 2!=0)
				 {
					 WebElement subLink= driver.findElement(By.xpath("//ul[@class='dropdown-menu header-dropdown-menu edition-wrapper']/li[" + linkCount + "]/a"));
					 test.log(LogStatus.INFO, "Link inside Fature and Plan = " + subLink.getText());
				 }
			 }
			
		}
		else
		{
			test.log(LogStatus.INFO, "Feature and Plan Link is missing or is changed");
		}
	}
	
	
	public void clickCaseStudies()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(CaseStudies);
			driver.findElement(CaseStudies).click();
			if(elementStatus)
			{
				test.log(LogStatus.INFO, "User clicked on Case Studies");
				
				WebDriverWait parentLink=new WebDriverWait(driver,10);
				parentLink.until(ExpectedConditions.elementToBeClickable(caseStudy_parentLink));
				test.log(LogStatus.INFO, "User on Case Studies Page");
				test.log(LogStatus.INFO, "Current Page URL = " + driver.getCurrentUrl());
				images.takeScreenshot("CaseStudies", "CaseStudies");
				
			}
			else
			{
				test.log(LogStatus.INFO, "Case Studies link changed or is missing");
			}
		}
	
	public void clickUserSignInLink()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		
		elementStatus = verifyElement.isElementPresent(UserSignIn);
		
		if(elementStatus)
		{
			driver.findElement(UserSignIn).click();
			test.log(LogStatus.INFO, "User clicked on SignIn Button");
			WebDriverWait signInModal= new WebDriverWait(driver,10);
			signInModal.until(ExpectedConditions.elementToBeClickable(signInModal_teacherSignInButton));
			test.log(LogStatus.INFO, "User SignIn modal appeared");
			images.takeScreenshot("SignInModal", "UserSignInModal");
			
			int count =0;
			List<WebElement>allSignInLinks=driver.findElements(SignInModal_allSignInLinks);
			for(WebElement eachSignIn:allSignInLinks)
			{
				count++;
				WebElement userSignInType= driver.findElement(By.xpath("//div[@id='login-modal']/div/div/div/div[2]/ul/li[" +count + "]/a"));
				test.log(LogStatus.INFO, count+ ") "+ "User Type = "+ userSignInType.getText());
			}
		}
		
		else
		{
			test.log(LogStatus.INFO,"User SignIn Button missing or changed");
		}
	}
	
	public void clickParentSignUpLink()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		
		elementStatus = verifyElement.isElementPresent(ParentSignUpButton);
		if(elementStatus)
		{
			test.log(LogStatus.INFO, "Parent SignUp Button found");
			driver.findElement(ParentSignUpButton).click();
			test.log(LogStatus.INFO, "User clicked on Parent SignUp Button");
			WebDriverWait signUpButton= new WebDriverWait(driver,20);
			signUpButton.until(ExpectedConditions.elementToBeClickable(driver.findElement(doSignUpButton)));
			test.log(LogStatus.INFO, "Parent SignUp Form Page has opened");
			images.takeScreenshot("ParentSignUp", "ParentSignUp");
		}
		else
		{
			test.log(LogStatus.INFO, "Parent SignUp Button missing or have changed");
		}
		
	}
	
	public void clickTeacherSignUpButton()
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		boolean elementStatus = false;
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		
		elementStatus = verifyElement.isElementPresent(TeacherSignUpButton);
		if(elementStatus)
		{
			driver.findElement(TeacherSignUpButton).click();
			test.log(LogStatus.INFO, "User clicked on Teacher SignUp Button");
			//teacherSignUpPage_createAccount
			WebDriverWait createAccount = new WebDriverWait(driver,10);
			createAccount.until(ExpectedConditions.elementToBeClickable(teacherSignUpPage_createAccount));
			test.log(LogStatus.INFO, "User on Teacher SignUp form page");
			images.takeScreenshot("TeacherSignUp", "TeacherSignUp");
			test.log(LogStatus.INFO, "Teacher SignUp Page URL = " + driver.getCurrentUrl());		
		}
		else
		{
			test.log(LogStatus.INFO, "Teacher SignUp button missing or has changed");
		}
	}
	
	public void clickPremiumSplashmathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_SplashmathGradeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium SplashMathApp", "Splashmath_Premium_App", footer_SplashmathGradeApp);
			test.log(LogStatus.INFO, "User clicked on Premium Splashmath App link");
			test.log(LogStatus.INFO, "Splashmath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Splashmath App link missing or has changed");
		}
	}
	
	public void clickPremiumKinderGartenMathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_KinderGartenMathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium KinderGarten", "KinderGarten_Premium_App", footer_KinderGartenMathApp);
			test.log(LogStatus.INFO, "User clicked on Premium KinderGarten App link");
			test.log(LogStatus.INFO, "Splashmath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium KinderGarten App link missing or has changed");
		}
	}
	public void clickPremiumGrade1MathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade1MathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium Grade1", "Grade1_Premium_App", footer_Grade1MathApp);
			test.log(LogStatus.INFO, "User clicked on Premium Grade1 Math App link");
			test.log(LogStatus.INFO, "Grade1_Math App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Grade1 Math App link missing or has changed");
		}
	}
	
	public void clickPremiumGrade2MathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade2MathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium Grade2", "Grade2_Premium_App", footer_Grade2MathApp);
			test.log(LogStatus.INFO, "User clicked on Premium Grade2 Math App link");
			test.log(LogStatus.INFO, "Grade2_Math App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Grade2 Math App link missing or has changed");
		}
	}
	
	public void clickPremiumGrade3MathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade3MathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium Grade3", "Grade3_Premium_App", footer_Grade3MathApp);
			test.log(LogStatus.INFO, "User clicked on Premium Grade3 Math App link");
			test.log(LogStatus.INFO, "Grade3_Math App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Grade3 Math App link missing or has changed");
		}
	}
	
	public void clickPremiumGrade4MathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade4MathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium Grade4", "Grade3_Premium_App", footer_Grade4MathApp);
			test.log(LogStatus.INFO, "User clicked on Premium Grade4 Math App link");
			test.log(LogStatus.INFO, "Grade4_Math App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Grade4 Math App link missing or has changed");
		}
	}
	public void clickPremiumGrade5MathAppLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade5MathApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Premium Grade5", "Grade5_Premium_App", footer_Grade5MathApp);
			test.log(LogStatus.INFO, "User clicked on Premium Grade5 Math App link");
			test.log(LogStatus.INFO, "Grade4_Math App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Premium Grade5 Math App link missing or has changed");
		}
	}
	
	public void clickKindergartenFreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_KinderGartenMathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_KinderGartenMathApp", "KinderGarten_Free_Math_App", footer_KinderGartenMathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Kindergarten Math App link");
			test.log(LogStatus.INFO, "Kindergarten_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Kindergarten_FreeMath App link missing or has changed");
		}
	}
	
	public void clickGrade1FreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade1MathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_Grade1MathApp", "Grade1_FreeMath_App", footer_Grade1MathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Grade1 Math App link");
			test.log(LogStatus.INFO, "Grade1_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Grade1_FreeMath App link missing or has changed");
		}
	}
	
	public void clickGrade2FreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade2MathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_Grade2MathApp", "Grade2_Free_Math_App", footer_Grade2MathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Grade2 Math App link");
			test.log(LogStatus.INFO, "Grade2_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Grade2_FreeMath App link missing or has changed");
		}
	}
	
	public void clickGrade3FreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade3MathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_Grade3MathApp", "Grade3_Free_Math_App", footer_Grade3MathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Grade3 Math App link");
			test.log(LogStatus.INFO, "Grade3_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Grade3_FreeMath App link missing or has changed");
		}
	}
	
	public void clickGrade4FreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade4MathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_Grade4MathApp", "Grade4_Free_Math_App", footer_Grade4MathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Grade4 Math App link");
			test.log(LogStatus.INFO, "Grade4_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Grade4_FreeMath App link missing or has changed");
		}
	}
	
	public void clickGrade5FreeMathLink() throws Exception
	{
		verifyElement = new VerifyElementOnWebPage(driver);
		images= new SplashmathScreenShot(driver);
		windowTab = new WindowHandling(driver);
		boolean elementStatus = false;
		
		test.log(LogStatus.INFO, "User on Splashmath Landing Page");
		elementStatus = verifyElement.isElementPresent(footer_Grade5MathFreeApp);
		
		if(elementStatus)
		{
			windowTab.onWindow("Free_Grade5MathApp", "Grade5_Free_Math_App", footer_Grade5MathFreeApp);
			test.log(LogStatus.INFO, "User clicked on Free Grade5 Math App link");
			test.log(LogStatus.INFO, "Grade5_FreeMath App web page opend on new tab");
			
		}
		else
		{
			test.log(LogStatus.INFO, "Grade5_FreeMath App link missing or has changed");
		}
	}
	
	
	
	
}
