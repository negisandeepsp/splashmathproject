package commonUtility;

public class WaitForSometime 
{
	public void doWaitForSometime()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("Waiting for sometime" +e.getMessage());
		}
	}
}
