package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class TimeTablPreviewPage {
	//declaration
	@FindBy(xpath = "//select[@name='grade']")private WebElement gradeDropDown;
	@FindBy(xpath = "//button[@onclick='showTimeTable(this)']")private WebElement submitBtn;
	@FindBy(xpath = "//a[@onclick='showModal(this)']")private WebElement addBtn;
	@FindBy(xpath = "//select[@id='day']")private WebElement dayDropDown;
	@FindBy(xpath = "//select[@name='subject_id']")private WebElement subjectDropDown;
	@FindBy(xpath = "//select[@name='teacher_id']")private WebElement tacherDropDown;
	@FindBy(xpath = "//select[@name='classroom_id']")private WebElement classroomDropDown;
	@FindBy(xpath = "//input[@name='start_time']")private WebElement startTimeEdt;
	@FindBy(xpath = "//input[@name='end_time']")private WebElement endTimeEdt;
	@FindBy(xpath = "//button[@id='btnSubmit']")private WebElement subjectRoutingsubmitBtn;
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")private WebElement assignedTeacherInTimeTableTxt;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	
	//initialization
	public TimeTablPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getGradeDropDown() {
		return gradeDropDown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getDayDropDown() {
		return dayDropDown;
	}

	public WebElement getSubjectDropDown() {
		return subjectDropDown;
	}

	public WebElement getTacherDropDown() {
		return tacherDropDown;
	}

	public WebElement getClassroomDropDown() {
		return classroomDropDown;
	}

	public WebElement getStartTimeEdt() {
		return startTimeEdt;
	}

	public WebElement getEndTimeEdt() {
		return endTimeEdt;
	}

	public WebElement getSubjectRoutingsubmitBtn() {
		return subjectRoutingsubmitBtn;
	}

	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	public WebElement getAssignedTeacherInTimeTableTxt() {
		return assignedTeacherInTimeTableTxt;
	}
	//generic methods
	/**
	 * this method will create time table
	 * @param wutil
	 * @param grade
	 * @param subject
	 * @param teacher
	 * @param classroom
	 * @param startTime
	 * @param endTime
	 */
	public void addTimeTable(WebDriver driver,WebDriverutility wutil,String grade,String day,String subject,String teacher,String classroom,String startTime,String endTime)
	{
		wutil.selectElementInDropDown(grade, gradeDropDown);
		submitBtn.click();
		addBtn.click();
		wutil.selectElementInDropDown(day, dayDropDown);
		wutil.selectElementInDropDown(subject, subjectDropDown);
		wutil.selectElementInDropDown(teacher, tacherDropDown);
		wutil.selectElementInDropDown(classroom, classroomDropDown);
		startTimeEdt.sendKeys(startTime);
		endTimeEdt.sendKeys(endTime);
		subjectRoutingsubmitBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
	}
	public String fetchTeacherFromTimeTable()
	{
		String AssignedTeacherInTimeTable=assignedTeacherInTimeTableTxt.getText();
		return AssignedTeacherInTimeTable;
	}
	
	

}
