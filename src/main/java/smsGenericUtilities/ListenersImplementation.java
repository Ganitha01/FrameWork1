package smsGenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodeName=result.getMethod().getMethodName();
		test=report.createTest(methodeName);
		Reporter.log(methodeName+"===TEst script execution STARTED===");
		System.out.println(methodeName+"===TEst script execution STARTED===");
	}

	public void onTestSuccess(ITestResult result) {
		String methodeName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodeName+"---passed");
		Reporter.log(methodeName+"===TEst script execution PASSED===");
		System.out.println(methodeName+"===TEst script execution PASSED===");
	}

	public void onTestFailure(ITestResult result) {
		String methodeName=result.getMethod().getMethodName();
		test.log(Status.FAIL, methodeName+"----failed");
		test.log(Status.FAIL,result.getThrowable());
		System.out.println(methodeName+"===TEst script execution FAILED===");
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime localDateTime=LocalDateTime.now();
		String dateTime=localDateTime.toString().replace(" ", "_").replace(":", "-");
		File dst=new File("./screenShot/"+""+methodeName+""+""+dateTime+""+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath("./screenShot/"+""+methodeName+""+""+dateTime+""+".png");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodeName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodeName+"----skipped");
		test.log(Status.SKIP,result.getThrowable());
		System.out.println(methodeName+"===TEst script execution SKIPPED===");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//configuration means how my report look like
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-48 batch");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SMS");
		//create a report
		 report=new ExtentReports();
		 
		//attaching the configuration to report
		report.attachReporter(htmlreport);
		
		//data should be displayed in the report
		
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Url", "https://locaHost:8080");
		report.setSystemInfo("reportName", "anitha");
	System.out.println("----------suite level execution starts------------");
	}

	public void onFinish(ITestContext context) {
		System.out.println("----------suite level execution ends------------");
		report.flush();
	}
	

}
