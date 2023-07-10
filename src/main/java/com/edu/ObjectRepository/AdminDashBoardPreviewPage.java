package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smsGenericUtilities.WebDriverutility;
/**
 * this is a pom class for Admin DashBoard Page
 */
public class AdminDashBoardPreviewPage {
	//declaration
	@FindBy(xpath = "//span[.='Classroom']")private WebElement classroomLnk;
	@FindBy(xpath = "//span[.='Grade']")private WebElement gradeLnk;
	@FindBy(xpath = "//span[.='Subject']")private WebElement subjectLnk;
	@FindBy(xpath = "//span[.='Teacher']")private WebElement teacherLnk;
	@FindAll({@FindBy(xpath = "//a[@href='teacher.php']"),@FindBy(xpath = "//a[.=' Add Teacher']")})private WebElement addTeacherLnk;
	@FindAll({@FindBy(xpath = "//a[@href='all_teacher.php']"),@FindBy(xpath = "//a[.=' All Teacher']")})private WebElement allTeacherLnk;
	@FindBy(xpath = "//span[.='Subject Routing']")private WebElement subjectRoutingLnk;
	@FindBy(xpath = "//span[.='Timetable']")private WebElement timeTableLnk;
	@FindBy(xpath = "//span[.='Student']")private WebElement studentLnk;
	@FindBy(xpath = "//a[.=' Add Student']")private WebElement addStudentLnk;
	@FindBy(xpath = "//a[.=' All Student']")private WebElement allStudentLnk;
	@FindBy(xpath="//span[.='Petty Cash']")private WebElement pettyCashLnk;
	@FindAll({@FindBy(xpath = "//span[@class='hidden-xs']"),@FindBy(xpath = "//span[.='Ingenious Developer1']")})private WebElement userMenuLnk;
	@FindBy(xpath = "//a[.='Sign out']")private WebElement signOutBtn;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	@FindBy(xpath = "//div[@id='update_Success']")private WebElement updateSuccessPopUp;
	
	//initialization
	public AdminDashBoardPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getClassroomLnk() {
		return classroomLnk;
	}
	public void setAddTeacherLnk(WebElement addTeacherLnk) {
		this.addTeacherLnk = addTeacherLnk;
	}
	public void setAddStudentLnk(WebElement addStudentLnk) {
		this.addStudentLnk = addStudentLnk;
	}
	public WebElement getGradeLnk() {
		return gradeLnk;
	}
	public WebElement getUpdateSuccessPopUp() {
		return updateSuccessPopUp;
	}
	public WebElement getUpdatedSuccessPopUp() {
		return updateSuccessPopUp;
	}
	public WebElement getSubjectLnk() {
		return subjectLnk;
	}
	public WebElement getTeacherLnk() {
		return teacherLnk;
	}
	public WebElement getAddTeacherLnk() {
		return addTeacherLnk;
	}
	public WebElement getAllTeacherLnk() {
		return allTeacherLnk;
	}
	public WebElement getSubjectRoutingLnk() {
		return subjectRoutingLnk;
	}
	public WebElement getTimeTableLnk() {
		return timeTableLnk;
	}
	public WebElement getStudentLnk() {
		return studentLnk;
	}
	public WebElement getPettyCashLnk() {
		return pettyCashLnk;
	}
	public WebElement getUserMenuLnk() {
		return userMenuLnk;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	public WebElement getAddStudentLnk() {
		return addStudentLnk;
	}
	public WebElement getAllStudentLnk() {
		return allStudentLnk;
	}
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	//generic methods 
	/**
	 * this method will click on classroom
	 */
	public void clickOnClassRoomLnk()
	{
		classroomLnk.click();
	}
	/**
	 * this method will click on Grade
	 */
	public void clickOnGradeLnk()
	{
		gradeLnk.click();
	}
	/**
	 * this method will click on subject
	 */
	public void ClickOnSubjectLnk()
	{
		subjectLnk.click();
	}
	/**
	 * this mehod will click on Teacher link
	 */
	public void clickOnTeacherLnk(WebDriverutility wutil,WebDriver driver)
	{	
	
	
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		teacherLnk.click();
	}
	
	
	
	/**
	 * this method will click on Add teacherLink
	 */
	public void clickOnAddTeacherLnk()
	{teacherLnk.click();
		addTeacherLnk.click();
	}
	/**
	 * this method will click on all teacher link
	 */
	public void clickOnAllTeacherLnk()
	{teacherLnk.click();
		allTeacherLnk.click();
	}
	
	/**
	 * this method will click on subjectRoutingLnk
	 */
	public void clickOnSubjectRoutingLnk(WebDriverutility wutil,WebDriver driver)
	{wutil.waitTillElementToInvisibility(driver, updateSuccessPopUp);
		subjectRoutingLnk.click();
	}
	/**
	 * this method is used click on timeTableLnk
	 */
	public void clickOnTimeTableLnk()
	{
		timeTableLnk.click();
	}
	/**
	 * this method will click on studentLnk
	 */
	public void clickOnStudentLnk()
	{
		studentLnk.click();
	}
	
	/**
	 * this method will click on pettyCashLnk
	 */
	public void clickOnPettyCashLnk()
	{
		pettyCashLnk.click();
	}
	/**
	 * this method is used for signout from the admin credentials
	 * @throws Exception 
	 * @throws Throwable 
	 */
	public void signOutAdminLogin(WebDriverutility wutil,WebDriver driver) throws Exception 
	{	Thread.sleep(3000);
		wutil.waitTillElementToInvisibility(driver, updateSuccessPopUp);
		getUserMenuLnk().click();
		getSignOutBtn().click();
	}
	/**
	 * this method will click on the addStudent link
	 */
	public void clickOnAddStudentLnk()
	{
		addStudentLnk.click();
	}
	/**
	 * this method will click on the all student link
	 */
	public void clickOnAllStudentLnk()
	{studentLnk.click();
		allStudentLnk.click();
	}

}
