package com.edu.ObjectRepository;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import smsGenericUtilities.WebDriverutility;

public class SubjectRoutingPage {
//declaration
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")private WebElement addBtn;
	@FindBy(xpath = "//select[@id='grade']")private WebElement gradeDropDown;
	@FindBy(xpath = "//select[@id='subject']")private WebElement subjectDropDown;
	@FindBy(xpath = "//select[@name='teacher_id']")private WebElement teacherDropDown;
	@FindBy(id = "fee")private WebElement feeEdt;
	@FindBy(xpath = "//button[.='Submit']")private WebElement submitBtn;
	@FindAll({@FindBy(xpath = "//input[@type='search']"),@FindBy(xpath = "//input[@class='form-control input-sm']")})private WebElement searchEdt;
	@FindBy(xpath ="//tbody/tr[1]" )private List<WebElement> subjectRoutingTxt;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchBar;
	@FindBy(xpath = "//tbody/tr/td[6]/a[1]")private WebElement editBtn;
	@FindBy(xpath = "//input[@id='fee1']")private WebElement feeModififyEdt;
	@FindBy(xpath = "//button[@id='btnSubmit1']")private WebElement updateBtn;
	@FindBy(xpath = "//tbody/tr[1]/td[5]")private WebElement updatedFee;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement insertSuccessPopUp;
	@FindBy(xpath = "//div[@id='update_Success']")private WebElement updatedSuccessPopUp;
	
	
	//initialization
	public SubjectRoutingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getGradeDropDown() {
		return gradeDropDown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public List<WebElement> getSubjectRoutingTxt() {
		return subjectRoutingTxt;
	}

	public WebElement getInsertSuccessPopUp() {
		return insertSuccessPopUp;
	}

	public WebElement getUpdatedSuccessPopUp() {
		return updatedSuccessPopUp;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getFeeModififyEdt() {
		return feeModififyEdt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getUpdatedFee() {
		return updatedFee;
	}

	public WebElement getSubjectDropDown() {
		return subjectDropDown;
	}

	public WebElement getTeacherDropDown() {
		return teacherDropDown;
	}

	public WebElement getFeeEdt() {
		return feeEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSuccessPopUp() {
		return insertSuccessPopUp;
	}

	//generic methods
	public void addSubjectRouting(WebDriver driver,String fee,WebDriverutility wutil,String grade,String subject,String teacher)
	{
		addBtn.click();
		wutil.selectElementInDropDown(grade, gradeDropDown);
		wutil.selectElementInDropDown(subject, subjectDropDown);
		wutil.selectElementInDropDown(teacher, teacherDropDown);
		feeEdt.sendKeys(fee);
		submitBtn.click();
		wutil.waitTillElementToInvisibility(driver, insertSuccessPopUp);
		
	}
	
	public List<WebElement> fetchCreatedSubjectRouting(String teacher)
	{
		searchEdt.sendKeys(teacher);
		return subjectRoutingTxt;
	}
	public void editPettyCash(String teacherName,String modifiedAmount,WebDriverutility wutil,WebDriver driver) throws Exception
	{	editBtn.click();
	wutil.waitTillElementToBeVisible(driver, feeModififyEdt);
	wutil.waitTillElementToBeClickable(driver, feeModififyEdt);
		feeModififyEdt.click();
		feeModififyEdt.clear();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(feeModififyEdt, ""));
		feeModififyEdt.sendKeys(modifiedAmount);
		updateBtn.click();
		wutil.waitTillElementToInvisibility(driver, updatedSuccessPopUp);
		
		}
	
	public String fetchingupdatedFee(WebDriverutility wutil,WebDriver driver,String teacher,String modifiedFee)
	{	wutil.waitTilltextToBePresentInElement(driver, updatedFee, modifiedFee);
		return updatedFee.getText();
	}
	
}
