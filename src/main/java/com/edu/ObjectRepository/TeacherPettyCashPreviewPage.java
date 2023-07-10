package com.edu.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class TeacherPettyCashPreviewPage {
//declaration
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")private WebElement addBtn;
	@FindBy(xpath = "//input[@class='_desc form-control']")private WebElement DescriptionEdt;
	@FindBy(name = "amount[]")private WebElement amountEdt;
	@FindBy(xpath = "//input[@value='Submit']")private WebElement subminBtn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")private WebElement searchBarEdt;
	@FindBy(xpath = "//select[@name='example1_length']")private WebElement showDropDown;
	@FindBy(xpath = "//a[@class='btn btn-info btn-xs']")private List<WebElement> viewDetailsBtn;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[1]")private WebElement teacherPettyCashDescriptionTxt;
	@FindBy(xpath = "(//div[@class='msk-heading']//button[@class='close'])[2]")private WebElement closeBtn;
	@FindBy(xpath = "//tbody/tr[1]/td[5]")private WebElement paidTxt;
	@FindBy(xpath = "//div[@id='insert_Success']")private WebElement successPopUp;
	//initialization
	public TeacherPettyCashPreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getAddBtn() {
		return addBtn;
	}
	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}
	public WebElement getAmountEdt() {
		return amountEdt;
	}
	public WebElement getSubminBtn() {
		return subminBtn;
	}
	public WebElement getSearchBarEdt() {
		return searchBarEdt;
	}
	public WebElement getShowDropDown() {
		return showDropDown;
	}
	public List<WebElement> getTeacherPettycashdetailsList() {
		return viewDetailsBtn;
	}
	public WebElement getTeacherPettyCashDescriptionTxt() {
		return teacherPettyCashDescriptionTxt;
	}
	public WebElement getCloseBtn() {
		return closeBtn;
	}
	public List<WebElement> getViewDetailsBtn() {
		return viewDetailsBtn;
	}
	public WebElement getPaidTxt() {
		return paidTxt;
	}
	public WebElement getSuccessPopUp() {
		return successPopUp;
	}
	//generic methods
	/**
	 * this method is used to add pettycash request
	 * @param description
	 */
	public void createPettycashRequest(WebDriver driver,WebDriverutility wutil,String description,String amount)
	{    addBtn.click();
		DescriptionEdt.sendKeys(description);
		amountEdt.sendKeys(amount);
		subminBtn.click();
		wutil.waitTillElementToInvisibility(driver, successPopUp);
		
	}
	public String fetchCreatedPettyCashDetails(WebDriver driver,String currentdate,WebDriverutility wutil,String value,String description,String amount)
	{
		searchBarEdt.sendKeys(currentdate);
		wutil.selectElementInDropDown(showDropDown, value);
		String pettyCashDetails="";
		for(int i=0;i<viewDetailsBtn.size();i++)
		{
			viewDetailsBtn.get(i).click();
			pettyCashDetails=teacherPettyCashDescriptionTxt.getText();
			if (pettyCashDetails.contains(description)&&pettyCashDetails.contains(""+amount+""))
			{wutil.waitTillElementToBeClickable(driver, closeBtn);
				closeBtn.click();
				break;
			}
			closeBtn.click();
		}
		return pettyCashDetails;
		
		
	}
	public String fetchPaidDetails(WebDriver driver,String currentdate,WebDriverutility wutil,String value,String description,String amount)
	{
		searchBarEdt.sendKeys(currentdate);
		wutil.selectElementInDropDown(showDropDown, value);
		String pettyCashDetails="";
		String paidDetails="";
		for(int i=0;i<viewDetailsBtn.size();i++)
		{
			viewDetailsBtn.get(i).click();
			wutil.waitTilltextToBePresentInElement(driver, teacherPettyCashDescriptionTxt, amount);
			pettyCashDetails=teacherPettyCashDescriptionTxt.getText();
			if (pettyCashDetails.contains(description)&&pettyCashDetails.contains(amount))
				
			{
				closeBtn.click();
			paidDetails=paidTxt.getText();
			//System.out.println(paidDetails);
				break;
			}
			closeBtn.click();
		}
		return paidDetails;
	}
}
