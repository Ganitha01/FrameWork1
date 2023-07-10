package com.edu.ObjectRepository;
/**
 * This is a POM class for grade preview page
 * @author ANITHA
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class GradePreviewPage {
	//declaration
	@FindBy(xpath = "//input[@placeholder='Enter name']")private WebElement gradeEdt;
	@FindBy(id = "admission_fee")private WebElement admissionFeeBtn;
	@FindBy(xpath = "//input[@id='hall_charge']")private WebElement hallChargeBtn;
	@FindBy(xpath = "//button[@id='btnSubmit']")private WebElement nextBtn;
	@FindBy(xpath = "//input[@id='mark_range_text_1']")private WebElement eMarksRangeEdt;
	@FindBy(xpath = "//input[@id='mark_grade_text_1']")private WebElement eMarksGradeEdt;
	@FindBy(xpath = "//button[@class='btn btn-info btnS']")private WebElement submitBtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchEdt;
	@FindBy(xpath = "//td[@class='sorting_1']//following-sibling::td")private WebElement createdGradeText; 
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	//initialization
	public GradePreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getGradeEdt() {
		return gradeEdt;
	}
	public WebElement getAdmissionFeeBtn() {
		return admissionFeeBtn;
	}
	public WebElement getHallChargeBtn() {
		return hallChargeBtn;
	}
	public WebElement getNextBtn() {
		return nextBtn;
	}
	public WebElement geteMarksRangeEdt() {
		return eMarksRangeEdt;
	}
	public WebElement geteMarksGradeEdt() {
		return eMarksGradeEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getCreatedGradeText() {
		return createdGradeText;
	}
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	public WebElement getGradeLnk() {
		return createdGradeText;
	}
	//generic methods
	/**
	 * this method is used to create a new grade
	 * @param grade
	 * @param admissionFee
	 * @param hallCcharges
	 * @param eMarksRange
	 * @param eMarksGrade
	 */
	public void createGrade(WebDriver driver,WebDriverutility wutil,String grade,String admissionFee,String hallCcharges,String eMarksRange,String eMarksGrade)
	{
		gradeEdt.sendKeys(grade);
		admissionFeeBtn.sendKeys(admissionFee);
		hallChargeBtn.sendKeys(hallCcharges);
		nextBtn.click();
		eMarksRangeEdt.sendKeys(eMarksRange);
		eMarksGradeEdt.sendKeys(eMarksGrade);
		submitBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		
		
	}
	/**
	 * this method will fetch the reated grade from the all grade list
	 * @param grade
	 * @return
	 */
	
	public String fetchCreatedGrade(String grade)
	{
		searchEdt.sendKeys(grade);
		String createdGrade=createdGradeText.getText();
		return createdGrade;
	}
	

}
