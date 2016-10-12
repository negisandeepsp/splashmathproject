package basic;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import screenShot.SplashmathScreenShot;

public class Base 
{
	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforeSuite()
	{
		extent = new ExtentReports("C:\\Users\\STUDYPAD\\workspace\\ProjectSplashmath\\ReportSummary\\SplashmathReport.html",true);
		extent.config();
		extent.addSystemInfo("Environment","QA Testing");
	}
	
	@BeforeMethod
	
	public void openBrowser()
	{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\STUDYPAD\\Downloads\\sandeep\\jar\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenResolution = new Dimension((int) 
			toolkit.getScreenSize().getWidth(), (int) 
			toolkit.getScreenSize().getHeight());
					
			driver.manage().window().setSize(screenResolution);
			
			driver.get("https://staging-1.splashmath.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		extent.endTest(test);
		extent.flush();  
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		driver.get("C:\\Users\\STUDYPAD\\workspace\\ProjectSplashmath\\ReportSummary\\SplashmathReport.html");
		extent.close();
	}

}
