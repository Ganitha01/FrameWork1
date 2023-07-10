package com.edu.ObjectRepository;
/**
 * this is a POM class for teacher DashBoard Preview page
 * @author ANITHA
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherDashBoardPreviewPage {
	//declaration
	@FindBy(xpath = "//span[.='Timetable']")private WebElement teachertTimeTableLnk;
	@FindAll({@FindBy(xpath = "//a[@href='my_timetable2.php']"),@FindBy(xpath = "//a[.=' My Timetable']")})private WebElement myTimeTableLnk;
	@FindBy(xpath = "//span[.='My Petty Cash']")private WebElement myPettyCashLnk;
	@FindBy(xpath = "//span[@class='hidden-xs']")private WebElement teacherUserMenuLnk;
	@FindBy(xpath = "//a[.='Sign out']")private WebElement teacherSignOutBtn;
//initialization
	public TeacherDashBoardPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getTeachetTimeTableLnk() {
		return teachertTimeTableLnk;
	}
	public WebElement getMyTimeTableLnk() {
		return myTimeTableLnk;
	}
	public WebElement getMyPettyCashLnk() {
		return myPettyCashLnk;
	}
	public WebElement getTeacherUserMenuLnk() {
		return teacherUserMenuLnk;
	}
	public WebElement getTeacherSignOutBtn() {
		return teacherSignOutBtn;
	}
	
	//generic methods
	/**
	 * this method is used to click on the Time Table link
	 */
	public void clickOnTimeTable()
	{
		teachertTimeTableLnk.click();
	}
	/**
	 * this method is used to click on myTimeTableLnk
	 */
	public void clickOnMyTimeTable()
	{	teachertTimeTableLnk.click();
		myTimeTableLnk.click();
	}
	/**
	 * this method is used to click on myPettyCashLnk
	 */
	public void clickOnMyPettyCashLnk()
	{
		myPettyCashLnk.click();
	}
	/**
	 * this method is used to logout from the teacher credentials
	 */
	public void signOutFromTeacherLogin()
	{teacherUserMenuLnk.click();
	teacherSignOutBtn.click();
	}

}
