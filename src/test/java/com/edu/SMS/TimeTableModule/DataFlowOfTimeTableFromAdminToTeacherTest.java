package com.edu.SMS.TimeTableModule;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.edu.ObjectRepository.AdminDashBoardPreviewPage;
import com.edu.ObjectRepository.ClassRoomPreviewPage;
import com.edu.ObjectRepository.GradePreviewPage;
import com.edu.ObjectRepository.LoginPage;
import com.edu.ObjectRepository.SubjectPreviewPage;
import com.edu.ObjectRepository.SubjectRoutingPage;
import com.edu.ObjectRepository.TeacherDashBoardPreviewPage;
import com.edu.ObjectRepository.TeacherPreviewPage;
import com.edu.ObjectRepository.TeacherTimeTablePreviewPage;
import com.edu.ObjectRepository.TimeTablPreviewPage;
import smsGenericUtilities.BaseClass;
import smsGenericUtilities.ExcelUtility;
import smsGenericUtilities.JavaUtility;
import smsGenericUtilities.PropertyUtility;
import smsGenericUtilities.WebDriverutility;
@Listeners(smsGenericUtilities.ListenersImplementation.class)
public class DataFlowOfTimeTableFromAdminToTeacherTest extends BaseClass {

	
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverutility wutil=new WebDriverutility();
		PropertyUtility putil=new PropertyUtility();
		//generating random number
		int num=jutil.getRandomNumber();
		
