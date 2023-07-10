package com.edu.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;
/**
 * this is a POM class for Classroom page
 * @author ANITHA
 */
public class ClassRoomPreviewPage {
	//declaration
	@FindBy(xpath = "//input[@id='name']")private WebElement nameEdt;
	@FindBy(xpath="//input[@id='student_count']")private WebElement studentCountEdt;
	@FindBy(xpath = "//button[@id='btnSubmit']")private WebElement SubmitBtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchEdt;
	@FindBy(xpath="//table/tbody/tr/td[2]")private WebElement ClassroomNameLnk;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	
	//initialization
	public ClassRoomPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getNameEdt() {
		return nameEdt;
	}
	public WebElement getStudentCountEdt() {
		return studentCountEdt;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getClassroomNameLnk() {
		return ClassroomNameLnk;
	}
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	//generimethods
	/**
	 * this method is used to create new classroom
	 * @param classRoomName
	 * @param StudentCount
	 */
	public void createNewClassRoom(WebDriver driver,WebDriverutility wutil,String classRoomName,String StudentCount)
	{
		nameEdt.sendKeys(classRoomName);
		studentCountEdt.sendKeys(""+StudentCount+"");
		SubmitBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
	}
	/**
	 * this method will give the created classroom name from the all classromm list
	 * @param classRoomName
	 * @return
	 */
	public String fetchcreatedClass(String classRoomName)
	{
		searchEdt.sendKeys(classRoomName);
		String createdClassRoom=ClassroomNameLnk.getText();
		return createdClassRoom;
	}
	
}
