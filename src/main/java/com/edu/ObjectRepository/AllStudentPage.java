package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class AllStudentPage {
	@FindBy(xpath = "//select[@id='grade']")private WebElement gardeDropDown;
	@FindBy(xpath = "//button[@onclick='showStudentTable(this)']")private WebElement submitBtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchEdt;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/a")private WebElement createdStudentTxt;
	@FindBy(xpath = "//tbody/tr/td[3]/a[1]")private WebElement createdStudentEditBtn;
	@FindBy(xpath = "//input[@id='g_phone']")private WebElement guardianPhoneEdt;
	@FindBy(xpath = "//input[@id='phone']")private WebElement studentPhoneEdt;
	@FindBy(xpath = "//button[.='Update']")private WebElement uodateBtn;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[@href='#modalviewform']")private WebElement updatedStudentLnk;
	@FindBy(xpath = "//td[@id='g_phone2']")private WebElement modifiedGuardianPhoneTxt;
	@FindBy(xpath = "//td[@id='phone2']")private WebElement modifiedStudentPhoneTxt;
	@FindAll({@FindBy(xpath = "//a[@id='id4']"),@FindBy(xpath = "//i[@class='glyphicon glyphicon-remove']")})private WebElement closeBtn;
	@FindBy(xpath = "//a[@id='btnYes']")private WebElement yesBtn;
	@FindBy(xpath = "//div[@id='update_Success']")private WebElement successPopUp;
	@FindBy(xpath = "//div[@id='leave_Success']")private WebElement leaveSuccessPopUp;
	public AllStudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getGardeDropDown() {
		return gardeDropDown;
	}
	public WebElement getCreatedStudentTxt() {
		return createdStudentTxt;
	}
	public WebElement getLeaveSuccessPopUp() {
		return leaveSuccessPopUp;
	}
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getCreatedStudentEditBtn() {
		return createdStudentEditBtn;
	}
	public WebElement getGuardianPhoneEdt() {
		return guardianPhoneEdt;
	}
	public WebElement getStudentPhoneEdt() {
		return studentPhoneEdt;
	}
	public WebElement getUodateBtn() {
		return uodateBtn;
	}
	public WebElement getUpdatedStudentLnk() {
		return updatedStudentLnk;
	}
	public WebElement getModifiedGuardianPhoneTxt() {
		return modifiedGuardianPhoneTxt;
	}
	public WebElement getModifiedStudentPhoneTxt() {
		return modifiedStudentPhoneTxt;
	}
	public WebElement getCloseBtn() {
		return closeBtn;
	}
	public WebElement getYesBtn() {
		return yesBtn;
	}
	//generic methods
	/**
	 * this method is used to select the grade from in all sudentpreview page
	 * @param grade
	 * @param wutil
	 */
	public void selectGrade(String grade,WebDriverutility wutil)
	{wutil.selectElementInDropDown(grade, gardeDropDown);
	submitBtn.click();	
	}
	public String verifyCreatedStudent(String studentName)
	{
		searchEdt.sendKeys(studentName);
		String createdStudent=createdStudentTxt.getText();
		return createdStudent;
		
	}
	public void editStudent(WebDriverutility wutil,String modifiedPhno,WebDriver driver) throws Exception 
	{ 
		createdStudentEditBtn.click();
		studentPhoneEdt.clear();
		studentPhoneEdt.sendKeys(modifiedPhno);
		guardianPhoneEdt.clear();
		guardianPhoneEdt.sendKeys(modifiedPhno);
		uodateBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		
	}
	public String verifyModifiedData(WebDriverutility wutil,WebDriver driver,String grade,String studentName)
	{
		//wutil.waitTillElementToInvisibility(driver, successPopUp);
		updatedStudentLnk.click();
		String modifiedParentphno=modifiedGuardianPhoneTxt.getText();
		String modifiedStuPhno=modifiedStudentPhoneTxt.getText();
		String modifieddata=modifiedStuPhno+modifiedParentphno;
		wutil.waitTillElementToBeClickable(driver, closeBtn);
		try {
		closeBtn.click();
		}
		catch (Exception e) {
			closeBtn.click();
		}
		wutil.waitTillElementToBeVisible(driver, yesBtn);
		yesBtn.click();
		wutil.waitTillElementToInvisibility(driver, leaveSuccessPopUp);
		return modifieddata;
		
		
	}
	
	
	
	

}
