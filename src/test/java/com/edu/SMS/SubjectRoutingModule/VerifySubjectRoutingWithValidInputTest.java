package com.edu.SMS.SubjectRoutingModule;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.edu.ObjectRepository.AdminDashBoardPreviewPage;
import com.edu.ObjectRepository.AllTeacherPreviewPage;
import com.edu.ObjectRepository.GradePreviewPage;
import com.edu.ObjectRepository.SubjectPreviewPage;
import com.edu.ObjectRepository.SubjectRoutingPage;
import com.edu.ObjectRepository.TeacherPreviewPage;
import smsGenericUtilities.BaseClass;
import smsGenericUtilities.ExcelUtility;
import smsGenericUtilities.JavaUtility;
import smsGenericUtilities.PropertyUtility;
import smsGenericUtilities.WebDriverutility;
@Listeners(smsGenericUtilities.ListenersImplementation.class)
public class VerifySubjectRoutingWithValidInputTest extends BaseClass {

	ExcelUtility eutil=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverutility wutil=new WebDriverutility();
	PropertyUtility putil=new PropertyUtility();
	//generating random number
	int num=jutil.getRandomNumber();

	@Test
	public void createAndEditSubjectRouting() throws Throwable{
		//fech the data from excel file
		String TEACHERNAME=eutil.fetchDataFromExcel("SubjectRoutin", 4, 2)+num;
		String ADDRESS=eutil.fetchDataFromExcel("SubjectRoutin", 4, 3);
		String GENDER=eutil.fetchDataFromExcel("SubjectRoutin", 4, 4);
		String PHONENO=eutil.fetchDataFromExcel("SubjectRoutin", 4, 5);
		String TEACHERUSERNAME=eutil.fetchDataFromExcel("SubjectRoutin", 4, 6);
		String GRADE=eutil.fetchDataFromExcel("SubjectRoutin", 4, 7)+num;
		String ADMISSIONFEE=eutil.fetchDataFromExcel("SubjectRoutin", 4, 8);
		String HALLCHARGES=eutil.fetchDataFromExcel("SubjectRoutin", 4, 9);
		String GRADERANGE=eutil.fetchDataFromExcel("SubjectRoutin", 4, 10);
		String GRADEVALUE=eutil.fetchDataFromExcel("SubjectRoutin", 4, 11);
		String SUBJECT=eutil.fetchDataFromExcel("SubjectRoutin", 4, 12)+num;
		String TEACHERFEE=eutil.fetchDataFromExcel("SubjectRoutin",4, 13);
		String FILEUPLOAD=eutil.fetchDataFromExcel("SubjectRoutin", 4, 14);
		//create teacher
		//click on add teacher
		String TeacherUserName=TEACHERNAME+TEACHERUSERNAME;
		AdminDashBoardPreviewPage adbpPage=new AdminDashBoardPreviewPage(driver);
		adbpPage.clickOnAddTeacherLnk();
		TeacherPreviewPage tPage=new TeacherPreviewPage(driver);
		tPage.createTeacher(driver,wutil, num, TEACHERNAME, TEACHERNAME, ADDRESS, GENDER,PHONENO,TeacherUserName, FILEUPLOAD);
		//check whether the teacher is created or not
		adbpPage.clickOnAllTeacherLnk();
	//enter teacher name in search bar
		AllTeacherPreviewPage atpPage=new AllTeacherPreviewPage(driver);
		String createdTeacher=atpPage.fetchCreatedTeacher(TEACHERNAME);
		//verify the name is present or not
		Assert.assertTrue(createdTeacher.equalsIgnoreCase(TEACHERNAME));
		Reporter.log("Teacher created successfully",true);

		//create grade
		adbpPage.clickOnGradeLnk();
		GradePreviewPage gpPage=new GradePreviewPage(driver);
		gpPage.createGrade(driver,wutil,GRADE, ADMISSIONFEE, HALLCHARGES, GRADERANGE, GRADEVALUE);
		//verify whether the grade is created or not
		//enter the grade into search bar
		String createdGrade=gpPage.fetchCreatedGrade(GRADE);
		
		//comparing with the actual grade
		Assert.assertTrue(createdGrade.equalsIgnoreCase(GRADE));
		Reporter.log("grade created successfully",true);
		//create subject
		//click on subject link
		adbpPage.ClickOnSubjectLnk();
		SubjectPreviewPage spPage=new SubjectPreviewPage(driver);
		spPage.createSuject(driver,wutil,SUBJECT);
		//verify whethersubjct is created or not
		String createdSubject=spPage.fetchCreatedSubject(SUBJECT);
		Assert.assertTrue(createdSubject.equalsIgnoreCase(SUBJECT));
		Reporter.log("subject created successfully",true);
		//click on subject routing
		adbpPage.clickOnSubjectRoutingLnk(wutil,driver);
		SubjectRoutingPage srPage=new SubjectRoutingPage(driver);
		srPage.addSubjectRouting(driver,TEACHERFEE, wutil, GRADE, SUBJECT, TEACHERNAME);
		//verify whether the shubjectrouting added or not
		List<WebElement> subjectroutings=srPage.fetchCreatedSubjectRouting(TEACHERNAME);
		for(int i=0;i<subjectroutings.size();i++)
		{ String text=subjectroutings.get(i).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains(createdGrade)&&text.contains(createdSubject)&&text.contains(TEACHERNAME));
			Reporter.log("subject routing added successfully",true);
			
		}
		
	}

}
