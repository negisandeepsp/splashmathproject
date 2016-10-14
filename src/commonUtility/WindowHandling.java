package commonUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandling {
	SplashmathScreenShot image;
	WebDriver driver;
	
	public WindowHandling(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void onWindow(String folderName, String location, By element) throws Exception
	{
		image = new SplashmathScreenShot(driver);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(element).click();
		Set<String> childWindow=driver.getWindowHandles();
		for(String currentWindow: childWindow)
		{ 
			if(!parentWindow.equals(currentWindow))
			{
				driver.switchTo().window(currentWindow);
				Thread.sleep(1000);
				image.takeScreenshot(folderName, location);
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		
	}

}
