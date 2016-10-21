package testCases;

import org.testng.annotations.Test;

import basic.Base;
import pageObjectModel.ParentSignUpFlowType;

public class UserSignUpFlowType extends Base 
{
	public ParentSignUpFlowType flowType;
	
	@Test
	public void verifySignUpFlow()
	{
		test = extent.startTest("Verify User SignUp Flow");
		flowType = new ParentSignUpFlowType(driver, test);
		
		flowType.enterUserCredentials();
		
	}

}
