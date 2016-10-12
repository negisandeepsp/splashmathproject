package verifyPresenceOfElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class VerifyElementOnWebPage 

{

	public WebDriver driver;
	
	public VerifyElementOnWebPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isElementPresent(By element) {
		   try 
		   {
		       driver.findElement(element);
		       return true;
		   } 
		   catch (NoSuchElementException e) 
		   {
		       return false;
		   }
		}

}
