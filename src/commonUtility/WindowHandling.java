package commonUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandling {
	public SplashmathScreenShot image;
	public WebDriver driver;
	
	public WindowHandling(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void onWindow(String folderName, String imageName, By element) throws Exception
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
				image.takeScreenshot(folderName, imageName);
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		
	}

}
