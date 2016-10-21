package commonUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ParentSignUpCredentials
{
	public String[] giveParentSignUpDetails()
	{
		String credentials[] = new String[2];
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());
		
		String parentEmail= "sn+" + dateAsString + "@splashmath.com";
		String password = "123456";
		credentials[0] = parentEmail;
		credentials[1] = password;
		
		return credentials;
	}
	
}
