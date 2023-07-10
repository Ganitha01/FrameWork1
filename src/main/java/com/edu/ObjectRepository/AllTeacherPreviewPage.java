package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllTeacherPreviewPage {
	//declaration
	@FindBy(xpath="//input[@type='search']")private WebElement searchEdt;
	@FindBy(xpath = "//a[@href='#modalViewform']")private WebElement createdTeacherLnk;
	//initialization
	public AllTeacherPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getCreatedTeacherLnk() {
		return createdTeacherLnk;
	}
	//generic methods
	public String fetchCreatedTeacher(String teacher)
	{
		searchEdt.sendKeys(teacher);
		String createdTeacher=createdTeacherLnk.getText();
		return createdTeacher;
	}

}
