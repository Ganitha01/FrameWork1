package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherTimeTablePreviewPage {
	//declaration
@FindBy(xpath = "//tbody/tr[1]/td[2]")private WebElement createdTimeTableDetailsTxt;
//initialization
public TeacherTimeTablePreviewPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getCreatedTimeTableDetailsTxt() {
	return createdTimeTableDetailsTxt;
}
//generic metode

public String fetchCreatedTimeTableDetails()
{
	String createdTimeTableDetails=createdTimeTableDetailsTxt.getText();
	return createdTimeTableDetails;
}
}
