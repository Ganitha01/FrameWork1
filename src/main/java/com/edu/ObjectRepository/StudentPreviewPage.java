package com.edu.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.JavaUtility;
import smsGenericUtilities.WebDriverutility;

public class StudentPreviewPage {
	@FindBy(xpath = "//input[@id='index_number']")private WebElement studentIndexNumberEdt;
	@FindBy(xpath = "//input[@id='full_name']")private WebElement studentFullNameEdt;
	@FindBy(xpath = "//input[@id='i_name']")private WebElement studentNameWithInitialsEdt;
	@FindBy(xpath = "//input[@id='address']")private WebElement studentAddressEdt;
	@FindBy(xpath = "//input[@id='email']")private WebElement studentEmailEdt;
	@FindBy(xpath = "//input[@id='phone']")private WebElement studentPhoneEdt;
	@FindBy(xpath = "//input[@id='b_date']")private WebElement studentDateOfBirthEdt;
	@FindBy(xpath = "//select[@id='gender']")private WebElement studentGenderDropDown;
	@FindBy(xpath = "//input[@id='fileToUpload']")private WebElement studentChooseFileBtn;
	@FindBy(xpath = "//input[@id='g_index']")private WebElement guardianIndenNumberEdt;
	@FindBy(xpath = "//input[@id='g_full_name']")private WebElement guardianFullNameEdt;
	@FindBy(xpath = "//input[@id='g_i_name']")private WebElement guardianNameWithInitialsEdt;
	@FindBy(xpath = "//input[@id='g_address']")private WebElement guardianAddressEdt;
	@FindBy(xpath = "//input[@id='g_email']")private WebElement guardianEmailEdt;
	@FindBy(xpath = "//input[@id='g_phone']")private WebElement guardianPhoneEdt;
	@FindBy(xpath = "//input[@id='g_b_date']")private WebElement guardianDateOfBirthEdt;
	@FindBy(xpath = "//select[@id='g_gender']")private WebElement guardianGenderDropDown;
	@FindBy(xpath = "//input[@id='g_fileToUpload']")private WebElement guardianChooseFileBtn;
	@FindBy(xpath = "//button[.='Next']")private WebElement nextBtn;
	@FindBy(xpath = "//select[@name='grade']")private WebElement gradeDropDown;
	@FindBy(xpath = "//button[@id='btnSubmit1']")private WebElement submitBtn;
	@FindBy(xpath = "//button[@class='close  ']")private WebElement closeIcon;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	
	public StudentPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStudentIndexNumberEdt() {
		return studentIndexNumberEdt;
	}

	public WebElement getStudentFullNameEdt() {
		return studentFullNameEdt;
	}

	public WebElement getStudentNameWithInitialsEdt() {
		return studentNameWithInitialsEdt;
	}

	public WebElement getStudentAddressEdt() {
		return studentAddressEdt;
	}

	public WebElement getStudentEmailEdt() {
		return studentEmailEdt;
	}

	public WebElement getStudentPhoneEdt() {
		return studentPhoneEdt;
	}

	public WebElement getStudentDateOfBirthEdt() {
		return studentDateOfBirthEdt;
	}

	public WebElement getStudentGenderDropDown() {
		return studentGenderDropDown;
	}

	public WebElement getStudentChooseFileBtn() {
		return studentChooseFileBtn;
	}

	public WebElement getGuardianIndenNumberEdt() {
		return guardianIndenNumberEdt;
	}

	public WebElement getGuardianFullNameEdt() {
		return guardianFullNameEdt;
	}

	public WebElement getGuardianNameWithInitialsEdt() {
		return guardianNameWithInitialsEdt;
	}

	public WebElement getGuardianAddressEdt() {
		return guardianAddressEdt;
	}

	public WebElement getGuardianEmailEdt() {
		return guardianEmailEdt;
	}

	public WebElement getGuardianPhoneEdt() {
		return guardianPhoneEdt;
	}

	public WebElement getGuardianDateOfBirthEdt() {
		return guardianDateOfBirthEdt;
	}

	public WebElement getGuardiangenderDropDown() {
		return guardianGenderDropDown;
	}

