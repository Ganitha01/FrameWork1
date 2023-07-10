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
public class EditStudentTest extends BaseClass{
		ExcelUtility eutil=new ExcelUtility();
		WebDriverutility wutil=new WebDriverutility();
		PropertyUtility putil=new PropertyUtility();
		JavaUtility jutil=new JavaUtility();
		//generateRandomnumber
		int num=jutil.getRandomNumber();
		
		@Test(groups = {"regression","smoke"})
		public void createAndEditStudent() throws Throwable
		{
		
				//fech the data from excel file
				
				String PHONENO=eutil.fetchDataFromExcel("Student", 2, 19);
				String STUDENTFULLNAME=eutil.fetchDataFromExcel("Student", 2, 3);
				String STUDENTNAMEWITHINITIALS=eutil.fetchDataFromExcel("Student", 2, 4)+num;
				String STUDENTADDRESS=eutil.fetchDataFromExcel("Student", 2, 5);
				String STUDENTEMAIL=STUDENTNAMEWITHINITIALS+num+eutil.fetchDataFromExcel("Student", 2, 6);
				String STUDENTPHNO=eutil.fetchDataFromExcel("Student", 2, 7);
				String STUDENTDATEOFBIRTH=eutil.fetchDataFromExcel("Student", 2, 8);
				String STUDENTGENDER=eutil.fetchDataFromExcel("Student", 2, 9);
				String STUDENTCHOOSEFILE=eutil.fetchDataFromExcel("Student", 2, 10);
				String GUARDIANFULLNAME=eutil.fetchDataFromExcel("Student", 2, 11);
				String GUARDIANNAMEWITHINITIALS=eutil.fetchDataFromExcel("Student", 2, 12)+num;
				String GUARDIANADDRESS=eutil.fetchDataFromExcel("Student", 2, 13);
				String GUARDIANEMAIL=GUARDIANNAMEWITHINITIALS+num+eutil.fetchDataFromExcel("Student", 2, 14);
				String GUARDIANPHNO=eutil.fetchDataFromExcel("Student", 2, 15);
				String GUARDIANDATEOFBIRTH=eutil.fetchDataFromExcel("Student", 2, 16);
				String GUARDIANGENDER=eutil.fetchDataFromExcel("Student", 2, 17);
				String GUARDIANCHOOSEFILE=eutil.fetchDataFromExcel("Student", 2, 18);
				String GRADE=eutil.fetchDataFromExcel("Student", 2, 20)+num;
				String ADMISSIONFEE=eutil.fetchDataFromExcel("Student", 2, 21);
				String HALLCHARGES=eutil.fetchDataFromExcel("Student", 2, 22);
				String GRADERANGE=eutil.fetchDataFromExcel("Student", 2, 23);
				String GRADEVALUE=eutil.fetchDataFromExcel("Student", 2, 24);
				
		//create grade
		AdminDashBoardPreviewPage adbpPage=new AdminDashBoardPreviewPage(driver);
		adbpPage.clickOnGradeLnk();
		GradePreviewPage gpPage=new GradePreviewPage(driver);
		gpPage.createGrade(driver,wutil,GRADE, ADMISSIONFEE, HALLCHARGES, GRADERANGE, GRADEVALUE);
		//click on student link"
		Thread.sleep(3000);
		adbpPage.clickOnStudentLnk();
		adbpPage.clickOnAddStudentLnk();
		StudentPreviewPage spPage=new StudentPreviewPage(driver);
		spPage.addStudent(driver,""+num+"", STUDENTFULLNAME, STUDENTNAMEWITHINITIALS, STUDENTADDRESS, STUDENTEMAIL, STUDENTPHNO, STUDENTDATEOFBIRTH, 
				STUDENTGENDER, STUDENTCHOOSEFILE, GUARDIANFULLNAME, GUARDIANNAMEWITHINITIALS, GUARDIANADDRESS, GUARDIANEMAIL,
				GUARDIANPHNO, GUARDIANDATEOFBIRTH, GUARDIANGENDER, GUARDIANCHOOSEFILE,wutil,GRADE);
		//click on all students link
		adbpPage.clickOnAllStudentLnk();
		//select grade from the dropdown
		AllStudentPage asPage=new AllStudentPage(driver);
		asPage.selectGrade(GRADE, wutil);
		//verify whether student is created or not
		String createdStudent=asPage.verifyCreatedStudent(STUDENTNAMEWITHINITIALS);
		Assert.assertEquals(createdStudent.equalsIgnoreCase(STUDENTNAMEWITHINITIALS),true);
			Reporter.log("student added successfully",true);
		//goto particulastudent and click on edit button
		asPage.editStudent(wutil, PHONENO,driver);
		
		//System.out.println("student edited successfully");
		//Thread.sleep(4000);
		//verify the data modified is update or not
		String modifiePhNo=asPage.verifyModifiedData(wutil,driver,GRADE,STUDENTNAMEWITHINITIALS);
		Assert.assertTrue(modifiePhNo.contains(PHONENO));
			Reporter.log("student details edited successfully",true);
			//push to git hub successfully

	}
}
