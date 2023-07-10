package com.edu.ObjectRepository;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtilities.WebDriverutility;

public class AdminPettyCashPreviewPage {
	//declaration
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")private WebElement addBtn;
	@FindBy(xpath = "//input[@class='_desc form-control']")private WebElement DescriptionEdt;
	@FindBy(name = "amount[]")private WebElement amountEdt;
	@FindBy(xpath = "//input[@value='Submit']")private WebElement submitBtn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")private WebElement searchBtn;
	@FindBy(xpath = "//select[@name='example1_length']")private WebElement showDorpDown;
	@FindBy(xpath = "//a[@class='btn btn-info btn-xs']")private List<WebElement> viewDetailsBtn;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[1]")private WebElement PettyCashDescriptionTxt;
	@FindBy(xpath = "(//div[@class='msk-heading']//button[@class='close'])[2]")private WebElement closeIcon;
	@FindBy(xpath = "//a[.='Approve']")private WebElement approveBtn;
	@FindBy(xpath = "//a[@id='btnYesApprove']")private WebElement yesApproveBtn;
	
	@FindAll({@FindBy(xpath = "//span[@class='hidden-xs']"),@FindBy(xpath = "//span[.='Ingenious Developer1']")})private WebElement userMenuLnk;
	@FindBy(xpath = "//a[.='Sign out']")private WebElement signOutBtn;
	
	//initialization
	public AdminPettyCashPreviewPage(WebDriver driver)
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

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getShowDorpDown() {
		return showDorpDown;
	}

	public List<WebElement> getPettycashdetails() {
		return viewDetailsBtn;
	}

	public WebElement getPettyCashDescription() {
		return PettyCashDescriptionTxt;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}

	public WebElement getYesApproveBtn() {
		return yesApproveBtn;
	}
	public List<WebElement> getViewDetailsBtn() {
		return viewDetailsBtn;
	}
	public WebElement getPettyCashDescriptionTxt() {
		return PettyCashDescriptionTxt;
	}
	public WebElement getUserMenuLnk() {
		return userMenuLnk;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	//generic methods
	public String fetchPettyCashDetails(String teacherName,WebDriverutility wutil,String value,String description,String amount)
	{
		searchBtn.sendKeys(teacherName);
		wutil.selectElementInDropDown(showDorpDown, value);
		String pettyCashDetails="";
		for(int i=0;i<viewDetailsBtn.size();i++)
		{
			viewDetailsBtn.get(i).click();
			pettyCashDetails=PettyCashDescriptionTxt.getText();
			if (pettyCashDetails.contains(description)&&pettyCashDetails.contains(""+amount+""))
			{closeIcon.click();
				break;
			}
		}
		return pettyCashDetails;
	}
	public AdminPettyCashPreviewPage approvePettyCash(WebDriverutility wutil,WebDriver driver)
	{
		approveBtn.click();
		wutil.waitTillElementToBeClickable(driver, yesApproveBtn);
		yesApproveBtn.click();
		
		return new AdminPettyCashPreviewPage(driver);
	}
	
	
	
	public void signOutAdminLogin(WebDriverutility wutil,WebDriver driver) 
	{	
	try {
		getUserMenuLnk().click();
		getSignOutBtn().click();
	}
	catch (StaleElementReferenceException e) {
		getUserMenuLnk().click();
		getSignOutBtn().click();
	}
	}

}