		@Test(priority = 1)
		public void createTimeTable() throws Throwable
		{
			String PASSWORD=putil.fetchDataFromPropertiesFile("password");
		//fech the data from excel file
		String TEACHERNAME=eutil.fetchDataFromExcel("TimeTable", 1, 2)+num;
		String ADDRESS=eutil.fetchDataFromExcel("TimeTable", 1, 3);
		String GENDER=eutil.fetchDataFromExcel("TimeTable", 1, 4);
		String PHONENO=eutil.fetchDataFromExcel("TimeTable", 1, 5);
		String TEACHERUSERNAME=eutil.fetchDataFromExcel("TimeTable", 1, 6);
		String GRADE=eutil.fetchDataFromExcel("TimeTable", 1, 7)+num;
		String ADMISSIONFEE=eutil.fetchDataFromExcel("TimeTable", 1, 8);
		String HALLCHARGES=eutil.fetchDataFromExcel("TimeTable", 1, 9);
		String GRADERANGE=eutil.fetchDataFromExcel("TimeTable", 1, 10);
		String GRADEVALUE=eutil.fetchDataFromExcel("TimeTable", 1, 11);
		String SUBJECT=eutil.fetchDataFromExcel("TimeTable", 1, 12)+num;
		String TEACHERFEE=eutil.fetchDataFromExcel("TimeTable", 1, 13);
		String CLASSROOM=eutil.fetchDataFromExcel("TimeTable", 1, 14)+num;
		String DAY=eutil.fetchDataFromExcel("TimeTable", 1, 15);
		String STARTTIME=eutil.fetchDataFromExcel("TimeTable", 1, 16);
		String ENDTIME=eutil.fetchDataFromExcel("TimeTable", 1, 17);
		String FILETOUPLOAD=eutil.fetchDataFromExcel("Teacher", 1, 18);
		String STUDENTCOUNT=eutil.fetchDataFromExcel("Teacher", 1, 19);
		
		//create teacher* 
		AdminDashBoardPreviewPage adbpPage=new AdminDashBoardPreviewPage(driver);
		adbpPage.clickOnAddTeacherLnk();
		TeacherPreviewPage tpPage=new TeacherPreviewPage(driver);
		String TeacherUserName=TEACHERNAME+TEACHERUSERNAME;
		tpPage.createTeacher(driver,wutil, num, TEACHERNAME, TEACHERNAME, ADDRESS, GENDER, PHONENO, TeacherUserName, FILETOUPLOAD);
		//check whether the teacher is created or not
		adbpPage.clickOnAllTeacherLnk();
		String createdTeacher=tpPage.searchForTeacher(TEACHERNAME);
		//verify the name is present or not
		Assert.assertTrue(createdTeacher.equalsIgnoreCase(TEACHERNAME));
			Reporter.log("Teacher created successfully",true);

		//create grade
		adbpPage.clickOnGradeLnk();
		GradePreviewPage gpPage=new GradePreviewPage(driver);
		gpPage.createGrade(driver,wutil,GRADE, ADMISSIONFEE, HALLCHARGES, GRADERANGE, GRADEVALUE);
		//verify whether the grade is created or not
		String createdGrade=gpPage.fetchCreatedGrade(GRADE);
		//comparing with the actual grade
		Assert.assertTrue(createdGrade.equalsIgnoreCase(GRADE));
		Reporter.log("grade created successfully",true);
		
		//create subject
		adbpPage.ClickOnSubjectLnk();
		SubjectPreviewPage spPage=new SubjectPreviewPage(driver);
		spPage.createSuject(driver,wutil,SUBJECT);
		//verify whethersubjct is created or not
		String createdSubject=spPage.fetchCreatedSubject(SUBJECT);
		//compare the auctual subject with fetched text
		Assert.assertTrue(createdSubject.equalsIgnoreCase(SUBJECT));
		Reporter.log("subject created successfully",true);
		//click on subject routing
		adbpPage.clickOnSubjectRoutingLnk(wutil,driver);
		SubjectRoutingPage srPage=new SubjectRoutingPage(driver);
		srPage.addSubjectRouting(driver,TEACHERFEE, wutil, GRADE, SUBJECT, TEACHERNAME);
		//verify whether the shubjectrouting added or not
		List<WebElement> subjectRoutings=srPage.fetchCreatedSubjectRouting(TEACHERNAME);
		boolean status=false;
		for(int i=0;i<subjectRoutings.size();i++)
		{ String text=subjectRoutings.get(i).getText();
			if(text.contains(GRADE)&&text.contains(SUBJECT)&&text.contains(TEACHERNAME))
			{	
				status=true;
				
				break;
			}
			}
		Assert.assertTrue(status);
		Reporter.log("subject routing added successfully",true);
		//create class room
		adbpPage.clickOnClassRoomLnk();
		ClassRoomPreviewPage crPage=new ClassRoomPreviewPage(driver);
		crPage.createNewClassRoom(driver,wutil,CLASSROOM, STUDENTCOUNT);
		//verify whether class room created or not
		String createdClassromm=crPage.fetchcreatedClass(CLASSROOM);
			Assert.assertTrue(createdClassromm.equalsIgnoreCase(CLASSROOM));
			Reporter.log("class room created successfully",true);
		//click on timetable
		adbpPage.clickOnTimeTableLnk();
		TimeTablPreviewPage ttPage=new TimeTablPreviewPage(driver);
		ttPage.addTimeTable(driver,wutil, GRADE, DAY, SUBJECT, TEACHERNAME, CLASSROOM, STARTTIME, ENDTIME);
		//verify whether the teacher added or not
		String TeacherInTimeTable=ttPage.fetchTeacherFromTimeTable();
		Assert.assertTrue(TeacherInTimeTable.contains(TEACHERNAME));
		Reporter.log("Teacher added to time table successfully",true);
		//logout as a admin
		AdminDashBoardPreviewPage adpPage=new AdminDashBoardPreviewPage(driver);
		adpPage.signOutAdminLogin(wutil, driver);
		//login as a teacher
	LoginPage lPage=new LoginPage(driver);
	lPage.loginToApplication(TeacherUserName,PASSWORD);
String TeacherUrl=driver.getCurrentUrl();
		if(TeacherUrl.contains("dashboard2"))
		{
			System.out.println("Teacher Dash board page displayed successfully");
		}
		else
		{
			System.out.println("Teacher Dash board page not displayed");
		}	
		//click on time tale
		TeacherDashBoardPreviewPage tdbpPage=new TeacherDashBoardPreviewPage(driver);
		tdbpPage.clickOnMyTimeTable();
		TeacherTimeTablePreviewPage tttPage=new TeacherTimeTablePreviewPage(driver);
		String createdTimeTableDetails=tttPage.fetchCreatedTimeTableDetails();
			Assert.assertTrue(createdTimeTableDetails.contains(SUBJECT)&&createdTimeTableDetails.contains(TEACHERNAME)&&createdTimeTableDetails.contains(CLASSROOM));
			Reporter.log("time table assigned to the teacher successfully",true);
			eutil.insertDataIntoExcel("loginPage", 1, 0, "admin");
		
		}
		

	}
