package com.edu.SMS.SubjectModule;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.edu.ObjectRepository.AdminDashBoardPreviewPage;
import com.edu.ObjectRepository.AllStudentPage;
import com.edu.ObjectRepository.GradePreviewPage;
import com.edu.ObjectRepository.StudentPreviewPage;
import smsGenericUtilities.BaseClass;
import smsGenericUtilities.ExcelUtility;
import smsGenericUtilities.JavaUtility;
import smsGenericUtilities.PropertyUtility;
import smsGenericUtilities.WebDriverutility;
@Listeners(smsGenericUtilities.ListenersImplementation.class)
public class CreateStudentMapTest extends BaseClass {
		ExcelUtility eutil=new ExcelUtility();
		WebDriverutility wutil=new WebDriverutility();
		PropertyUtility putil=new PropertyUtility();
		JavaUtility jutil=new JavaUtility();
		int num=jutil.getRandomNumber();
		@Test(groups = "smoke")
		public void createStudent() throws Throwable
		{
				//fetch the data from excel
				String GRADE=eutil.fetchDataFromExcel("Student", 2, 20)+num;
				String ADMISSIONFEE=eutil.fetchDataFromExcel("Student", 2, 21);
				String HALLCHARGES=eutil.fetchDataFromExcel("Student", 2, 22);
				String GRADERANGE=eutil.fetchDataFromExcel("Student", 2, 23);
				String GRADEVALUE=eutil.fetchDataFromExcel("Student", 2, 24);
				String STUDENTNAMEWITHINITIALS=eutil.fetchDataFromExcel("CreateStudent", 2, 1);
		//create grade
				AdminDashBoardPreviewPage adbpPage=new AdminDashBoardPreviewPage(driver);
				adbpPage.clickOnGradeLnk();
				GradePreviewPage gpPage=new GradePreviewPage(driver);
				gpPage.createGrade(driver,wutil,GRADE, ADMISSIONFEE, HALLCHARGES, GRADERANGE, GRADEVALUE);
				//click on student link"
				adbpPage.clickOnStudentLnk();
				adbpPage.clickOnAddStudentLnk();
			
			//create student using HapMap
				StudentPreviewPage spPage=new StudentPreviewPage(driver);
				int num1=spPage.createStudent(eutil.getMultipleData("CreateStudent"), driver, jutil, wutil, GRADE);
				//System.out.println(eutil.getMultipleData("CreateStudent"));
				//System.out.println("student created successfully");
				
				//verify whether it is creted or not
				adbpPage.clickOnAllStudentLnk();
				//select grade from the dropdown
				AllStudentPage asPage=new AllStudentPage(driver);
				asPage.selectGrade(GRADE, wutil);
				//verify whether student is created or not
				String createdStudent=asPage.verifyCreatedStudent(STUDENTNAMEWITHINITIALS+num1);
				Assert.assertTrue(createdStudent.equalsIgnoreCase(STUDENTNAMEWITHINITIALS+num1));
					Reporter.log("student added successfully",true);
	}

}
