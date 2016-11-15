package commonUtility;

import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebElementLocationOnPage 
{
	public WebDriver driver;
	public ExtentTest test;
	public WebElementLocationOnPage(WebDriver driver, ExtentTest test)
	{
		this.driver= driver;
		this.test=test;
	}
	
	public void getElementLocation(By elementName)
	{
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int browserWidth = (int) toolkit.getScreenSize().getWidth();
		int broswerHeight = (int) toolkit.getScreenSize().getHeight();
		Dimension screenResolution = new Dimension(browserWidth, broswerHeight);
		
		test.log(LogStatus.INFO, "Browser Height = "+ broswerHeight + " Browser Width = "+ browserWidth);
// to get Element Co-ordinate on Web Page		
	    Point point =	driver.findElement(elementName).getLocation();
		int xCordinate = point.getX();
		int yCordinate = point.getY(); 
		test.log(LogStatus.INFO, "X-Position = "+ xCordinate + " Y-Position = "+ yCordinate);	
 // To get element Height and Width on Page		
		int elementHeight=driver.findElement(elementName).getSize().getHeight();
		int elementWidth=driver.findElement(elementName).getSize().getWidth();
		test.log(LogStatus.INFO, "Element Height on Page = "+ elementHeight + "Width on Page = "+ elementWidth);
		
		
		
	}

}
