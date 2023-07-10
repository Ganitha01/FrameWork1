package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class SubjectPreviewPage {
	
	//declaration
	@FindBy(xpath = "//input[@placeholder='Enter Subject name']")private WebElement subjectEdt;
	@FindBy(xpath = "//button[@type='submit']")private WebElement submitBtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchEdt;
	@FindBy(xpath = "//tbody/tr[1]/td[2]")private WebElement createdSubjecTxt;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	
	//initialization
	
	public SubjectPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSuccessPopUp() {
		return successPopUp;
	}

	public WebElement getCreatedSubjecTxt() {
		return createdSubjecTxt;
	}
	//generic methods
	/**
	 * this method is used to created the subject
	 * @param subject
	 */
	public void createSuject(WebDriver driver,WebDriverutility wutil,String subject)
	{
		subjectEdt.sendKeys(subject);
		submitBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
	}
	/**
	 * this method is used to fetch the created subject
	 * @param subject
	 * @return
	 */
	public String fetchCreatedSubject(String subject)
	{
		searchEdt.sendKeys(subject);
		String createdSubject=createdSubjecTxt.getText();
		return createdSubject;
	}
	
	


}