	public WebElement getGuardianChooseFileBtn() {
		return guardianChooseFileBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getGradeDropDown() {
		return gradeDropDown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}
	
	public WebElement getGuardianGenderDropDown() {
		return guardianGenderDropDown;
	}

	public WebElement getSuccessPopUp() {
		return successPopUp;
	}

	//generic methods
	/**
	 * this method is used for Creating new student
	 * @param studentIndexNumber
	 * @param studentFullName
	 * @param studentNameWithInitials
	 * @param studentAddress
	 * @param studentEmail
	 * @param studentPhone
	 * @param studentDateOfBirth
	 * @param studentGender
	 * @param studentChooseFile
	 * @param guardianIndenNumber
	 * @param guardianFullName
	 * @param guardianNameWithInitials
	 * @param guardianAddress
	 * @param guardianEmail
	 * @param guardianPhone
	 * @param guardianDateOfBirth
	 * @param guardianGender
	 * @param guardianChooseFile
	 * @param wutil
	 * @param grade
	 * @throws Exception 
	 */
	public void addStudent(WebDriver driver,String studentIndexNumber,String studentFullName,String studentNameWithInitials,
			String studentAddress,String studentEmail,String studentPhone,String studentDateOfBirth,String studentGender,String studentChooseFile,
			String guardianFullName,String guardianNameWithInitials,String guardianAddress,String guardianEmail,
			String guardianPhone,String guardianDateOfBirth,String guardianGender,String guardianChooseFile,WebDriverutility wutil,String grade) throws Exception
	{
		studentIndexNumberEdt.sendKeys(studentIndexNumber);
		studentFullNameEdt.sendKeys(studentFullName);
		studentNameWithInitialsEdt.sendKeys(studentNameWithInitials);
		studentAddressEdt.sendKeys(studentAddress);
		studentEmailEdt.sendKeys(studentEmail);
		studentPhoneEdt.sendKeys(studentPhone);
		studentDateOfBirthEdt.sendKeys(studentDateOfBirth);
		studentGenderDropDown.sendKeys(studentGender);
		studentChooseFileBtn.sendKeys(studentChooseFile);
		guardianFullNameEdt.sendKeys(guardianFullName);
		guardianNameWithInitialsEdt.sendKeys(guardianNameWithInitials);
		guardianAddressEdt.sendKeys(guardianAddress);
		guardianEmailEdt.sendKeys(guardianEmail);
		guardianPhoneEdt.sendKeys(guardianPhone);
		guardianDateOfBirthEdt.sendKeys(guardianDateOfBirth);
		guardianGenderDropDown.sendKeys(guardianGender);
		guardianChooseFileBtn.sendKeys(guardianChooseFile);
		nextBtn.click();
		wutil.waitTillElementToBeVisible(driver, gradeDropDown);
		wutil.selectElementInDropDown(grade, gradeDropDown);
		wutil.waitTillElementToBeClickable(driver, submitBtn);
		submitBtn.click();
		closeIcon.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		}
	/**
	 * this method is used to create student using HashMap
	 * @throws Throwable 
	 */
	public int createStudent(HashMap<String, String> fields,WebDriver driver,JavaUtility jutil,WebDriverutility wutil,String grade) throws Throwable
	{wutil.waitTillPageGetLoad(driver);
	int num=jutil.getRandomNumber();
		for(Entry<String, String> set:fields.entrySet())
		{	
			if(set.getKey().equalsIgnoreCase("index_number")||set.getKey().equalsIgnoreCase("full_name")||set.getKey().equalsIgnoreCase("i_name")||set.getKey().equalsIgnoreCase("g_full_name")||set.getKey().equalsIgnoreCase("g_i_name"))
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+num);
		}
		else if(set.getKey().contains("email"))
				{
			driver.findElement(By.name(set.getKey())).sendKeys(num+set.getValue());
				}
		else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		}
		nextBtn.click();
		wutil.waitTillElementToBeVisible(driver, gradeDropDown);
		wutil.selectElementInDropDown(grade, gradeDropDown);
		wutil.waitTillElementToBeClickable(driver, submitBtn);
		submitBtn.click();
		closeIcon.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		
		return num;
			
		
		
	}
	
}


