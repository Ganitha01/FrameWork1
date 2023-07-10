package smsGenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		int count=4;
		while(count>0)
		{
			count--;
			return true;
		}
			return false;
		}
	}
	
