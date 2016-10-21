package commonUtility;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LinkOnPage 
{
	public WebDriver driver;
	public ExtentTest test;
 public LinkOnPage(WebDriver driver, ExtentTest test)
 {
	 this.driver=driver;
	 this.test=test;
 }
 
 public boolean verifyActiveLink(String linkUrl)
 {
	 boolean linkStatus=false;
	 try
	 {
		 URL url = new URL(linkUrl);
		 HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		 httpURLConnect.setConnectTimeout(3000);
		 httpURLConnect.connect();
		 
		 if(httpURLConnect.getResponseCode()==200)
         {
            test.log(LogStatus.INFO, linkUrl +" - "+httpURLConnect.getResponseMessage());
          linkStatus = true;
          }
        if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
         {
        	test.log(LogStatus.INFO, linkUrl +" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
        	linkStatus = false;
          }
		 
	 }
	 catch(Exception e)
	 {
		 test.log(LogStatus.INFO, "Some Exception has occured" + e.getMessage());
	 }
	
	 return linkStatus;
 }
}
