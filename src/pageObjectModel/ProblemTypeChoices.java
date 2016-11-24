package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonUtility.SplashmathScreenShot;
import commonUtility.WaitForSometime;

public class ProblemTypeChoices 
{
	public WebDriver driver;
	public ExtentTest test;
	public WaitForSometime needWait;
	public SplashmathScreenShot images;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[3]/div/div[1]")
	WebElement optionFishOne;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[3]/div/div[2]")
	WebElement optionFishTwo;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[3]/div/div[3]")
	WebElement optionFishThree;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[3]/div/div[4]")
	WebElement optionFishFour;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[2]/div/div[1]")
	WebElement optionBirdFirst;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[2]/div/div[2]")
	WebElement optionBirdTwo;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[2]/div/div[3]")
	WebElement optionBirdThree;
	
	@FindBy(xpath="//*[@id='sky-cont-container']/div[1]/div[1]/div[2]/div[2]/div/div[4]")
	WebElement optionBirdFour;
	
	public ProblemTypeChoices(WebDriver driver , ExtentTest test)
	{
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	public void giveAnswerofChoicesProblemType()
	{
		images = new SplashmathScreenShot(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		needWait = new WaitForSometime();
		// userFlow = js.executeScript("return REGISTRY.currentUser.signupFlow;").toString();
		String answerOption =" ";
		int i=1;
		while(i<21)
		{
			System.out.println(driver.findElement(By.xpath("//div[contains(@class,'btn-choice-table')]")).getAttribute("class"));
			String choiceVisibleOnScreen= driver.findElement(By.xpath("//div[contains(@class,'btn-choice-table')]")).getAttribute("class");
			
		// btn-choice-table pt-choices    num-choices-4 per-row-4  green-choices   => 4 fish in a row
		// btn-choice-table pt-choices    num-choices-4 per-row-2  orange-choices  => 2 * 2 flat fish
		// btn-choice-table pt-choices   centered num-choices-4 per-row-2  green-choices => 2 * 2 Fish on centre of screen
			
			if(choiceVisibleOnScreen.contains("num-choices-4 per-row-4"))
			{
				System.out.println("4 fish in a row");
				answerOption = js.executeScript(" return SPWProblem.quesData.correct_answer;").toString();
				int answer = Integer.parseInt(answerOption);
				 	
					if (answerOption.equals("0"))
				 	{
						optionFishOne.click();
						images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
						needWait.doWaitForSometime();
				 	}
				 	else if (answerOption.equals("1"))
				 	{
				 		optionFishTwo.click();
				 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
				 		needWait.doWaitForSometime();
				 		
				 	}
				 	else if (answerOption.equals("2"))
				 	{
				 		optionFishThree.click();
				 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
				 		needWait.doWaitForSometime();
				 	}
				 	else
				 	{
				 		optionFishFour.click();
				 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
				 		needWait.doWaitForSometime();
				 	}
				
			}
	
			else if(choiceVisibleOnScreen.contains("num-choices-4 per-row-2"))
			{
				System.out.println("2*2 fish in a row");
				if (answerOption.equals("0"))
			 	{
					optionFishOne.click();
					images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
					needWait.doWaitForSometime();
			 	}
			 	else if (answerOption.equals("1"))
			 	{
			 		optionFishTwo.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 		
			 	}
			 	else if (answerOption.equals("2"))
			 	{
			 		optionFishThree.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 	}
			 	else
			 	{
			 		optionFishFour.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 	}
			}
			
			else if (choiceVisibleOnScreen.contains("centered num-choices-4 per-row-2"))
			{
				System.out.println("Birds in centre");
				if (answerOption.equals("0"))
			 	{
					optionBirdFirst.click();
					images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
					needWait.doWaitForSometime();
			 	}
			 	else if (answerOption.equals("1"))
			 	{
			 		optionBirdTwo.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 		
			 	}
			 	else if (answerOption.equals("2"))
			 	{
			 		optionBirdThree.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 	}
			 	else
			 	{
			 		optionBirdFour.click();
			 		images.takeScreenshot("ProblemType_Choice", "Question "+i+")");
			 		needWait.doWaitForSometime();
			 	}
			}
			
			else
			{
				System.out.println("Some other choice type added now.....");
			}
			
			System.out.println("i=== " +i);
			needWait.doWaitForSometime();
			i++;
				
				
		}
		
	}

}
