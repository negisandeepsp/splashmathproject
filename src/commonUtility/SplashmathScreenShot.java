package commonUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

	public class SplashmathScreenShot {
	public WebDriver driver ;
	
	//https://github.com/anshooarora/extentreports-java/issues/243
	
	public SplashmathScreenShot(WebDriver driver)
	{
		this.driver = driver;
	}

	public String takeScreenshot(String FolderName , String imageName)
	{
		
		try 
		{
			TakesScreenshot photo=(TakesScreenshot)driver;
			File source = photo.getScreenshotAs(OutputType.FILE);
			
			String dest = "./ReportSummary/"+ "ScreenShots/" + FolderName+ "/" + imageName + ".png";
			File destination = new File(dest);
			
			FileUtils.copyFile(source, destination);
			System.out.println(imageName + " ScreenShot Taken");
			
			return dest;
		} 
		
		catch (Exception e) 
		{
			System.out.println("Exception while taking Screenshot" + e.getMessage());
			return e.getMessage();
		}
		
		
	}

}
