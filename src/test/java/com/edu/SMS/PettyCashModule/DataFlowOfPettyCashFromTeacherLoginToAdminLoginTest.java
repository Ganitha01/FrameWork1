package com.edu.SMS.PettyCashModule;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.edu.ObjectRepository.AdminDashBoardPreviewPage;
import com.edu.ObjectRepository.AdminPettyCashPreviewPage;
import com.edu.ObjectRepository.LoginPage;
import com.edu.ObjectRepository.TeacherDashBoardPreviewPage;
import com.edu.ObjectRepository.TeacherPettyCashPreviewPage;
import com.edu.ObjectRepository.TeacherPreviewPage;
import smsGenericUtilities.BaseClass;
import smsGenericUtilities.ExcelUtility;
import smsGenericUtilities.JavaUtility;
import smsGenericUtilities.PropertyUtility;
import smsGenericUtilities.WebDriverutility;
@Listeners(smsGenericUtilities.ListenersImplementation.class)
public class DataFlowOfPettyCashFromTeacherLoginToAdminLoginTest extends BaseClass {
	ExcelUtility eutil=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverutility wutil=new WebDriverutility();
	PropertyUtility putil=new PropertyUtility();
	//generating random number
	int num=jutil.getRandomNumber();
	//fech the data from excel file
		@Test
		public void CreateTeacher() throws Throwable
		
		{	String PASSWORD=putil.fetchDataFromPropertiesFile("password");
		String ADMINUSERNAME=putil.fetchDataFromPropertiesFile("adminusername");
			
			
			String TEACHERNAME=eutil.fetchDataFromExcel("pettycash", 1, 2);
		String ADDRESS=eutil.fetchDataFromExcel("pettycash", 1, 3);
		String GENDER=eutil.fetchDataFromExcel("pettycash", 1, 4);
		String PHONENO=eutil.fetchDataFromExcel("pettycash", 1, 5);
		String TEACHERUSERNAME=eutil.fetchDataFromExcel("pettycash", 1, 6);
			
			//create teacher* click on teacher link
			AdminDashBoardPreviewPage adpPage=new AdminDashBoardPreviewPage(driver);
			//click on add teacher 
			adpPage.clickOnAddTeacherLnk();
			//enter indexnumber
			TeacherPreviewPage tPage=new TeacherPreviewPage(driver);
			tPage.createTeacher(driver,wutil,num, TEACHERNAME+num, TEACHERNAME+num, ADDRESS, GENDER, PHONENO, TEACHERNAME+num+TEACHERUSERNAME, "C:\\Users\\ANITHA\\OneDrive\\Desktop\\teacher.png");
			//check whether the teacher is created or not
			//click on teacher link
		adpPage.clickOnTeacherLnk(wutil,driver);
		//click on allteacher links
			adpPage.clickOnAllTeacherLnk();
		//enter teacher name in search bar
			String createdTeacherName=tPage.searchForTeacher(TEACHERNAME+num);
			
			Assert.assertEquals(createdTeacherName.equalsIgnoreCase(TEACHERNAME+num),true);
				Reporter.log("Teacher created successfully",true);
			//logout as a admin
			adpPage.signOutAdminLogin(wutil, driver);
			//login as a teacher
		LoginPage lPage=new LoginPage(driver);
		lPage.loginToApplication(createdTeacherName+TEACHERUSERNAME, PASSWORD);
	String TeacherUrl=driver.getCurrentUrl();
			if(TeacherUrl.contains("dashboard2"))
			{
				System.out.println("Teacher Dash board page displayed successfully");
			}
			else
			{
				System.out.println("Teacher Dash board page not displayed");
			}
			String CURRENTDATE=jutil.getCurrentSystemDateInFormat("date");
			String AMOUNT=eutil.fetchDataFromExcel("pettycash", 1, 7);
			String PETTYCASHDESCRIPTION=eutil.fetchDataFromExcel("pettycash", 1, 9);
			String PettyCashDes=PETTYCASHDESCRIPTION+num;
			//verify whether dashboard page is displayed or not
		
			//click on petty cash
			TeacherDashBoardPreviewPage tdpPage=new TeacherDashBoardPreviewPage(driver);
			tdpPage.clickOnMyPettyCashLnk();
			//click on add button on petty cash page
			TeacherPettyCashPreviewPage tppPage=new TeacherPettyCashPreviewPage(driver);
			tppPage.createPettycashRequest(driver,wutil,PettyCashDes, AMOUNT);
			//check whether the petty cash request created or not
			String createdPettyCashDetails=tppPage.fetchCreatedPettyCashDetails(driver,CURRENTDATE, wutil, "100", PettyCashDes, AMOUNT);

				Assert.assertTrue(createdPettyCashDetails.contains(PettyCashDes)&&createdPettyCashDetails.contains(AMOUNT));
					Reporter.log("pettycash request created successfully",true);
					//logout as teacher
					adpPage.signOutAdminLogin(wutil, driver);
					//login as admin
					lPage.loginToApplication(ADMINUSERNAME,PASSWORD);
					String url=driver.getCurrentUrl();
					if(url.contains("dashboard"))
					{
						System.out.println("Admin Dash board page displayed successfully");
					}
					else
					{
						System.out.println("Admin Dash board page not displayed");
					}
						//click on pettycash
						adpPage.clickOnPettyCashLnk();
						AdminPettyCashPreviewPage apcpPage=new AdminPettyCashPreviewPage(driver);
						String adminPettyCashDetails=apcpPage.fetchPettyCashDetails(TEACHERNAME+num, wutil, "100", PettyCashDes, AMOUNT);
						
							Assert.assertTrue(adminPettyCashDetails.contains(PettyCashDes)&&adminPettyCashDetails.contains(AMOUNT));
								Reporter.log("petty cash request displayed in admin login successfully",true);
							eutil.insertDataIntoExcel("loginPage", 1, 0, "admin");
							
							
				}
							
}

