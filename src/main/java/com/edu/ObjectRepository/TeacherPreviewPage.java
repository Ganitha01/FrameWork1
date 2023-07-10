package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class TeacherPreviewPage {
	//declaration
	@FindBy(name = "index_number")private WebElement indexNumberEdt;
	@FindBy(id = "full_name")private WebElement fullNameEdt;
	@FindBy(xpath = "//input[@placeholder='Enter name with initials']")private WebElement nameWithInitialsEdt;
	@FindBy(id = "address")private WebElement addressEdt;
	@FindBy(xpath = "//select[@name='gender']")private WebElement genderDropDown;
	@FindBy(name = "phone")private WebElement phoneNumberEdt;
	@FindBy(name = "email")private WebElement emailEdt;
	@FindBy(name = "fileToUpload")private WebElement chooseFileBtn;
	@FindBy(xpath = "//button[.='Submit']")private WebElement submitBtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchBar;
	@FindBy(xpath = "//a[@href='#modalViewform']")private WebElement createdTeacherName;
	
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	//initialization
	public TeacherPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getIndexNumberEdt() {
		return indexNumberEdt;
	}
	public WebElement getFullNameEdt() {
		return fullNameEdt;
	}
	public WebElement getNameWithInitialsEdt() {
		return nameWithInitialsEdt;
	}
	public WebElement getAddressEdt() {
		return addressEdt;
	}
	public WebElement getGenderEdt() {
		return genderDropDown;
	}
	public WebElement getPhoneNumberEdt() {
		return phoneNumberEdt;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public WebElement getChooseFileBtn() {
		return chooseFileBtn;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSearchBar() {
		return searchBar;
	}
	public WebElement getCreatedTeacherName() {
		return createdTeacherName;
	}
	//generic method
	public void createTeacher(WebDriver driver,WebDriverutility wutil,int indexNumber,String fullName,String nameWithInitials,String address,String gender,String phoneNumber,String email,String path) throws Exception
	
	{indexNumberEdt.sendKeys(""+indexNumber+"");
	fullNameEdt.sendKeys(fullName);
	nameWithInitialsEdt.sendKeys(nameWithInitials);
	addressEdt.sendKeys(address);
	wutil.selectElementInDropDown(gender, genderDropDown);
	phoneNumberEdt.sendKeys(phoneNumber);
	emailEdt.sendKeys(email);
	chooseFileBtn.sendKeys(path);
	submitBtn.click();
	wutil.waitTillElementToInvisibility(driver, successPopUp);
		
	}
	public String searchForTeacher(String teacherName)
	{
		searchBar.sendKeys(teacherName);
		String createdTeacher=createdTeacherName.getText();
		return createdTeacher;
	}

}
